package emfrelations.interpreter.emfrelations.impl;

import emfrelations.interpreter.emfrelations.ConceptA5;
import emfrelations.interpreter.emfrelations.ConceptB5;
import emfrelations.interpreter.emfrelations.EmfrelationsPackage;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class ConceptB5Impl extends MinimalEObjectImpl.Container implements ConceptB5 {
	protected ConceptB5Impl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return EmfrelationsPackage.Literals.CONCEPT_B5;
	}

	public ConceptA5 getConcepta5() {
		if (eContainerFeatureID() != EmfrelationsPackage.CONCEPT_B5__CONCEPTA5)
			return null;
		return (ConceptA5) eInternalContainer();
	}

	public NotificationChain basicSetConcepta5(ConceptA5 newConcepta5, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newConcepta5, EmfrelationsPackage.CONCEPT_B5__CONCEPTA5, msgs);
		return msgs;
	}

	public void setConcepta5(ConceptA5 newConcepta5) {
		if (newConcepta5 != eInternalContainer() || (eContainerFeatureID() != EmfrelationsPackage.CONCEPT_B5__CONCEPTA5 && newConcepta5 != null)) {
			if (EcoreUtil.isAncestor(this, newConcepta5))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newConcepta5 != null)
				msgs = ((InternalEObject) newConcepta5).eInverseAdd(this, EmfrelationsPackage.CONCEPT_A5__CONCEPTB5, ConceptA5.class, msgs);
			msgs = basicSetConcepta5(newConcepta5, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmfrelationsPackage.CONCEPT_B5__CONCEPTA5, newConcepta5, newConcepta5));
	}

	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_B5__CONCEPTA5 :
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetConcepta5((ConceptA5) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_B5__CONCEPTA5 :
				return basicSetConcepta5(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case EmfrelationsPackage.CONCEPT_B5__CONCEPTA5 :
				return eInternalContainer().eInverseRemove(this, EmfrelationsPackage.CONCEPT_A5__CONCEPTB5, ConceptA5.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_B5__CONCEPTA5 :
				return getConcepta5();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_B5__CONCEPTA5 :
				setConcepta5((ConceptA5) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_B5__CONCEPTA5 :
				setConcepta5((ConceptA5) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EmfrelationsPackage.CONCEPT_B5__CONCEPTA5 :
				return getConcepta5() != null;
		}
		return super.eIsSet(featureID);
	}
}
