package emfrelations.interpreter.emfrelations.impl;

import emfrelations.interpreter.emfrelations.ConceptA4;
import emfrelations.interpreter.emfrelations.ConceptB4;
import emfrelations.interpreter.emfrelations.EmfrelationsPackage;
import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

public class ConceptA4Impl extends MinimalEObjectImpl.Container implements ConceptA4 {
	protected ConceptB4 conceptb4;

	protected ConceptA4Impl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return EmfrelationsPackage.Literals.CONCEPT_A4;
	}

	public ConceptB4 getConceptb4() {
		return conceptb4;
	}

	public NotificationChain basicSetConceptb4(ConceptB4 newConceptb4, NotificationChain msgs) {
		ConceptB4 oldConceptb4 = conceptb4;
		conceptb4 = newConceptb4;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EmfrelationsPackage.CONCEPT_A4__CONCEPTB4, oldConceptb4, newConceptb4);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	public void setConceptb4(ConceptB4 newConceptb4) {
		if (newConceptb4 != conceptb4) {
			NotificationChain msgs = null;
			if (conceptb4 != null)
				msgs = ((InternalEObject) conceptb4).eInverseRemove(this, EmfrelationsPackage.CONCEPT_B4__CONCEPTA4, ConceptB4.class, msgs);
			if (newConceptb4 != null)
				msgs = ((InternalEObject) newConceptb4).eInverseAdd(this, EmfrelationsPackage.CONCEPT_B4__CONCEPTA4, ConceptB4.class, msgs);
			msgs = basicSetConceptb4(newConceptb4, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfrelationsPackage.CONCEPT_A4__CONCEPTB4, newConceptb4, newConceptb4));
	}

	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_A4__CONCEPTB4 :
				if (conceptb4 != null)
					msgs = ((InternalEObject) conceptb4).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EmfrelationsPackage.CONCEPT_A4__CONCEPTB4, null, msgs);
				return basicSetConceptb4((ConceptB4) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_A4__CONCEPTB4 :
				return basicSetConceptb4(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_A4__CONCEPTB4 :
				return getConceptb4();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_A4__CONCEPTB4 :
				setConceptb4((ConceptB4) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_A4__CONCEPTB4 :
				setConceptb4((ConceptB4) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_A4__CONCEPTB4 :
				return conceptb4 != null;
		}
		return super.eIsSet(featureID);
	}
}
