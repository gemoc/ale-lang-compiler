package org.eclipse.emf.ecoretools.ale.compiler

import java.io.File
import java.io.FileNotFoundException
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.jobs.Job
import org.eclipse.emf.ecoretools.ale.compiler.common.EcoreUtils
import org.eclipse.emf.ecoretools.ale.compiler.common.JavaPoetUtils
import org.eclipse.emf.ecoretools.ale.compiler.emfswitch.ALESwitchImplementationCompiler
import org.eclipse.emf.ecoretools.ale.compiler.interpreter.ALEInterpreterImplementationCompiler
import org.eclipse.emf.ecoretools.ale.compiler.revisitor.ALERevisitorImplementationCompiler
import org.eclipse.emf.ecoretools.ale.compiler.visitor.ALEVisitorImplementationCompiler
import org.eclipse.emf.ecoretools.ale.ide.WorkbenchDsl

class ALEImplementationCompiler {

	/**
	 * 
	 * @param dslStr absolute path to the dsl file
	 * @param projectRoot absolute path to the project root
	 * @param projectName project name
	 */
	def void compile(String dslStr, File projectRoot, String projectName) throws FileNotFoundException {

		val Job a = Job.create('''ALE Compilation''', [ monitor |
			val dsl = new WorkbenchDsl(dslStr)
			val eu = new EcoreUtils
			val compilationType = dsl.dslProp.getProperty("compilationType")?.toLowerCase
			if (compilationType !== null) {
				switch compilationType {
					case "revisitor":
						new ALERevisitorImplementationCompiler(projectName, projectRoot, dsl, eu, new JavaPoetUtils).compile()
					case "interpreter":
						new ALEInterpreterImplementationCompiler(projectName, projectRoot, dsl, eu).compile()
					case "visitor":
						new ALEVisitorImplementationCompiler(projectName, projectRoot, dsl, eu).compile()
					case "switch":
						new ALESwitchImplementationCompiler(projectName, projectRoot, dsl, eu).compile()
					default:
						throw new RuntimeException('''value «compilationType» unknown for "compilationType" key in «dsl.sourceFileName».''')
				}
			} else {
				throw new RuntimeException('''"compilationType" key not defined in «dsl.sourceFileName».''')
			}
		])
		// FIXME: currently locking the whole workspace during compilation
		a.rule = ResourcesPlugin.workspace.root
		a.schedule
	}

}
