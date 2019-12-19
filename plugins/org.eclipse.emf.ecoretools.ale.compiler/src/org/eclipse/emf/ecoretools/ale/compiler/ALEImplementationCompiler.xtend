package org.eclipse.emf.ecoretools.ale.compiler

import java.io.File
import java.io.FileNotFoundException
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.jobs.Job
import org.eclipse.emf.ecoretools.ale.compiler.common.EcoreUtils
import org.eclipse.emf.ecoretools.ale.compiler.common.JavaPoetUtils
import org.eclipse.emf.ecoretools.ale.compiler.common.ServicesRegistrationManager
import org.eclipse.emf.ecoretools.ale.compiler.emfswitch.ALESwitchImplementationCompiler
import org.eclipse.emf.ecoretools.ale.compiler.legacy.interpreter.ALEInterpreterImplementationCompiler
import org.eclipse.emf.ecoretools.ale.compiler.revisitor.ALERevisitorImplementationCompiler
import org.eclipse.emf.ecoretools.ale.compiler.legacy.visitor.ALEVisitorImplementationCompiler
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl
import org.eclipse.emf.ecoretools.ale.compiler.utils.CompilerDsl

class ALEImplementationCompiler {


	extension CompilerDsl compilerDsl = new CompilerDsl
	
	/**
	 * 
	 * @param dslStr absolute path to the dsl file
	 * @param projectRoot absolute path to the project root
	 * @param projectName project name
	 */
	def void compile(String dslStr, File projectRoot, String projectName,
		ServicesRegistrationManager srm) throws FileNotFoundException {

		val Job a = Job.create('''ALE Compilation''', [ monitor |
			val ewd = new EclipseWorkbenchDsl(dslStr)
			mavenCompile(projectRoot, projectName, srm, ewd);
		])
		// FIXME: currently locking the whole workspace during compilation
		a.rule = ResourcesPlugin.workspace.root
		a.schedule
	}

	def void mavenCompile(String dslStr, File projectRoot, String projectName, ServicesRegistrationManager srm,
		String platformLocation) throws FileNotFoundException, RuntimeException {
		val dsl = new MavenWorkbenchDsl(dslStr, platformLocation)
		mavenCompile(projectRoot, projectName, srm, dsl);
	}

	/**
	 * 
	 * @param dslStr absolute path to the dsl file
	 * @param projectRoot absolute path to the project root
	 * @param projectName project name
	 */
	def void mavenCompile(File projectRoot, String projectName, ServicesRegistrationManager srm,
		Dsl dsl) throws FileNotFoundException, RuntimeException {

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
