package testbidirectionalrelation.interpreter.testbidirectionalrelation.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import testbidirectionalrelation.ConceptD;
import testbidirectionalrelation.ConceptE;
import testbidirectionalrelation.TestbidirectionalrelationPackage;

public class ConceptEImpl extends MinimalEObjectImpl.Container implements ConceptE {
	protected EList<ConceptD> conceptd;

	protected ConceptEImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return TestbidirectionalrelationPackage.Literals.CONCEPT_E;
	}

	public EList<ConceptD> getConceptd() {
		if (conceptd == null) {
			conceptd = new EObjectWithInverseResolvingEList<ConceptD>(ConceptD.class, this, TestbidirectionalrelationPackage.CONCEPT_E__CONCEPTD, TestbidirectionalrelationPackage.CONCEPT_D__CONCEPTE);
		}
		return conceptd;
	}

	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case TestbidirectionalrelationPackage.CONCEPT_E__CONCEPTD :
				return ((InternalEList<InternalEObject>) (InternalEList<?>) getConceptd()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case TestbidirectionalrelationPackage.CONCEPT_E__CONCEPTD :
				return ((InternalEList<?>) getConceptd()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TestbidirectionalrelationPackage.CONCEPT_E__CONCEPTD :
				return getConceptd();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TestbidirectionalrelationPackage.CONCEPT_E__CONCEPTD :
				getConceptd().clear();
				getConceptd().addAll((Collection<? extends ConceptD>) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TestbidirectionalrelationPackage.CONCEPT_E__CONCEPTD :
				getConceptd().clear();
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TestbidirectionalrelationPackage.CONCEPT_E__CONCEPTD :
				return conceptd != null && !conceptd.isEmpty();
		}
		return super.eIsSet(featureID);
	}

}