package org.eclipse.emf.ecoretools.ale.compiler.common

import com.squareup.javapoet.TypeName
import org.eclipse.acceleo.query.validation.type.IType
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EObject

interface AbstractTypeSystem {
	def TypeName solveType(EClassifier type)
	def TypeName resolveType3(IType iType)
	def TypeName solveNothing(TypeName pt, EObject expr)
}
