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

public class ConceptB0Impl extends MinimalEObjectImpl.Container implements ConceptB0 {
	protected ConceptA0 concepta0;

	protected ConceptB0Impl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return EmfrelationsPackage.Literals.CONCEPT_B0;
	}

	public ConceptA0 getConcepta0() {
		if (concepta0 != null && concepta0.eIsProxy()) {
			InternalEObject oldConcepta0 = (InternalEObject) concepta0;
			concepta0 = (ConceptA0) eResolveProxy(oldConcepta0);
			if (concepta0 != oldConcepta0) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmfrelationsPackage.CONCEPT_B0__CONCEPTA0, oldConcepta0, concepta0));
			}
		}
		return concepta0;
	}

	public ConceptA0 basicGetConcepta0() {
		return concepta0;
	}

	public NotificationChain basicSetConcepta0(ConceptA0 newConcepta0, NotificationChain msgs) {
		ConceptA0 oldConcepta0 = concepta0;
		concepta0 = newConcepta0;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EmfrelationsPackage.CONCEPT_B0__CONCEPTA0, oldConcepta0, newConcepta0);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	public void setConcepta0(ConceptA0 newConcepta0) {
		if (newConcepta0 != concepta0) {
			NotificationChain msgs = null;
			if (concepta0 != null)
				msgs = ((InternalEObject) concepta0).eInverseRemove(this, EmfrelationsPackage.CONCEPT_A0__CONCEPTB0, ConceptA0.class, msgs);
			if (newConcepta0 != null)
				msgs = ((InternalEObject) newConcepta0).eInverseAdd(this, EmfrelationsPackage.CONCEPT_A0__CONCEPTB0, ConceptA0.class, msgs);
			msgs = basicSetConcepta0(newConcepta0, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfrelationsPackage.CONCEPT_B0__CONCEPTA0, newConcepta0, newConcepta0));
	}

	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_B0__CONCEPTA0 :
				if (concepta0 != null)
					msgs = ((InternalEObject) concepta0).eInverseRemove(this, EmfrelationsPackage.CONCEPT_A0__CONCEPTB0, ConceptA0.class, msgs);
				return basicSetConcepta0((ConceptA0) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_B0__CONCEPTA0 :
				return basicSetConcepta0(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_B0__CONCEPTA0 :
				if (resolve)
					return getConcepta0();
				return basicGetConcepta0();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_B0__CONCEPTA0 :
				setConcepta0((ConceptA0) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_B0__CONCEPTA0 :
				setConcepta0((ConceptA0) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_B0__CONCEPTA0 :
				return concepta0 != null;
		}
		return super.eIsSet(featureID);
	}
}
