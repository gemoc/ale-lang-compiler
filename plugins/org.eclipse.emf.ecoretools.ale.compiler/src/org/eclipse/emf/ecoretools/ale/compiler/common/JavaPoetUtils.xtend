package org.eclipse.emf.ecoretools.ale.compiler.common

import com.squareup.javapoet.MethodSpec
import com.squareup.javapoet.TypeName
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.xtext.xbase.lib.Functions.Function1

class JavaPoetUtils {
	
	def <T> T applyIfTrue(T t, Boolean cond, Function1<T, T> app) {
		if (cond) {
			app.apply(t)
		} else {
			t
		}
	}
	
	def MethodSpec.Builder openMethod(MethodSpec.Builder builder, TypeName type) {
		if (type !== null) {
			builder.addStatement('''$T result''', type)
		} else {
			builder
		}
	}
	
	def MethodSpec.Builder closeMethod(MethodSpec.Builder builder, EClassifier type) {
		if (type !== null) {
			builder.addStatement("return result")
		} else {
			builder
		}
	}
}