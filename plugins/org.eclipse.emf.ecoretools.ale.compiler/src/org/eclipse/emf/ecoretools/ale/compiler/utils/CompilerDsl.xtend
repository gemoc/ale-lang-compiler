package org.eclipse.emf.ecoretools.ale.compiler.utils

import java.io.File
import java.util.Map
import java.util.stream.Collectors
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl

class CompilerDsl {

	Map<Dsl, String> compilationType = newHashMap
	Map<Dsl, String> sourceFileName = newHashMap
	Map<Dsl, String> rootPackage = newHashMap
	Map<Dsl, Boolean> isTruffle = newHashMap

	def String compilationType(Dsl dsl) {
		if (!compilationType.containsKey(dsl))
			compilationType.put(dsl, dsl.dslProp.getOrDefault("compilationType", "") as String)
		compilationType.get(dsl)
	}

	def String sourceFileName(Dsl dsl) {
		if (!sourceFileName.containsKey(dsl)) {
			val sections = new File(dsl.sourceFile).getName().split("\\.");
			val s = newArrayList
			for (var int i = 0; i < sections.length - 1; i++) {
				s.add(sections.get(i));
			}
			val res = s.stream().collect(Collectors.joining("."));
			sourceFileName.put(dsl, res)
		}
		sourceFileName.get(dsl)
	}

	def String rootPackage(Dsl dsl) {
		if (!rootPackage.containsKey(dsl)) {
			rootPackage.put(dsl, dsl.dslProp.getOrDefault("rootPackage", "") as String)
		}

		rootPackage.get(dsl)
	}

	def boolean isTruffle(Dsl dsl) {
		if (!isTruffle.containsKey(dsl)) {
			isTruffle.put(dsl, dsl.dslProp.getOrDefault("truffle", "false").equals("true"))
		}
		isTruffle.get(dsl)
	}

}
