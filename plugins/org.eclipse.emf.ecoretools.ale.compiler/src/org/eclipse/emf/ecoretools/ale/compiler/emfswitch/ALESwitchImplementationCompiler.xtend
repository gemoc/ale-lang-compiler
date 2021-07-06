package org.eclipse.emf.ecoretools.ale.compiler.emfswitch

import java.io.File
import java.nio.file.Files
import java.util.Comparator
import java.util.Map
import org.eclipse.emf.ecoretools.ale.compiler.common.AbstractALECompiler
import org.eclipse.emf.ecoretools.ale.compiler.common.EcoreUtils
import org.eclipse.emf.ecoretools.ale.compiler.common.ServicesRegistrationManager
import org.eclipse.emf.ecoretools.ale.compiler.utils.CompilerDsl
import org.eclipse.emf.ecoretools.ale.core.env.IAleEnvironment

class ALESwitchImplementationCompiler extends AbstractALECompiler {

	extension CompilerDsl compilerDsl = new CompilerDsl

	new(String projectName, File projectRoot, IAleEnvironment dsl, EcoreUtils eu, ServicesRegistrationManager srm) {
		this(projectName, projectRoot, dsl, newHashMap, eu, srm)
	}

	new(String projectName, File projectRoot, IAleEnvironment dsl, Map<String, Pair<String, String>> services, EcoreUtils eu,
		ServicesRegistrationManager srm) {
		super(projectName, projectRoot, dsl, services, eu, srm)

	}

	override compile(File projectRoot, String projectName) {
		val compileDirectory = new File(projectRoot, "switch-comp")

		// clean previous compilation
		if (compileDirectory.exists)
			Files.walk(compileDirectory.toPath).sorted(Comparator.reverseOrder()).map[toFile].forEach[delete]

		val String packageRoot = dsl.rootPackage

		val snu = new SwitchNamingUtils(resolved.head.genCls.genPackage)

		val sic = new SwitchImplementationCompiler(compileDirectory, syntaxes, packageRoot, resolved, snu)

		sic.compile

		val soc = new SwitchOperationCompiler(packageRoot, compileDirectory, syntaxes, queryEnvironment,
			parsedSemantics, resolved, srm.registeredServices, dsl, snu)

		resolved.filter[it.eCls.instanceClassName != "java.util.Map$Entry"].forEach [ resolved |
			soc.compile(resolved)
		]

	}
}
