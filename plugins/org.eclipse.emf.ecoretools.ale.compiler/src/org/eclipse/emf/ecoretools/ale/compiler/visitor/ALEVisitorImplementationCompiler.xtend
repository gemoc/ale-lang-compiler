package org.eclipse.emf.ecoretools.ale.compiler.visitor

import java.io.File
import java.nio.file.Files
import java.util.Comparator
import java.util.Map
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecoretools.ale.compiler.common.AbstractALECompiler
import org.eclipse.emf.ecoretools.ale.compiler.common.CommonCompilerUtils
import org.eclipse.emf.ecoretools.ale.compiler.common.EcoreUtils
import org.eclipse.emf.ecoretools.ale.compiler.common.JavaPoetUtils
import org.eclipse.emf.ecoretools.ale.compiler.common.ServicesRegistrationManager
import org.eclipse.emf.ecoretools.ale.compiler.genmodel.EcoreGenmodelCompiler
import org.eclipse.emf.ecoretools.ale.compiler.genmodel.FactoryImplementationCompiler
import org.eclipse.emf.ecoretools.ale.compiler.genmodel.FactoryInterfaceCompiler
import org.eclipse.emf.ecoretools.ale.compiler.genmodel.PackageImplementationCompiler
import org.eclipse.emf.ecoretools.ale.compiler.genmodel.PackageInterfaceCompiler
import org.eclipse.emf.ecoretools.ale.compiler.genmodel.TruffleHelper
import org.eclipse.emf.ecoretools.ale.compiler.utils.CompilerDsl
import org.eclipse.emf.ecoretools.ale.compiler.utils.EnumeratorService
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl

class ALEVisitorImplementationCompiler extends AbstractALECompiler {
	
	extension CompilerDsl compilerDsl = new CompilerDsl

	new(String projectName, File projectRoot, Dsl dsl, EcoreUtils eu, ServicesRegistrationManager srm) {
		this(projectName, projectRoot, dsl, newHashMap, eu, srm)
	}

	new(String projectName, File projectRoot, Dsl dsl, Map<String, Pair<String, String>> services, EcoreUtils eu, ServicesRegistrationManager srm) {
		super(projectName, projectRoot, dsl, services, eu, srm)
	}

	override compile(File projectRoot, String projectName) {
		val compilationDirectory = "visitor-comp"
		val compileDirectory = new File(projectRoot, compilationDirectory)

		// clean previous compilation
		if (compileDirectory.exists)
			Files.walk(compileDirectory.toPath).sorted(Comparator.reverseOrder()).map[toFile].forEach[delete]

		val String packageRoot = dsl.rootPackage

		val egc = new EcoreGenmodelCompiler(compilationDirectory, "interpreter")

		val namingUtils = new VisitorNamingUtils
		val fic = new FactoryInterfaceCompiler(namingUtils)
		val ccu = new CommonCompilerUtils(namingUtils, resolved, dsl)
		val jpu = new JavaPoetUtils
		val th = new TruffleHelper(jpu)
		val fimplc = new FactoryImplementationCompiler(namingUtils, ccu, th, dsl)

		val pic = new PackageInterfaceCompiler(namingUtils)
		val pimplc = new PackageImplementationCompiler(namingUtils, dsl)

		val acceptInterfaceCompiler = new AcceptInterfaceCompiler(compileDirectory, packageRoot)
		acceptInterfaceCompiler.compile

		val visitorInterfaceCompiler = new VisitorInterfaceCompiler(compileDirectory, syntaxes, packageRoot)
		visitorInterfaceCompiler.compile

		val visitorImplementationCompiler = new VisitorImplementationCompiler(compileDirectory, syntaxes, packageRoot)
		visitorImplementationCompiler.compile

		val eic = new VisitorEClassInterfaceCompiler(namingUtils, ccu)
		val es = new EnumeratorService
		val eimplc = new VisitorEClassImplementationCompiler(packageRoot, dsl, resolved, ccu, es)

		val operationInterfaceCompiler = new OperationInterfaceCompiler(compileDirectory, packageRoot, syntaxes, resolved)
		val operationImplementationCompiler = new OperationImplementationCompiler(compileDirectory, packageRoot,
			syntaxes, queryEnvironment, parsedSemantics, resolved, registeredServices, new EnumeratorService)

		egc.compileEcoreGenmodel(syntaxes.values.map[v|v.key].toList, compileDirectory.absolutePath, projectName)

		syntaxes.forEach [ key, pairEPackageGenModel |
			try {
				fic.compileFactoryInterface(pairEPackageGenModel.key, compileDirectory, packageRoot, dsl)
				fimplc.compileFactoryImplementation(pairEPackageGenModel.key, compileDirectory, packageRoot)

				pic.compilePackageInterface(pairEPackageGenModel.key, compileDirectory, packageRoot)
				pimplc.compilePackageImplementation(pairEPackageGenModel.key, compileDirectory, packageRoot)

				val eClassifiersLst = pairEPackageGenModel.key.allClassifiers
				for (EClassifier eclazz : eClassifiersLst.filter[!(it instanceof EDataType) || (it instanceof EEnum)]) {
					val rc = resolved.filter [
						it.eCls.name == eclazz.name && it.eCls.EPackage.name == eclazz.EPackage.name
					].head
					eic.compileEClassInterface(eclazz, compileDirectory, packageRoot)
					eimplc.compileEClassImplementation(eclazz, compileDirectory)
					if(eclazz instanceof EClass) {
						operationInterfaceCompiler.compile(eclazz, rc?.aleCls)
						operationImplementationCompiler.compile(eclazz, rc?.aleCls)
					}
				}
			} catch (Exception e) {
				e.printStackTrace
			}
		]
	}
}
