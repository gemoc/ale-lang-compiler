package org.eclipse.emf.ecoretools.ale.compiler.genmodel

import com.squareup.javapoet.ClassName
import com.squareup.javapoet.MethodSpec
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl
import org.eclipse.emf.ecoretools.ale.compiler.common.JavaPoetUtils

class TruffleHelper {
	
	extension JavaPoetUtils jpu

	new(JavaPoetUtils jpu) {
		this.jpu = jpu
	}
	
	def addTruffleBoundaryAnnotation(MethodSpec.Builder builder, Dsl dsl) {
		builder.addTruffleBoundaryAnnotation(dsl !== null && dsl.isTruffle)
	}
	
	def addTruffleBoundaryAnnotation(MethodSpec.Builder builder, boolean isTruffle) {
		builder.applyIfTrue(isTruffle, [
			addAnnotation(ClassName.get("com.oracle.truffle.api.CompilerDirectives", "TruffleBoundary"))
		])
	}
}
