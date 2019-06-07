package emfrelations.interpreter.emfrelations.impl;

import emfrelations.interpreter.emfrelations.ConceptA1;
import emfrelations.interpreter.emfrelations.ConceptB1;
import emfrelations.interpreter.emfrelations.EmfrelationsPackage;
import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

public class ConceptB1Impl extends MinimalEObjectImpl.Container implements ConceptB1 {
	protected ConceptA1 concepta1;

	protected ConceptB1Impl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return EmfrelationsPackage.Literals.CONCEPT_B1;
	}

	public ConceptA1 getConcepta1() {
		if (concepta1 != null && concepta1.eIsProxy()) {
			InternalEObject oldConcepta1 = (InternalEObject) concepta1;
			concepta1 = (ConceptA1) eResolveProxy(oldConcepta1);
			if (concepta1 != oldConcepta1) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmfrelationsPackage.CONCEPT_B1__CONCEPTA1, oldConcepta1, concepta1));
			}
		}
		return concepta1;
	}

	public ConceptA1 basicGetConcepta1() {
		return concepta1;
	}

	public NotificationChain basicSetConcepta1(ConceptA1 newConcepta1, NotificationChain msgs) {
		ConceptA1 oldConcepta1 = concepta1;
		concepta1 = newConcepta1;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EmfrelationsPackage.CONCEPT_B1__CONCEPTA1, oldConcepta1, newConcepta1);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	public void setConcepta1(ConceptA1 newConcepta1) {
		if (newConcepta1 != concepta1) {
			NotificationChain msgs = null;
			if (concepta1 != null)
				msgs = ((InternalEObject) concepta1).eInverseRemove(this, EmfrelationsPackage.CONCEPT_A1__CONCEPTB1, ConceptA1.class, msgs);
			if (newConcepta1 != null)
				msgs = ((InternalEObject) newConcepta1).eInverseAdd(this, EmfrelationsPackage.CONCEPT_A1__CONCEPTB1, ConceptA1.class, msgs);
			msgs = basicSetConcepta1(newConcepta1, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfrelationsPackage.CONCEPT_B1__CONCEPTA1, newConcepta1, newConcepta1));
	}

	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_B1__CONCEPTA1 :
				if (concepta1 != null)
					msgs = ((InternalEObject) concepta1).eInverseRemove(this, EmfrelationsPackage.CONCEPT_A1__CONCEPTB1, ConceptA1.class, msgs);
				return basicSetConcepta1((ConceptA1) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_B1__CONCEPTA1 :
				return basicSetConcepta1(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_B1__CONCEPTA1 :
				if (resolve)
					return getConcepta1();
				return basicGetConcepta1();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_B1__CONCEPTA1 :
				setConcepta1((ConceptA1) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_B1__CONCEPTA1 :
				setConcepta1((ConceptA1) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_B1__CONCEPTA1 :
				return concepta1 != null;
		}
		return super.eIsSet(featureID);
	}
}
