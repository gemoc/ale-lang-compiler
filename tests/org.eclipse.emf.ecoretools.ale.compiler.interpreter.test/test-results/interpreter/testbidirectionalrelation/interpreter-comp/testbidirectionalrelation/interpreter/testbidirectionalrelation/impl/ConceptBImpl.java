package testbidirectionalrelation.interpreter.testbidirectionalrelation.impl;

import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import testbidirectionalrelation.interpreter.testbidirectionalrelation.ConceptB;
import testbidirectionalrelation.interpreter.testbidirectionalrelation.ConceptC;
import testbidirectionalrelation.interpreter.testbidirectionalrelation.TestbidirectionalrelationPackage;

public class ConceptBImpl extends MinimalEObjectImpl.Container implements ConceptB {
	protected ConceptC conceptc;

	protected ConceptBImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return TestbidirectionalrelationPackage.Literals.CONCEPT_B;
	}

	public ConceptC getConceptc() {
		if (conceptc != null && conceptc.eIsProxy()) {
			InternalEObject oldConceptc = (InternalEObject) conceptc;
			conceptc = (ConceptC) eResolveProxy(oldConceptc);
			if (conceptc != oldConceptc) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TestbidirectionalrelationPackage.CONCEPT_B__CONCEPTC, oldConceptc, conceptc));
			}
		}
		return conceptc;
	}

	public ConceptC basicGetConceptc() {
		return conceptc;
	}

	public NotificationChain basicSetConceptc(ConceptC newConceptc, NotificationChain msgs) {
		ConceptC oldConceptc = conceptc;
		conceptc = newConceptc;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TestbidirectionalrelationPackage.CONCEPT_B__CONCEPTC, oldConceptc, newConceptc);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	public void setConceptc(ConceptC newConceptc) {
		if (newConceptc != conceptc) {
			NotificationChain msgs = null;
			if (conceptc != null)
				msgs = ((InternalEObject) conceptc).eInverseRemove(this, TestbidirectionalrelationPackage.CONCEPT_C__CONCEPTB, ConceptC.class, msgs);
			if (newConceptc != null)
				msgs = ((InternalEObject) newConceptc).eInverseAdd(this, TestbidirectionalrelationPackage.CONCEPT_C__CONCEPTB, ConceptC.class, msgs);
			msgs = basicSetConceptc(newConceptc, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestbidirectionalrelationPackage.CONCEPT_B__CONCEPTC, newConceptc, newConceptc));
	}

	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case TestbidirectionalrelationPackage.CONCEPT_B__CONCEPTC :
				if (conceptc != null)
					msgs = ((InternalEObject) conceptc).eInverseRemove(this, TestbidirectionalrelationPackage.CONCEPT_C__CONCEPTB, ConceptC.class, msgs);
				return basicSetConceptc((ConceptC) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case TestbidirectionalrelationPackage.CONCEPT_B__CONCEPTC :
				return basicSetConceptc(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TestbidirectionalrelationPackage.CONCEPT_B__CONCEPTC :
				if (resolve)
					return getConceptc();
				return basicGetConceptc();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TestbidirectionalrelationPackage.CONCEPT_B__CONCEPTC :
				setConceptc((ConceptC) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TestbidirectionalrelationPackage.CONCEPT_B__CONCEPTC :
				setConceptc((ConceptC) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TestbidirectionalrelationPackage.CONCEPT_B__CONCEPTC :
				return conceptc != null;
		}
		return super.eIsSet(featureID);
	}
}
