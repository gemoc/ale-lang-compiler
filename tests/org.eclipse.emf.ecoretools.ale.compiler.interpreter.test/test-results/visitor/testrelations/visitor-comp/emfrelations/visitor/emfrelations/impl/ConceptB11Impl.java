package emfrelations.visitor.emfrelations.impl;

import emfrelations.visitor.emfrelations.ConceptB11;
import emfrelations.visitor.emfrelations.EmfrelationsPackage;
import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import visitor.VisitorInterface;

public class ConceptB11Impl extends MinimalEObjectImpl.Container implements ConceptB11 {
	protected ConceptB11Impl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return EmfrelationsPackage.Literals.CONCEPT_B11;
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visitemfrelations__ConceptB11(this);
	}
}
