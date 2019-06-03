package org.tetrabox.minijava.xtext.fortest.validation

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject

import static extension org.eclipse.xtext.EcoreUtil2.*
import org.tetrabox.minijava.xtext.fortest.typing.MiniJavaTypeConformance
import miniJava.interpreter.miniJava.Member
import miniJava.interpreter.miniJava.Clazz
import miniJava.interpreter.miniJava.AccessLevel

class MiniJavaAccessibility {

	@Inject extension MiniJavaTypeConformance

	def isAccessibleFrom(Member member, EObject context) {
		val contextClass = context.getContainerOfType(Clazz)
		val memberClass = member.getContainerOfType(Clazz)
		switch (contextClass) {
			case contextClass === memberClass:
				true
			case contextClass.isSubclassOf(memberClass):
				member.access != AccessLevel.PRIVATE
			default:
				member.access == AccessLevel.PUBLIC
		}
	}
}
