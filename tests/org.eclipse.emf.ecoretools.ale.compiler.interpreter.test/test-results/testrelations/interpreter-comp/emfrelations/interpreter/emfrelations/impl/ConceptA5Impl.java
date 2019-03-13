package emfrelations.interpreter.emfrelations.impl;

import fr.mleduc.xp.emfrelations.ConceptA5;
import fr.mleduc.xp.emfrelations.ConceptB5;
import fr.mleduc.xp.emfrelations.EmfrelationsPackage;
import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

public class ConceptA5Impl extends MinimalEObjectImpl.Container implements ConceptA5 {
	protected EList<ConceptB5> conceptb5;

	protected ConceptA5Impl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return EmfrelationsPackage.Literals.CONCEPT_A5;
	}

	public EList<ConceptB5> getConceptb5() {
		if (conceptb5 == null) {
			conceptb5 = new EObjectContainmentWithInverseEList<ConceptB5>(ConceptB5.class,
					this, EmfrelationsPackage.CONCEPT_A5__CONCEPTB5,
					EmfrelationsPackage.CONCEPT_B5__CONCEPTA5);
		}
		return conceptb5;
	}

	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_A5__CONCEPTB5 :
				return ((InternalEList<InternalEObject>) (InternalEList<?>) getConceptb5())
						.basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_A5__CONCEPTB5 :
				return ((InternalEList<?>) getConceptb5()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_A5__CONCEPTB5 :
				return getConceptb5();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_A5__CONCEPTB5 :
				getConceptb5().clear();
				getConceptb5().addAll((Collection<? extends ConceptB5>) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_A5__CONCEPTB5 :
				getConceptb5().clear();
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_A5__CONCEPTB5 :
				return conceptb5 != null && !conceptb5.isEmpty();
		}
		return super.eIsSet(featureID);
	}
}
