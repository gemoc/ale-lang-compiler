package emfrelations.interpreter.emfrelations.impl;

import emfrelations.interpreter.emfrelations.ConceptA10;
import emfrelations.interpreter.emfrelations.ConceptB10;
import emfrelations.interpreter.emfrelations.EmfrelationsPackage;
import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

public class ConceptA10Impl extends MinimalEObjectImpl.Container implements ConceptA10 {
	protected ConceptB10 conceptb10;

	protected ConceptA10Impl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return EmfrelationsPackage.Literals.CONCEPT_A10;
	}

	public ConceptB10 getConceptb10() {
		return conceptb10;
	}

	public NotificationChain basicSetConceptb10(ConceptB10 newConceptb10, NotificationChain msgs) {
		ConceptB10 oldConceptb10 = conceptb10;
		conceptb10 = newConceptb10;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EmfrelationsPackage.CONCEPT_A10__CONCEPTB10, oldConceptb10, newConceptb10);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	public void setConceptb10(ConceptB10 newConceptb10) {
		if (newConceptb10 != conceptb10) {
			NotificationChain msgs = null;
			if (conceptb10 != null)
				msgs = ((InternalEObject) conceptb10).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EmfrelationsPackage.CONCEPT_A10__CONCEPTB10, null, msgs);
			if (newConceptb10 != null)
				msgs = ((InternalEObject) newConceptb10).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EmfrelationsPackage.CONCEPT_A10__CONCEPTB10, null, msgs);
			msgs = basicSetConceptb10(newConceptb10, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfrelationsPackage.CONCEPT_A10__CONCEPTB10, newConceptb10, newConceptb10));
	}

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_A10__CONCEPTB10 :
				return basicSetConceptb10(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_A10__CONCEPTB10 :
				return getConceptb10();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_A10__CONCEPTB10 :
				setConceptb10((ConceptB10) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_A10__CONCEPTB10 :
				setConceptb10((ConceptB10) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_A10__CONCEPTB10 :
				return conceptb10 != null;
		}
		return super.eIsSet(featureID);
	}
}
