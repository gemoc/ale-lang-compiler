package testbidirectionalrelation.interpreter.testbidirectionalrelation.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import testbidirectionalrelation.interpreter.testbidirectionalrelation.ConceptF;
import testbidirectionalrelation.interpreter.testbidirectionalrelation.ConceptG;
import testbidirectionalrelation.interpreter.testbidirectionalrelation.TestbidirectionalrelationPackage;

public class ConceptFImpl extends MinimalEObjectImpl.Container implements ConceptF {

	protected EList<ConceptG> conceptg;

	protected ConceptFImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return TestbidirectionalrelationPackage.Literals.CONCEPT_F;
	}

	public EList<ConceptG> getConceptg() {
		if (conceptg == null) {
			conceptg = new EObjectWithInverseResolvingEList.ManyInverse<ConceptG>(ConceptG.class, this, TestbidirectionalrelationPackage.CONCEPT_F__CONCEPTG, TestbidirectionalrelationPackage.CONCEPT_G__CONCEPTF);
		}
		return conceptg;
	}

	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case TestbidirectionalrelationPackage.CONCEPT_F__CONCEPTG :
				return ((InternalEList<InternalEObject>) (InternalEList<?>) getConceptg()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case TestbidirectionalrelationPackage.CONCEPT_F__CONCEPTG :
				return ((InternalEList<?>) getConceptg()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TestbidirectionalrelationPackage.CONCEPT_F__CONCEPTG :
				return getConceptg();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TestbidirectionalrelationPackage.CONCEPT_F__CONCEPTG :
				getConceptg().clear();
				getConceptg().addAll((Collection<? extends ConceptG>) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TestbidirectionalrelationPackage.CONCEPT_F__CONCEPTG :
				getConceptg().clear();
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TestbidirectionalrelationPackage.CONCEPT_F__CONCEPTG :
				return conceptg != null && !conceptg.isEmpty();
		}
		return super.eIsSet(featureID);
	}

}