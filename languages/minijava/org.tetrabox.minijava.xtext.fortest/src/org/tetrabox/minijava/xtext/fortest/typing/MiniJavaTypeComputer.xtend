package org.tetrabox.minijava.xtext.fortest.typing

import miniJava.interpreter.miniJava.Assignment
import miniJava.interpreter.miniJava.BoolConstant
import miniJava.interpreter.miniJava.BooleanTypeRef
import miniJava.interpreter.miniJava.ClassRef
import miniJava.interpreter.miniJava.Clazz
import miniJava.interpreter.miniJava.Expression
import miniJava.interpreter.miniJava.FieldAccess
import miniJava.interpreter.miniJava.IntConstant
import miniJava.interpreter.miniJava.IntegerTypeRef
import miniJava.interpreter.miniJava.Method
import miniJava.interpreter.miniJava.MethodCall
import miniJava.interpreter.miniJava.MiniJavaFactory
import miniJava.interpreter.miniJava.MiniJavaPackage
import miniJava.interpreter.miniJava.NewObject
import miniJava.interpreter.miniJava.Null
import miniJava.interpreter.miniJava.Return
import miniJava.interpreter.miniJava.StringConstant
import miniJava.interpreter.miniJava.StringTypeRef
import miniJava.interpreter.miniJava.Super
import miniJava.interpreter.miniJava.SymbolRef
import miniJava.interpreter.miniJava.This
import miniJava.interpreter.miniJava.TypeDeclaration
import miniJava.interpreter.miniJava.TypeRef
import miniJava.interpreter.miniJava.VariableDeclaration
import miniJava.interpreter.miniJava.VoidTypeRef
import static extension org.eclipse.xtext.EcoreUtil2.*


class MiniJavaTypeComputer {
	private static val factory = MiniJavaFactory.eINSTANCE
	public static val STRING_TYPE = factory.createClazz => [name = 'stringType']
	public static val INT_TYPE = factory.createClazz => [name = 'intType']
	public static val BOOLEAN_TYPE = factory.createClazz => [name = 'booleanType']
	public static val NULL_TYPE = factory.createClazz => [name = 'nullType']

	static val ep = MiniJavaPackage.eINSTANCE

	def TypeDeclaration getType(TypeRef r) {
		switch r {
			ClassRef: r.referencedClass
			IntegerTypeRef: INT_TYPE
			BooleanTypeRef: BOOLEAN_TYPE
			StringTypeRef: STRING_TYPE
			VoidTypeRef : NULL_TYPE
		}
	}

	def TypeDeclaration typeFor(Expression e) {
		switch (e) {
			SymbolRef:
				e.symbol.typeRef.type
			FieldAccess:
				e.field.typeRef.type
			MethodCall:
				e.method.typeRef.type
			NewObject:
				e.type
			This:
				e.getContainerOfType(Clazz)
			Super:
				e.getContainerOfType(Clazz).superClass
			Null:
				NULL_TYPE
			StringConstant:
				STRING_TYPE
			IntConstant:
				INT_TYPE
			BoolConstant:
				BOOLEAN_TYPE
		}
	}


	def isPrimitive(TypeDeclaration c) {
		c.eResource === null
	}

	def TypeDeclaration expectedType(Expression e) {
		val c = e.eContainer
		val f = e.eContainingFeature
		switch (c) {
			VariableDeclaration:
				c.typeRef.type
			Assignment case f == ep.assignment_Value: {
				val assignee = c.assignee
				switch (assignee) {
					VariableDeclaration: assignee.typeRef.type
					FieldAccess: assignee.typeFor
				}
			}
			Return:
				c.getContainerOfType(Method).typeRef.type
			case f == ep.ifStatement_Expression:
				BOOLEAN_TYPE
			MethodCall case f == ep.methodCall_Args: {
				if (c.method !== null) {
				if (c.method.params.size > c.args.indexOf(e))
					c.method.params.get(c.args.indexOf(e)).typeRef.type
				}
			}
			NewObject case f == ep.newObject_Args: {
				c.type.members.filter(Method).findFirst[it.name === null && it.params.size === c.args.size].params.get(c.args.indexOf(e)).typeRef.type
			}
		}
	}
}
