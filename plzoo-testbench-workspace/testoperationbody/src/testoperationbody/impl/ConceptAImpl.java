
package testoperationbody.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import testoperationbody.ConceptA;
import testoperationbody.TestoperationbodyPackage;


public class ConceptAImpl extends MinimalEObjectImpl.Container implements ConceptA {
	
	protected ConceptAImpl() {
		super();
	}

	
	@Override
	protected EClass eStaticClass() {
		return TestoperationbodyPackage.Literals.CONCEPT_A;
	}

} //ConceptAImpl
