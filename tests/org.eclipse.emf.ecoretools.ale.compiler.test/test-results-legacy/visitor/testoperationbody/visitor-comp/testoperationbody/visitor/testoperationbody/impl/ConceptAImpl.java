package testoperationbody.visitor.testoperationbody.impl;

import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import testoperationbody.visitor.testoperationbody.ConceptA;
import testoperationbody.visitor.testoperationbody.TestoperationbodyPackage;
import visitor.VisitorInterface;

public class ConceptAImpl extends MinimalEObjectImpl.Container implements ConceptA {
	protected ConceptAImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return TestoperationbodyPackage.Literals.CONCEPT_A;
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visittestoperationbody__ConceptA(this);
	}
}
