package emfrelations.visitor.emfrelations.impl;

import emfrelations.visitor.emfrelations.ConceptA3;
import emfrelations.visitor.emfrelations.ConceptB3;
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

public class ConceptB3Impl extends MinimalEObjectImpl.Container implements ConceptB3 {
	protected EList<ConceptA3> concepta3;

	protected ConceptB3Impl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return EmfrelationsPackage.Literals.CONCEPT_B3;
	}

	public EList<ConceptA3> getConcepta3() {
		if (concepta3 == null) {
			concepta3 = new EObjectWithInverseResolvingEList.ManyInverse<ConceptA3>(ConceptA3.class, this, EmfrelationsPackage.CONCEPT_B3__CONCEPTA3, EmfrelationsPackage.CONCEPT_A3__CONCEPTB3);
		}
		return concepta3;
	}

	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_B3__CONCEPTA3 :
				return ((InternalEList<InternalEObject>) (InternalEList<?>) getConcepta3()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_B3__CONCEPTA3 :
				return ((InternalEList<?>) getConcepta3()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_B3__CONCEPTA3 :
				return getConcepta3();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_B3__CONCEPTA3 :
				getConcepta3().clear();
				getConcepta3().addAll((Collection<? extends ConceptA3>) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_B3__CONCEPTA3 :
				getConcepta3().clear();
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_B3__CONCEPTA3 :
				return concepta3 != null && !concepta3.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visitemfrelations__ConceptB3(this);
	}
}
