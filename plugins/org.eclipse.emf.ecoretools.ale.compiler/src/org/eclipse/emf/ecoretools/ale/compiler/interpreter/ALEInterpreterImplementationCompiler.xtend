package org.eclipse.emf.ecoretools.ale.compiler.interpreter

import java.io.File
import java.nio.file.Files
import java.util.Comparator
import java.util.Map
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecoretools.ale.compiler.common.AbstractALECompiler
import org.eclipse.emf.ecoretools.ale.compiler.common.CommonCompilerUtils
import org.eclipse.emf.ecoretools.ale.compiler.common.EcoreUtils
import org.eclipse.emf.ecoretools.ale.compiler.common.JavaPoetUtils
import org.eclipse.emf.ecoretools.ale.compiler.genmodel.EcoreGenmodelCompiler
import org.eclipse.emf.ecoretools.ale.compiler.genmodel.FactoryImplementationCompiler
import org.eclipse.emf.ecoretools.ale.compiler.genmodel.FactoryInterfaceCompiler
import org.eclipse.emf.ecoretools.ale.compiler.genmodel.PackageImplementationCompiler
import org.eclipse.emf.ecoretools.ale.compiler.genmodel.PackageInterfaceCompiler
import org.eclipse.emf.ecoretools.ale.compiler.genmodel.TruffleHelper
import org.eclipse.emf.ecoretools.ale.compiler.utils.EnumeratorService
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl
import org.eclipse.emf.ecoretools.ale.core.validation.BaseValidator
import org.eclipse.emf.ecoretools.ale.core.validation.TypeValidator
import org.eclipse.emf.ecoretools.ale.compiler.common.ServicesRegistrationManager

class ALEInterpreterImplementationCompiler extends AbstractALECompiler {

	new(String projectName, File projectRoot, Dsl dsl, EcoreUtils eu, ServicesRegistrationManager srm) {
		this(projectName, projectRoot, dsl, newHashMap, eu, srm)
	}

	new(String projectName, File projectRoot, Dsl dsl,Map<String, Pair<String, String>> services, EcoreUtils eu, ServicesRegistrationManager srm) {
		super(projectName, projectRoot, dsl, services, eu, srm)
		
	}

	override void compile(File projectRoot, String projectName) {
		val compilationDirectory = "interpreter-comp"
		val compileDirectory = new File(projectRoot, compilationDirectory)

		// clean previous compilation
		if (compileDirectory.exists)
			Files.walk(compileDirectory.toPath).sorted(Comparator.reverseOrder()).map[toFile].forEach[delete]

		val String packageRoot = dsl.rootPackage

		val egc = new EcoreGenmodelCompiler(compilationDirectory, "interpreter")

		val namingUtils = new InterpreterNamingUtils
		val fic = new FactoryInterfaceCompiler(namingUtils)
		val ccu = new CommonCompilerUtils(namingUtils, resolved, dsl)
		val jpu = new JavaPoetUtils
		val th = new TruffleHelper(jpu)
		val fimplc = new FactoryImplementationCompiler(namingUtils, ccu, th, dsl)

		val pic = new PackageInterfaceCompiler(namingUtils)
		val pimplc = new PackageImplementationCompiler(namingUtils, dsl)

		val eic = new InterpreterEClassInterfaceCompiler(namingUtils, ccu)
		val es = new EnumeratorService
		val eimplc = new InterpreterEClassImplementationCompiler(packageRoot, resolved, ccu, es, th, dsl)

		egc.compileEcoreGenmodel(syntaxes.values.map[v|v.key].toList, compileDirectory.absolutePath, projectName)

		val base = new BaseValidator(queryEnvironment, #[new TypeValidator])
		base.validate(parsedSemantics)
		val isTruffle = dsl.isTruffle
		
		val tsu =  new InterpreterTypeSystemUtils(syntaxes, packageRoot, resolved, namingUtils, dsl)
		
		syntaxes.forEach [ key, pairEPackageGenModel |
			try {
				fic.compileFactoryInterface(pairEPackageGenModel.key, compileDirectory, packageRoot, dsl)
				fimplc.compileFactoryImplementation(pairEPackageGenModel.key, compileDirectory, packageRoot, isTruffle)

				pic.compilePackageInterface(pairEPackageGenModel.key, compileDirectory, packageRoot)
				pimplc.compilePackageImplementation(pairEPackageGenModel.key, compileDirectory, packageRoot)

				val eClassifiersLst = pairEPackageGenModel.key.allClassifiers
				for (EClassifier eclazz : eClassifiersLst.filter[!(it instanceof EDataType) || (it instanceof EEnum)]) {
					try {
						val rc = resolved.filter [
							it.eCls.name == eclazz.name && it.eCls.EPackage.name == eclazz.EPackage.name
						].head
						if(eclazz.instanceClassName != "java.util.Map$Entry" /* && ! dsl.isTruffle*/)
							eic.compileEClassInterface(eclazz, rc?.aleCls, compileDirectory, dsl, packageRoot)
						eimplc.compileEClassImplementation(eclazz, rc?.aleCls, compileDirectory, syntaxes, resolved,
							srm.registeredServices, dsl, base, tsu, namingUtils)
					} catch (Exception e) {
						e.printStackTrace
					}
				}

			} catch (Exception e) {
				e.printStackTrace
			}

		]
	}
}
