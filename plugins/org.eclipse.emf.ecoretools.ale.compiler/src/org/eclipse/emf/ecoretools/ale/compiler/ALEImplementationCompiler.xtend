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
import org.eclipse.emf.ecoretools.ale.compiler.WorkbenchDsl
import org.eclipse.emf.ecoretools.ale.compiler.common.ServicesRegistrationManager
import org.eclipse.emf.ecoretools.ale.compiler.common.EclipseServiceRegistrationManager

class ALEImplementationCompiler {

	/**
	 * 
	 * @param dslStr absolute path to the dsl file
	 * @param projectRoot absolute path to the project root
	 * @param projectName project name
	 */
	def void compile(String dslStr, File projectRoot, String projectName) throws FileNotFoundException {
		val srm = new EclipseServiceRegistrationManager
		val Job a = Job.create('''ALE Compilation''', [ monitor |
			mavenCompile(dslStr, projectRoot, projectName, srm, "platform:/resource/");
		])
		// FIXME: currently locking the whole workspace during compilation
		a.rule = ResourcesPlugin.workspace.root
		a.schedule
	}

	/**
	 * 
	 * @param dslStr absolute path to the dsl file
	 * @param projectRoot absolute path to the project root
	 * @param projectName project name
	 */
	def void mavenCompile(String dslStr, File projectRoot, String projectName, ServicesRegistrationManager srm, String platformLocation) throws FileNotFoundException, RuntimeException {
		val dsl = new WorkbenchDsl(dslStr, platformLocation)
		val eu = new EcoreUtils
		val compilationType = dsl.compilationType.toLowerCase
		if (compilationType !== null) {
			switch compilationType {
				case "revisitor":
					new ALERevisitorImplementationCompiler(projectName, projectRoot, dsl, eu, new JavaPoetUtils, srm).
						compile()
				case "interpreter":
					new ALEInterpreterImplementationCompiler(projectName, projectRoot, dsl, eu, srm).compile()
				case "visitor":
					new ALEVisitorImplementationCompiler(projectName, projectRoot, dsl, eu, srm).compile()
				case "switch":
					new ALESwitchImplementationCompiler(projectName, projectRoot, dsl, eu, srm).compile()
				default:
					throw new RuntimeException('''value «compilationType» unknown for "compilationType" key in «dsl.sourceFileName».''')
			}
		} else {
			throw new RuntimeException('''"compilationType" key not defined in «dsl.sourceFileName».''')
		}
	}

}
