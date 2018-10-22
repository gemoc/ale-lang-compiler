package org.eclipse.emf.ecoretools.ale.compiler

import java.io.File
import java.io.FileNotFoundException
import org.eclipse.emf.ecoretools.ale.ide.WorkbenchDsl

class ALEImplementationCompiler {

	def void compile(String dslStr, File projectRoot, String projectName) throws FileNotFoundException {
		val dsl = new WorkbenchDsl(dslStr)
		val compilationType = dsl.dslProp.getProperty("compilationType")?.toLowerCase
		if (compilationType !== null) {
			switch compilationType {
				case "revisitor":
					new ALERevisitorImplementationCompiler().compile(projectName, projectRoot, dsl)
				case "visitor":
					new ALEVisitorImplementationCompiler().compile
				case "interpreter":
					new ALEInterpreterImplementationCompiler().compile
				default:
					throw new RuntimeException('''value «compilationType» unknown for "compilationType" key in «dsl.sourceFileName».''')
			}
		} else {
			throw new RuntimeException('''"compilationType" key not defined in «dsl.sourceFileName».''')
		}

	}

}
