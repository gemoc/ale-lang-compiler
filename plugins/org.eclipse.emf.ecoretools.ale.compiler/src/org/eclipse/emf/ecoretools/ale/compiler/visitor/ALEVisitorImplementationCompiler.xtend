package org.eclipse.emf.ecoretools.ale.compiler.visitor

import java.io.File
import java.nio.file.Files
import java.util.Comparator
import java.util.List
import java.util.Map
import org.eclipse.acceleo.query.ast.AstPackage
import org.eclipse.acceleo.query.runtime.IQueryEnvironment
import org.eclipse.core.runtime.IStatus
import org.eclipse.core.runtime.Status
import org.eclipse.emf.codegen.ecore.genmodel.GenClass
import org.eclipse.emf.codegen.ecore.genmodel.GenModel
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl
import org.eclipse.emf.ecoretools.ale.compiler.EcoreUtils
import org.eclipse.emf.ecoretools.ale.compiler.common.AbstractALECompiler
import org.eclipse.emf.ecoretools.ale.compiler.common.ResolvedClass
import org.eclipse.emf.ecoretools.ale.compiler.genmodel.FactoryImplementationCompiler
import org.eclipse.emf.ecoretools.ale.compiler.genmodel.PackageImplementationCompiler
import org.eclipse.emf.ecoretools.ale.compiler.genmodel.PackageInterfaceCompiler
import org.eclipse.emf.ecoretools.ale.core.interpreter.ExtensionEnvironment
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl
import org.eclipse.emf.ecoretools.ale.core.parser.DslBuilder
import org.eclipse.emf.ecoretools.ale.core.parser.visitor.ParseResult
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass
import org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit

class ALEVisitorImplementationCompiler extends AbstractALECompiler {

	extension EcoreUtils = new EcoreUtils

	var List<ParseResult<ModelUnit>> parsedSemantics
	val IQueryEnvironment queryEnvironment
	var Map<String, Pair<EPackage, GenModel>> syntaxes
	var Dsl dsl
	var List<ResolvedClass> resolved

	new() {
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

	def IStatus compile(String projectName, File projectRoot, Dsl dsl) {
		this.dsl = dsl
		parsedSemantics = new DslBuilder(queryEnvironment).parse(dsl)

		registerServices(projectName, parsedSemantics)

		// must be last !
		compile(projectRoot, projectName)
		
		Status.OK_STATUS
	}


	def private void compile(File projectRoot, String projectName) {
		val compileDirectory = new File(projectRoot, "visitor-comp")

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

		val egc = new EcoreGenmodelCompiler

		val vnu = new VisitorNamingUtils
		val fic = new FactoryInterfaceCompiler
		val fimplc = new FactoryImplementationCompiler(vnu)

		val pic = new PackageInterfaceCompiler(vnu)
		val pimplc = new PackageImplementationCompiler(vnu)

		val acceptInterfaceCompiler = new AcceptInterfaceCompiler(compileDirectory, packageRoot)
		acceptInterfaceCompiler.compile

		val visitorInterfaceCompiler = new VisitorInterfaceCompiler(compileDirectory, syntaxes, packageRoot)
		visitorInterfaceCompiler.compile

		val visitorImplementationCompiler = new VisitorImplementationCompiler(compileDirectory, syntaxes, packageRoot)
		visitorImplementationCompiler.compile

		val eic = new EClassInterfaceCompiler
		val eimplc = new EClassImplementationCompiler(packageRoot, dsl)

		val operationInterfaceCompiler = new OperationInterfaceCompiler(compileDirectory, packageRoot, syntaxes)
		val operationImplementationCompiler = new OperationImplementationCompiler(compileDirectory, packageRoot,
			syntaxes, queryEnvironment, parsedSemantics, resolved, registeredServices)

		egc.compileEcoreGenmodel(syntaxes.values.map[v|v.key].toList, compileDirectory.absolutePath, projectName)

		// TODO: generate ecore + genmodel !
		syntaxes.forEach [ key, pairEPackageGenModel |
			fic.compileFactoryInterface(pairEPackageGenModel.key, compileDirectory, packageRoot)
			fimplc.compileFactoryImplementation(pairEPackageGenModel.key, compileDirectory, packageRoot)

			pic.compilePackageInterface(pairEPackageGenModel.key, compileDirectory, packageRoot)
			pimplc.compilePackageImplementation(pairEPackageGenModel.key, compileDirectory, packageRoot)

			for (EClass eclazz : pairEPackageGenModel.key.allClasses) {
				val rc = resolved.filter[it.eCls.name == eclazz.name && it.eCls.EPackage.name == eclazz.EPackage.name].
					head
				eic.compileEClassInterface(eclazz, rc?.aleCls, compileDirectory, dsl, packageRoot)
				eimplc.compileEClassImplementation(eclazz, compileDirectory)
				operationInterfaceCompiler.compile(eclazz, rc?.aleCls)
				operationImplementationCompiler.compile(eclazz, rc?.aleCls)
			}

		]
	}

	def List<ResolvedClass> resolve(List<ExtendedClass> aleClasses, EPackage syntax) {
		syntax.allClasses.map [ eClass |
			val aleClass = aleClasses.filter [
				it.name == eClass.name || it.name == eClass.EPackage.name + '.' + eClass.name
			].head
			val GenClass gl = syntaxes.filter[k, v|v.key.allClasses.contains(eClass)].values.map[value].map [
				it.genPackages.map[it.genClasses].flatten
			].flatten.filter[it.ecoreClass == eClass].head
			if(gl === null) throw new RuntimeException('''gl is null''')
			new ResolvedClass(aleClass, eClass, gl)
		]
	}
}
