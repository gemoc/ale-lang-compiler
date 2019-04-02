package org.eclipse.emf.ecoretools.ale.compiler.common

import com.squareup.javapoet.TypeName
import org.eclipse.emf.ecore.EClassifier

interface AbstractTypeSystem {
	def TypeName solveType(EClassifier type)
}
