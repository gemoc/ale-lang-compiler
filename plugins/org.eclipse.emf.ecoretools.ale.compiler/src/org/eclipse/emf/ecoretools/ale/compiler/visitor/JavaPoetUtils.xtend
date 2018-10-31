package org.eclipse.emf.ecoretools.ale.compiler.visitor

import org.eclipse.xtext.xbase.lib.Functions.Function1

class JavaPoetUtils {
	def <T> T applyIfTrue(T t, Boolean cond, Function1<T, T> app) {
		if (cond) {
			app.apply(t)
		} else {
			t
		}
	}
}
