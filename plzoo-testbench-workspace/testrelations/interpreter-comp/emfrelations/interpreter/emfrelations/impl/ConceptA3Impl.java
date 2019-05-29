package emfrelations.interpreter.emfrelations.impl;

import emfrelations.interpreter.emfrelations.ConceptA3;
import emfrelations.interpreter.emfrelations.ConceptB3;
import emfrelations.interpreter.emfrelations.EmfrelationsPackage;
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

public class ConceptA3Impl extends MinimalEObjectImpl.Container implements ConceptA3 {
	protected EList<ConceptB3> conceptb3;

	protected ConceptA3Impl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return EmfrelationsPackage.Literals.CONCEPT_A3;
	}

	public EList<ConceptB3> getConceptb3() {
		if (conceptb3 == null) {
			conceptb3 = new EObjectWithInverseResolvingEList.ManyInverse<ConceptB3>(ConceptB3.class, this, EmfrelationsPackage.CONCEPT_A3__CONCEPTB3, EmfrelationsPackage.CONCEPT_B3__CONCEPTA3);
		}
		return conceptb3;
	}

	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_A3__CONCEPTB3 :
				return ((InternalEList<InternalEObject>) (InternalEList<?>) getConceptb3()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_A3__CONCEPTB3 :
				return ((InternalEList<?>) getConceptb3()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_A3__CONCEPTB3 :
				return getConceptb3();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_A3__CONCEPTB3 :
				getConceptb3().clear();
				getConceptb3().addAll((Collection<? extends ConceptB3>) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_A3__CONCEPTB3 :
				getConceptb3().clear();
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_A3__CONCEPTB3 :
				return conceptb3 != null && !conceptb3.isEmpty();
		}
		return super.eIsSet(featureID);
	}
}
