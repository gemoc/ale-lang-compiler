package emfrelations.interpreter.emfrelations.impl;

import emfrelations.interpreter.emfrelations.ConceptA1;
import emfrelations.interpreter.emfrelations.ConceptB1;
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
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;

public class ConceptA1Impl extends MinimalEObjectImpl.Container implements ConceptA1 {
	protected EList<ConceptB1> conceptb1;

	protected ConceptA1Impl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return EmfrelationsPackage.Literals.CONCEPT_A1;
	}

	public EList<ConceptB1> getConceptb1() {
		if (conceptb1 == null) {
			conceptb1 = new EObjectWithInverseResolvingEList<ConceptB1>(ConceptB1.class, this, EmfrelationsPackage.CONCEPT_A1__CONCEPTB1, EmfrelationsPackage.CONCEPT_B1__CONCEPTA1);
		}
		return conceptb1;
	}

	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_A1__CONCEPTB1 :
				return ((InternalEList<InternalEObject>) (InternalEList<?>) getConceptb1()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_A1__CONCEPTB1 :
				return ((InternalEList<?>) getConceptb1()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_A1__CONCEPTB1 :
				return getConceptb1();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_A1__CONCEPTB1 :
				getConceptb1().clear();
				getConceptb1().addAll((Collection<? extends ConceptB1>) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_A1__CONCEPTB1 :
				getConceptb1().clear();
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_A1__CONCEPTB1 :
				return conceptb1 != null && !conceptb1.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	public void logBS() {
		for (ConceptB1 b1 : this.getConceptb1()) {
			LogService.log(b1);
		}
	}
}
