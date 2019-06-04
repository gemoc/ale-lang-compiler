package org.eclipse.emf.ecoretools.ale.compiler.emfswitch

import java.io.File
import java.nio.file.Files
import java.util.Comparator
import java.util.Map
import org.eclipse.emf.ecoretools.ale.compiler.common.AbstractALECompiler
import org.eclipse.emf.ecoretools.ale.compiler.common.EcoreUtils
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl

class ALESwitchImplementationCompiler extends AbstractALECompiler {

	new(String projectName, File projectRoot, Dsl dsl, EcoreUtils eu) {
		this(projectName, projectRoot, dsl, newHashMap, eu)
	}

	new(String projectName, File projectRoot, Dsl dsl, Map<String, Class<?>> services, EcoreUtils eu) {
		super(projectName, projectRoot, dsl, services, eu)
		
	}

	override compile(File projectRoot, String projectName) {
		val compileDirectory = new File(projectRoot, "switch-comp")
		
		// clean previous compilation
		if (compileDirectory.exists)
			Files.walk(compileDirectory.toPath).sorted(Comparator.reverseOrder()).map[toFile].forEach[delete]

		val String packageRoot = dsl.dslProp.get("rootPackage") as String
		
		val snu = new SwitchNamingUtils(resolved.head.genCls.genPackage)

		val sic = new SwitchImplementationCompiler(compileDirectory, syntaxes, packageRoot, resolved, snu)

		sic.compile

		val soc = new SwitchOperationCompiler(packageRoot, compileDirectory, syntaxes, queryEnvironment,
			parsedSemantics, resolved, registeredServices, dsl, snu)

		resolved.filter[it.eCls.instanceClassName != "java.util.Map$Entry"].forEach [ resolved |
			soc.compile(resolved)
		]

	}
}
