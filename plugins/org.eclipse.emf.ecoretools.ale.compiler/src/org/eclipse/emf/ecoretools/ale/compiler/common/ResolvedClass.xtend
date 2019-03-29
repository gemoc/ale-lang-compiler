package org.eclipse.emf.ecoretools.ale.compiler.common

import org.eclipse.emf.codegen.ecore.genmodel.GenClass
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.emf.ecore.EClassifier

@Data
class ResolvedClass {
	ExtendedClass aleCls
	public EClassifier eCls
	GenClass genCls

	new(ExtendedClass aleCls, EClassifier eCls, GenClass genCls) {
		this.aleCls = aleCls
		this.eCls = eCls
		this.genCls = genCls
	}

	new(ExtendedClass aleCls, EClassifier eCls) {
		this.aleCls = aleCls
		this.eCls = eCls
		this.genCls = null
	}
}
