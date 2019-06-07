package emfrelations.interpreter.emfrelations.impl;

import emfrelations.interpreter.emfrelations.ConceptA0;
import emfrelations.interpreter.emfrelations.ConceptB0;
import emfrelations.interpreter.emfrelations.EmfrelationsPackage;
import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

public class ConceptA0Impl extends MinimalEObjectImpl.Container implements ConceptA0 {
	protected ConceptB0 conceptb0;

	protected ConceptA0Impl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return EmfrelationsPackage.Literals.CONCEPT_A0;
	}

	public ConceptB0 getConceptb0() {
		if (conceptb0 != null && conceptb0.eIsProxy()) {
			InternalEObject oldConceptb0 = (InternalEObject) conceptb0;
			conceptb0 = (ConceptB0) eResolveProxy(oldConceptb0);
			if (conceptb0 != oldConceptb0) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmfrelationsPackage.CONCEPT_A0__CONCEPTB0, oldConceptb0, conceptb0));
			}
		}
		return conceptb0;
	}

	public ConceptB0 basicGetConceptb0() {
		return conceptb0;
	}

	public NotificationChain basicSetConceptb0(ConceptB0 newConceptb0, NotificationChain msgs) {
		ConceptB0 oldConceptb0 = conceptb0;
		conceptb0 = newConceptb0;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EmfrelationsPackage.CONCEPT_A0__CONCEPTB0, oldConceptb0, newConceptb0);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	public void setConceptb0(ConceptB0 newConceptb0) {
		if (newConceptb0 != conceptb0) {
			NotificationChain msgs = null;
			if (conceptb0 != null)
				msgs = ((InternalEObject) conceptb0).eInverseRemove(this, EmfrelationsPackage.CONCEPT_B0__CONCEPTA0, ConceptB0.class, msgs);
			if (newConceptb0 != null)
				msgs = ((InternalEObject) newConceptb0).eInverseAdd(this, EmfrelationsPackage.CONCEPT_B0__CONCEPTA0, ConceptB0.class, msgs);
			msgs = basicSetConceptb0(newConceptb0, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfrelationsPackage.CONCEPT_A0__CONCEPTB0, newConceptb0, newConceptb0));
	}

	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_A0__CONCEPTB0 :
				if (conceptb0 != null)
					msgs = ((InternalEObject) conceptb0).eInverseRemove(this, EmfrelationsPackage.CONCEPT_B0__CONCEPTA0, ConceptB0.class, msgs);
				return basicSetConceptb0((ConceptB0) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_A0__CONCEPTB0 :
				return basicSetConceptb0(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_A0__CONCEPTB0 :
				if (resolve)
					return getConceptb0();
				return basicGetConceptb0();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_A0__CONCEPTB0 :
				setConceptb0((ConceptB0) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_A0__CONCEPTB0 :
				setConceptb0((ConceptB0) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_A0__CONCEPTB0 :
				return conceptb0 != null;
		}
		return super.eIsSet(featureID);
	}
}
