package emfrelations.visitor.emfrelations.impl;

import emfrelations.visitor.emfrelations.ConceptA2;
import emfrelations.visitor.emfrelations.ConceptB2;
import emfrelations.visitor.emfrelations.EmfrelationsPackage;
import java.lang.Object;
import java.lang.Override;
import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import visitor.VisitorInterface;

public class ConceptB2Impl extends MinimalEObjectImpl.Container implements ConceptB2 {
	protected EList<ConceptA2> concepta2;

	protected ConceptB2Impl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return EmfrelationsPackage.Literals.CONCEPT_B2;
	}

	public EList<ConceptA2> getConcepta2() {
		if (concepta2 == null) {
			concepta2 = new EObjectWithInverseResolvingEList<ConceptA2>(ConceptA2.class, this, EmfrelationsPackage.CONCEPT_B2__CONCEPTA2, EmfrelationsPackage.CONCEPT_A2__CONCEPTB2);
		}
		return concepta2;
	}

	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_B2__CONCEPTA2 :
				return ((InternalEList<InternalEObject>) (InternalEList<?>) getConcepta2()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_B2__CONCEPTA2 :
				return ((InternalEList<?>) getConcepta2()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_B2__CONCEPTA2 :
				return getConcepta2();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_B2__CONCEPTA2 :
				getConcepta2().clear();
				getConcepta2().addAll((Collection<? extends ConceptA2>) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_B2__CONCEPTA2 :
				getConcepta2().clear();
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_B2__CONCEPTA2 :
				return concepta2 != null && !concepta2.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visitemfrelations__ConceptB2(this);
	}
}
