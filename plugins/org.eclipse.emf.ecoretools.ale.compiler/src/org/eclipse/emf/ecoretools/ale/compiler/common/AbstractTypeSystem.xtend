package org.eclipse.emf.ecoretools.ale.compiler.common

import com.squareup.javapoet.TypeName
import org.eclipse.acceleo.query.ast.Expression
import org.eclipse.acceleo.query.validation.type.IType
import org.eclipse.emf.ecore.EClassifier

interface AbstractTypeSystem {
	def TypeName solveType(EClassifier type)
	def TypeName resolveType3(IType iType)
	def TypeName solveNothing(TypeName pt, Expression expr)
}
