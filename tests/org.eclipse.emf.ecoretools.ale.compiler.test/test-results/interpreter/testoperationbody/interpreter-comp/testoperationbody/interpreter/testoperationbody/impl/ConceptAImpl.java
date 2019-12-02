package testoperationbody.interpreter.testoperationbody.impl;

import java.lang.Override;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import testoperationbody.interpreter.testoperationbody.ConceptA;
import testoperationbody.interpreter.testoperationbody.TestoperationbodyPackage;

public class ConceptAImpl extends MinimalEObjectImpl.Container implements ConceptA {
	protected ConceptAImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return TestoperationbodyPackage.Literals.CONCEPT_A;
	}

	public boolean op() {
		boolean result;
		result = (boolean) (false);
		return result;
	}
}
