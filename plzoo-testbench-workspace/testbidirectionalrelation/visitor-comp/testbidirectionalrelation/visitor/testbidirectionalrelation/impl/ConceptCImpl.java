package testbidirectionalrelation.visitor.testbidirectionalrelation.impl;

import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import testbidirectionalrelation.visitor.testbidirectionalrelation.ConceptB;
import testbidirectionalrelation.visitor.testbidirectionalrelation.ConceptC;
import testbidirectionalrelation.visitor.testbidirectionalrelation.TestbidirectionalrelationPackage;
import visitor.VisitorInterface;

public class ConceptCImpl extends MinimalEObjectImpl.Container implements ConceptC {
	protected ConceptB conceptb;

	protected ConceptCImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return TestbidirectionalrelationPackage.Literals.CONCEPT_C;
	}

	public ConceptB getConceptb() {
		if (conceptb != null && conceptb.eIsProxy()) {
			InternalEObject oldConceptb = (InternalEObject) conceptb;
			conceptb = (ConceptB) eResolveProxy(oldConceptb);
			if (conceptb != oldConceptb) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TestbidirectionalrelationPackage.CONCEPT_C__CONCEPTB, oldConceptb, conceptb));
			}
		}
		return conceptb;
	}

	public ConceptB basicGetConceptb() {
		return conceptb;
	}

	public NotificationChain basicSetConceptb(ConceptB newConceptb, NotificationChain msgs) {
		ConceptB oldConceptb = conceptb;
		conceptb = newConceptb;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TestbidirectionalrelationPackage.CONCEPT_C__CONCEPTB, oldConceptb, newConceptb);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	public void setConceptb(ConceptB newConceptb) {
		if (newConceptb != conceptb) {
			NotificationChain msgs = null;
			if (conceptb != null)
				msgs = ((InternalEObject) conceptb).eInverseRemove(this, TestbidirectionalrelationPackage.CONCEPT_B__CONCEPTC, ConceptB.class, msgs);
			if (newConceptb != null)
				msgs = ((InternalEObject) newConceptb).eInverseAdd(this, TestbidirectionalrelationPackage.CONCEPT_B__CONCEPTC, ConceptB.class, msgs);
			msgs = basicSetConceptb(newConceptb, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestbidirectionalrelationPackage.CONCEPT_C__CONCEPTB, newConceptb, newConceptb));
	}

	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case TestbidirectionalrelationPackage.CONCEPT_C__CONCEPTB :
				if (conceptb != null)
					msgs = ((InternalEObject) conceptb).eInverseRemove(this, TestbidirectionalrelationPackage.CONCEPT_B__CONCEPTC, ConceptB.class, msgs);
				return basicSetConceptb((ConceptB) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case TestbidirectionalrelationPackage.CONCEPT_C__CONCEPTB :
				return basicSetConceptb(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TestbidirectionalrelationPackage.CONCEPT_C__CONCEPTB :
				if (resolve)
					return getConceptb();
				return basicGetConceptb();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TestbidirectionalrelationPackage.CONCEPT_C__CONCEPTB :
				setConceptb((ConceptB) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TestbidirectionalrelationPackage.CONCEPT_C__CONCEPTB :
				setConceptb((ConceptB) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TestbidirectionalrelationPackage.CONCEPT_C__CONCEPTB :
				return conceptb != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visittestbidirectionalrelation__ConceptC(this);
	}
}
