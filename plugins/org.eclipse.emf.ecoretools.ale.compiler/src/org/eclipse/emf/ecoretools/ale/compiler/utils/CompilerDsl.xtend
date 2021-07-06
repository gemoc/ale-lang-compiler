package org.eclipse.emf.ecoretools.ale.compiler.utils

import java.io.File
import java.util.Map
import java.util.stream.Collectors
import org.eclipse.emf.ecoretools.ale.core.env.IAleEnvironment

class CompilerDsl {

	Map<IAleEnvironment, String> compilationType = newHashMap
	Map<IAleEnvironment, String> sourceFileName = newHashMap
	Map<IAleEnvironment, String> rootPackage = newHashMap
	Map<IAleEnvironment, Boolean> isTruffle = newHashMap

	def String compilationType(IAleEnvironment dsl) {
		if (!compilationType.containsKey(dsl))
			compilationType.put(dsl, dsl.getProperty("compilationType").or("") as String)
		compilationType.get(dsl)
	}

//	def String sourceFileName(IAleEnvironment dsl) {
//		if (!sourceFileName.containsKey(dsl)) {
//			val sections = new File(dsl.sourceFile).getName().split("\\.");
//			val s = newArrayList
//			for (var int i = 0; i < sections.length - 1; i++) {
//				s.add(sections.get(i));
//			}
//			val res = s.stream().collect(Collectors.joining("."));
//			sourceFileName.put(dsl, res)
//		}
//		sourceFileName.get(dsl)
//	}

	def String rootPackage(IAleEnvironment dsl) {
		if (!rootPackage.containsKey(dsl)) {
			rootPackage.put(dsl, dsl.getProperty("rootPackage").or("") as String)
		}

		rootPackage.get(dsl)
	}

	def boolean isTruffle(IAleEnvironment dsl) {
		if (!isTruffle.containsKey(dsl)) {
			isTruffle.put(dsl, dsl.getProperty("truffle").or("false").equals("true"))
		}
		isTruffle.get(dsl)
	}

}
