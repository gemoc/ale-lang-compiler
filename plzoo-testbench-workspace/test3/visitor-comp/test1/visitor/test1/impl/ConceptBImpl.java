package test1.visitor.test1.impl;

import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;
import test1.visitor.test1.ConceptB;
import test1.visitor.test1.Test1Package;
import visitor.VisitorInterface;

public class ConceptBImpl extends ConceptAImpl implements ConceptB {
	protected ConceptBImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return Test1Package.Literals.CONCEPT_B;
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visittest1__ConceptB(this);
	}
}
