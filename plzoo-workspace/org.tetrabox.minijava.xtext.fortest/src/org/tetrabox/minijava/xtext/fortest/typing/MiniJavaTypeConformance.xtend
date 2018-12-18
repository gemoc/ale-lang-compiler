package org.tetrabox.minijava.xtext.fortest.typing

import com.google.inject.Inject
import miniJava.interpreter.miniJava.TypeDeclaration
import org.tetrabox.minijava.xtext.fortest.MiniJavaModelUtil

import static org.tetrabox.minijava.xtext.fortest.typing.MiniJavaTypeComputer.*

class MiniJavaTypeConformance {

	@Inject extension MiniJavaModelUtil

	def isConformant(TypeDeclaration c1, TypeDeclaration c2) {
		c1 === NULL_TYPE || // null can be assigned to everything
		c1 === c2 || c1.isSubclassOf(c2)
	}

	def isSubclassOf(TypeDeclaration c1, TypeDeclaration c2) {
		c1.classHierarchy.contains(c2)
	}
}
