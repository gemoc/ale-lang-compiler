package autocast.visitor.autocast.impl;

import autocast.visitor.autocast.AutocastPackage;
import autocast.visitor.autocast.ConceptA;
import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import visitor.VisitorInterface;

public class ConceptAImpl extends MinimalEObjectImpl.Container implements ConceptA {
	protected ConceptAImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return AutocastPackage.Literals.CONCEPT_A;
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visitautocast__ConceptA(this);
	}
}
