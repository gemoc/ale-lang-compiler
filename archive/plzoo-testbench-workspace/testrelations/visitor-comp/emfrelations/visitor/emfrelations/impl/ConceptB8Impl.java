package emfrelations.visitor.emfrelations.impl;

import emfrelations.visitor.emfrelations.ConceptB8;
import emfrelations.visitor.emfrelations.EmfrelationsPackage;
import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import visitor.VisitorInterface;

public class ConceptB8Impl extends MinimalEObjectImpl.Container implements ConceptB8 {
	protected ConceptB8Impl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return EmfrelationsPackage.Literals.CONCEPT_B8;
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visitemfrelations__ConceptB8(this);
	}
}
