package org.eclipse.emf.ecoretools.ale.compiler.interpreter

import java.io.File
import java.nio.file.Files
import java.util.Comparator
import java.util.List
import java.util.Map
import org.eclipse.acceleo.query.ast.AstPackage
import org.eclipse.acceleo.query.runtime.IQueryEnvironment
import org.eclipse.core.runtime.IStatus
import org.eclipse.core.runtime.Status
import org.eclipse.emf.codegen.ecore.genmodel.GenModel
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl
import org.eclipse.emf.ecoretools.ale.compiler.common.AbstractALECompiler
import org.eclipse.emf.ecoretools.ale.compiler.common.EcoreUtils
import org.eclipse.emf.ecoretools.ale.compiler.common.ResolvedClass
import org.eclipse.emf.ecoretools.ale.compiler.genmodel.EcoreGenmodelCompiler
import org.eclipse.emf.ecoretools.ale.compiler.genmodel.FactoryImplementationCompiler
import org.eclipse.emf.ecoretools.ale.compiler.genmodel.FactoryInterfaceCompiler
import org.eclipse.emf.ecoretools.ale.compiler.genmodel.PackageImplementationCompiler
import org.eclipse.emf.ecoretools.ale.compiler.genmodel.PackageInterfaceCompiler
import org.eclipse.emf.ecoretools.ale.core.interpreter.ExtensionEnvironment
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl
import org.eclipse.emf.ecoretools.ale.core.parser.DslBuilder
import org.eclipse.emf.ecoretools.ale.core.parser.visitor.ParseResult
import org.eclipse.emf.ecoretools.ale.core.validation.BaseValidator
import org.eclipse.emf.ecoretools.ale.core.validation.TypeValidator
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass
import org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit

class ALEInterpreterImplementationCompiler extends AbstractALECompiler {

	extension EcoreUtils = new EcoreUtils

	var List<ParseResult<ModelUnit>> parsedSemantics
	val IQueryEnvironment queryEnvironment
	var Map<String, Pair<EPackage, GenModel>> syntaxes
	var Dsl dsl
	var List<ResolvedClass> resolved

	new() {
		this(newHashMap)
	}

	new(Map<String, Class<?>> services) {
		super(services)
		this.queryEnvironment = createQueryEnvironment(false, null)
		queryEnvironment.registerEPackage(ImplementationPackage.eINSTANCE)
		queryEnvironment.registerEPackage(AstPackage.eINSTANCE)
	}

	def private IQueryEnvironment createQueryEnvironment(boolean b, Object object) {
		val IQueryEnvironment newEnv = new ExtensionEnvironment()
		newEnv.registerEPackage(EcorePackage.eINSTANCE)
		newEnv.registerCustomClassMapping(EcorePackage.eINSTANCE.getEStringToStringMapEntry(),
			EStringToStringMapEntryImpl)
		newEnv
	}

	def IStatus compile(String projectName, File projectRoot, Dsl dsl, Map<String, Class<?>> services) {
		this.dsl = dsl
		parsedSemantics = new DslBuilder(queryEnvironment).parse(dsl)

		if (services !== null && !services.empty) {
			this.registeredServices.putAll(services)
		} else {
			registerServices(projectName, parsedSemantics)
		}

		// must be last !
		compile(projectRoot, projectName)

		Status.OK_STATUS
	}

	def private void compile(File projectRoot, String projectName) {
		val compilationDirectory = "interpreter-comp"
		val compileDirectory = new File(projectRoot, compilationDirectory)

		// clean previous compilation
		if (compileDirectory.exists)
			Files.walk(compileDirectory.toPath).sorted(Comparator.reverseOrder()).map[toFile].forEach[delete]

		val aleClasses = newArrayList
		for (ParseResult<ModelUnit> pr : parsedSemantics) {
			var root = pr.root
			aleClasses += root.classExtensions
		}

		// load all syntaxes in a cache
		syntaxes = dsl.allSyntaxes.toMap([it], [(loadEPackage -> replaceAll(".ecore$", ".genmodel").loadGenmodel)])
		val syntax = syntaxes.get(dsl.allSyntaxes.head).key
		resolved = resolve(aleClasses, syntax)

		val String packageRoot = dsl.dslProp.get("rootPackage") as String

		val egc = new EcoreGenmodelCompiler(compilationDirectory, "interpreter")

		val inu = new InterpreterNamingUtils
		val fic = new FactoryInterfaceCompiler(inu)
		val fimplc = new FactoryImplementationCompiler(inu)

		val pic = new PackageInterfaceCompiler(inu)
		val pimplc = new PackageImplementationCompiler(inu)

		val eic = new InterpreterEClassInterfaceCompiler(inu)
		val eimplc = new InterpreterEClassImplementationCompiler(packageRoot, resolved)

		egc.compileEcoreGenmodel(syntaxes.values.map[v|v.key].toList, compileDirectory.absolutePath, projectName)

		val base = new BaseValidator(queryEnvironment, #[new TypeValidator])
		base.validate(parsedSemantics)
		val isTruffle = dsl.dslProp.getProperty('truffle', "false") == "true"
		syntaxes.forEach [ key, pairEPackageGenModel |
			try {
				fic.compileFactoryInterface(pairEPackageGenModel.key, compileDirectory, packageRoot)
				fimplc.compileFactoryImplementation(pairEPackageGenModel.key, compileDirectory, packageRoot, isTruffle)

				pic.compilePackageInterface(pairEPackageGenModel.key, compileDirectory, packageRoot)
				pimplc.compilePackageImplementation(pairEPackageGenModel.key, compileDirectory, packageRoot)

				val eClassifiersLst = pairEPackageGenModel.key.allClassifiers
				for (EClassifier eclazz : eClassifiersLst.filter[!(it instanceof EDataType) || (it instanceof EEnum)]) {
					try {
						val rc = resolved.filter [
							it.eCls.name == eclazz.name && it.eCls.EPackage.name == eclazz.EPackage.name
						].head
						eic.compileEClassInterface(eclazz, rc?.aleCls, compileDirectory, dsl, packageRoot)
						eimplc.compileEClassImplementation(eclazz, rc?.aleCls, compileDirectory, syntaxes, resolved,
							registeredServices, dsl, base)

					} catch (Exception e) {
						e.printStackTrace
					}
				}

			} catch (Exception e) {
				e.printStackTrace
			}

		]
	}

	def List<ResolvedClass> resolve(List<ExtendedClass> aleClasses, EPackage syntax) {
		syntax.allClassifiers.map [ eClass |
			val aleClass = aleClasses.filter [
				it.name == eClass.name || it.name == eClass.EPackage.name + '.' + eClass.name
			].head
			new ResolvedClass(aleClass, eClass) //, gl
		]
	}
}
