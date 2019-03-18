package functioncall.interpreter.functioncall.impl;

import functioncall.interpreter.functioncall.ConceptA;
import functioncall.interpreter.functioncall.ConceptB;
import functioncall.interpreter.functioncall.ConceptC;
import functioncall.interpreter.functioncall.FunctioncallPackage;
import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

public class ConceptCImpl extends MinimalEObjectImpl.Container implements ConceptC {
	protected ConceptA concepta2;

	protected ConceptA concepta1;

	protected ConceptB conceptb;

	protected ConceptCImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return FunctioncallPackage.Literals.CONCEPT_C;
	}

	public void setConcepta2(ConceptA newConcepta2) {
		if (newConcepta2 != concepta2) {
			NotificationChain msgs = null;
			if (concepta2 != null)
				msgs = ((InternalEObject) concepta2).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - functioncall.interpreter.functioncall.FunctioncallPackage.CONCEPT_C__CONCEPTA2, null, msgs);
			if (newConcepta2 != null)
				msgs = ((InternalEObject)newConcepta2).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - functioncall.interpreter.functioncall.FunctioncallPackage.CONCEPT_C__CONCEPTA2, null, msgs);
			msgs = basicSetConcepta2(newConcepta2, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, functioncall.interpreter.functioncall.FunctioncallPackage.CONCEPT_C__CONCEPTA2, newConcepta2, newConcepta2));
	}

	public NotificationChain basicSetConcepta2(ConceptA newConcepta2, NotificationChain msgs) {
		ConceptA oldConcepta2 = concepta2;
		concepta2 = newConcepta2;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, functioncall.interpreter.functioncall.FunctioncallPackage.CONCEPT_C__CONCEPTA2, oldConcepta2, newConcepta2);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	public ConceptA getConcepta2() {
		return concepta2;
	}

	public void setConcepta1(ConceptA newConcepta1) {
		if (newConcepta1 != concepta1) {
			NotificationChain msgs = null;
			if (concepta1 != null)
				msgs = ((InternalEObject) concepta1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - functioncall.interpreter.functioncall.FunctioncallPackage.CONCEPT_C__CONCEPTA1, null, msgs);
			if (newConcepta1 != null)
				msgs = ((InternalEObject)newConcepta1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - functioncall.interpreter.functioncall.FunctioncallPackage.CONCEPT_C__CONCEPTA1, null, msgs);
			msgs = basicSetConcepta1(newConcepta1, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, functioncall.interpreter.functioncall.FunctioncallPackage.CONCEPT_C__CONCEPTA1, newConcepta1, newConcepta1));
	}

	public NotificationChain basicSetConcepta1(ConceptA newConcepta1, NotificationChain msgs) {
		ConceptA oldConcepta1 = concepta1;
		concepta1 = newConcepta1;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, functioncall.interpreter.functioncall.FunctioncallPackage.CONCEPT_C__CONCEPTA1, oldConcepta1, newConcepta1);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	public ConceptA getConcepta1() {
		return concepta1;
	}

	public void setConceptb(ConceptB newConceptb) {
		if (newConceptb != conceptb) {
			NotificationChain msgs = null;
			if (conceptb != null)
				msgs = ((InternalEObject) conceptb).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - functioncall.interpreter.functioncall.FunctioncallPackage.CONCEPT_C__CONCEPTB, null, msgs);
			if (newConceptb != null)
				msgs = ((InternalEObject)newConceptb).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - functioncall.interpreter.functioncall.FunctioncallPackage.CONCEPT_C__CONCEPTB, null, msgs);
			msgs = basicSetConceptb(newConceptb, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, functioncall.interpreter.functioncall.FunctioncallPackage.CONCEPT_C__CONCEPTB, newConceptb, newConceptb));
	}

	public NotificationChain basicSetConceptb(ConceptB newConceptb, NotificationChain msgs) {
		ConceptB oldConceptb = conceptb;
		conceptb = newConceptb;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, functioncall.interpreter.functioncall.FunctioncallPackage.CONCEPT_C__CONCEPTB, oldConceptb, newConceptb);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	public ConceptB getConceptb() {
		return conceptb;
	}

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case FunctioncallPackage.CONCEPT_C__CONCEPTA2 :
				return basicSetConcepta2(null, msgs);
			case FunctioncallPackage.CONCEPT_C__CONCEPTA1 :
				return basicSetConcepta1(null, msgs);
			case FunctioncallPackage.CONCEPT_C__CONCEPTB :
				return basicSetConceptb(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case FunctioncallPackage.CONCEPT_C__CONCEPTA2 :
				return getConcepta2();
			case FunctioncallPackage.CONCEPT_C__CONCEPTA1 :
				return getConcepta1();
			case FunctioncallPackage.CONCEPT_C__CONCEPTB :
				return getConceptb();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case FunctioncallPackage.CONCEPT_C__CONCEPTA2 :
				setConcepta2((ConceptA) newValue);
				return;
			case FunctioncallPackage.CONCEPT_C__CONCEPTA1 :
				setConcepta1((ConceptA) newValue);
				return;
			case FunctioncallPackage.CONCEPT_C__CONCEPTB :
				setConceptb((ConceptB) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case FunctioncallPackage.CONCEPT_C__CONCEPTA2 :
				setConcepta2((ConceptA) null);
				return;
			case FunctioncallPackage.CONCEPT_C__CONCEPTA1 :
				setConcepta1((ConceptA) null);
				return;
			case FunctioncallPackage.CONCEPT_C__CONCEPTB :
				setConceptb((ConceptB) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case FunctioncallPackage.CONCEPT_C__CONCEPTA2 :
				return concepta2 != null;
			case FunctioncallPackage.CONCEPT_C__CONCEPTA1 :
				return concepta1 != null;
			case FunctioncallPackage.CONCEPT_C__CONCEPTB :
				return conceptb != null;
		}
		return super.eIsSet(featureID);
	}

	public void exec1() {
		this.concepta1.fct1();
		ConceptA tmpA = this.concepta1.fct2();
		this.concepta2.fct1();
		ConceptA tmpB = this.concepta2.fct2();
		this.conceptb.fct1();
		ConceptB tmpC = this.conceptb.fct2();
		
		System.out.println(tmpA.toString() + tmpB.toString() + tmpC + toString());
	}
}
