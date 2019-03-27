package emfrelations.visitor.emfrelations.impl;

import emfrelations.visitor.emfrelations.ConceptA11;
import emfrelations.visitor.emfrelations.ConceptB11;
import emfrelations.visitor.emfrelations.EmfrelationsPackage;
import java.lang.Object;
import java.lang.Override;
import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import visitor.VisitorInterface;

public class ConceptA11Impl extends MinimalEObjectImpl.Container implements ConceptA11 {
	protected EList<ConceptB11> conceptb11;

	protected ConceptA11Impl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return EmfrelationsPackage.Literals.CONCEPT_A11;
	}

	public EList<ConceptB11> getConceptb11() {
		if (conceptb11 == null) {
			conceptb11 = new EObjectContainmentEList<ConceptB11>(ConceptB11.class, this, EmfrelationsPackage.CONCEPT_A11__CONCEPTB11);
		}
		return conceptb11;
	}

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_A11__CONCEPTB11 :
				return ((InternalEList<?>) getConceptb11()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_A11__CONCEPTB11 :
				return getConceptb11();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_A11__CONCEPTB11 :
				getConceptb11().clear();
				getConceptb11().addAll((Collection<? extends ConceptB11>) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_A11__CONCEPTB11 :
				getConceptb11().clear();
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_A11__CONCEPTB11 :
				return conceptb11 != null && !conceptb11.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visitemfrelations__ConceptA11(this);
	}
}
