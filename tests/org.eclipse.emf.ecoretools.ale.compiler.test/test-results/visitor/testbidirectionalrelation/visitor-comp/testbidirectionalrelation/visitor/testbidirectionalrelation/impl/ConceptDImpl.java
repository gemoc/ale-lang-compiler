package testbidirectionalrelation.visitor.testbidirectionalrelation.impl;

import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import testbidirectionalrelation.visitor.testbidirectionalrelation.ConceptD;
import testbidirectionalrelation.visitor.testbidirectionalrelation.ConceptE;
import testbidirectionalrelation.visitor.testbidirectionalrelation.TestbidirectionalrelationPackage;
import visitor.VisitorInterface;

public class ConceptDImpl extends MinimalEObjectImpl.Container implements ConceptD {
	protected ConceptE concepte;

	protected ConceptDImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return TestbidirectionalrelationPackage.Literals.CONCEPT_D;
	}

	public ConceptE getConcepte() {
		if (concepte != null && concepte.eIsProxy()) {
			InternalEObject oldConcepte = (InternalEObject) concepte;
			concepte = (ConceptE) eResolveProxy(oldConcepte);
			if (concepte != oldConcepte) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TestbidirectionalrelationPackage.CONCEPT_D__CONCEPTE, oldConcepte, concepte));
			}
		}
		return concepte;
	}

	public ConceptE basicGetConcepte() {
		return concepte;
	}

	public NotificationChain basicSetConcepte(ConceptE newConcepte, NotificationChain msgs) {
		ConceptE oldConcepte = concepte;
		concepte = newConcepte;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TestbidirectionalrelationPackage.CONCEPT_D__CONCEPTE, oldConcepte, newConcepte);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	public void setConcepte(ConceptE newConcepte) {
		if (newConcepte != concepte) {
			NotificationChain msgs = null;
			if (concepte != null)
				msgs = ((InternalEObject) concepte).eInverseRemove(this, TestbidirectionalrelationPackage.CONCEPT_E__CONCEPTD, ConceptE.class, msgs);
			if (newConcepte != null)
				msgs = ((InternalEObject) newConcepte).eInverseAdd(this, TestbidirectionalrelationPackage.CONCEPT_E__CONCEPTD, ConceptE.class, msgs);
			msgs = basicSetConcepte(newConcepte, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestbidirectionalrelationPackage.CONCEPT_D__CONCEPTE, newConcepte, newConcepte));
	}

	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case TestbidirectionalrelationPackage.CONCEPT_D__CONCEPTE :
				if (concepte != null)
					msgs = ((InternalEObject) concepte).eInverseRemove(this, TestbidirectionalrelationPackage.CONCEPT_E__CONCEPTD, ConceptE.class, msgs);
				return basicSetConcepte((ConceptE) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case TestbidirectionalrelationPackage.CONCEPT_D__CONCEPTE :
				return basicSetConcepte(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TestbidirectionalrelationPackage.CONCEPT_D__CONCEPTE :
				if (resolve)
					return getConcepte();
				return basicGetConcepte();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TestbidirectionalrelationPackage.CONCEPT_D__CONCEPTE :
				setConcepte((ConceptE) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TestbidirectionalrelationPackage.CONCEPT_D__CONCEPTE :
				setConcepte((ConceptE) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TestbidirectionalrelationPackage.CONCEPT_D__CONCEPTE :
				return concepte != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visittestbidirectionalrelation__ConceptD(this);
	}
}
