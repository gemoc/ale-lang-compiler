package test1.visitor.test1.impl;

import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import test1.visitor.test1.ConceptA;
import test1.visitor.test1.Test1Package;
import visitor.VisitorInterface;

public class ConceptAImpl extends MinimalEObjectImpl.Container implements ConceptA {
	protected ConceptAImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return Test1Package.Literals.CONCEPT_A;
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visittest1__ConceptA(this);
	}
}
