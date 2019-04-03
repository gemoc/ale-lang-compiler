package org.eclipse.emf.ecoretools.ale.compiler

import java.io.File
import java.io.FileNotFoundException
import org.eclipse.emf.ecoretools.ale.compiler.emfswitch.ALESwitchImplementationCompiler
import org.eclipse.emf.ecoretools.ale.compiler.interpreter.ALEInterpreterImplementationCompiler
import org.eclipse.emf.ecoretools.ale.compiler.revisitor.ALERevisitorImplementationCompiler
import org.eclipse.emf.ecoretools.ale.compiler.visitor.ALEVisitorImplementationCompiler
import org.eclipse.emf.ecoretools.ale.ide.WorkbenchDsl
import org.eclipse.core.runtime.jobs.Job
import org.eclipse.core.resources.ResourcesPlugin
import java.util.Map

class ALEImplementationCompiler {

	/**
	 * 
	 * @param dslStr absolute path to the dsl file
	 * @param projectRoot absolute path to the project root
	 * @param projectName project name
	 */
	def void compile(String dslStr, File projectRoot, String projectName, Map<String,Class<?>> services) throws FileNotFoundException {

		val Job a = Job.create('''ALE Compilation''', [ monitor |
			val dsl = new WorkbenchDsl(dslStr)
			val compilationType = dsl.dslProp.getProperty("compilationType")?.toLowerCase
			if (compilationType !== null) {
				switch compilationType {
					case "revisitor":
						new ALERevisitorImplementationCompiler().compile(projectName, projectRoot, dsl)
					case "interpreter":
						new ALEInterpreterImplementationCompiler().compile(projectName, projectRoot, dsl, services)
					case "visitor":
						new ALEVisitorImplementationCompiler().compile(projectName, projectRoot, dsl, services)
					case "switch":
						new ALESwitchImplementationCompiler().compile(projectName, projectRoot, dsl)
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
