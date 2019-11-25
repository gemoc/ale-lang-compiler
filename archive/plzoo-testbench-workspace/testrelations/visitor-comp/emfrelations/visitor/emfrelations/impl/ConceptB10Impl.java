package emfrelations.visitor.emfrelations.impl;

import emfrelations.visitor.emfrelations.ConceptB10;
import emfrelations.visitor.emfrelations.EmfrelationsPackage;
import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import visitor.VisitorInterface;

public class ConceptB10Impl extends MinimalEObjectImpl.Container implements ConceptB10 {
	protected ConceptB10Impl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return EmfrelationsPackage.Literals.CONCEPT_B10;
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visitemfrelations__ConceptB10(this);
	}
}
