package emfrelations.visitor.emfrelations.impl;

import emfrelations.visitor.emfrelations.ConceptB9;
import emfrelations.visitor.emfrelations.EmfrelationsPackage;
import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import visitor.VisitorInterface;

public class ConceptB9Impl extends MinimalEObjectImpl.Container implements ConceptB9 {
	protected ConceptB9Impl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return EmfrelationsPackage.Literals.CONCEPT_B9;
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visitemfrelations__ConceptB9(this);
	}
}
