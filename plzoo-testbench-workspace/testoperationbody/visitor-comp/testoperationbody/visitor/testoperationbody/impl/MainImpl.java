package testoperationbody.visitor.testoperationbody.impl;

import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import testoperationbody.visitor.testoperationbody.ConceptA;
import testoperationbody.visitor.testoperationbody.Main;
import testoperationbody.visitor.testoperationbody.Parent;
import testoperationbody.visitor.testoperationbody.TestoperationbodyPackage;
import visitor.VisitorInterface;

public class MainImpl extends MinimalEObjectImpl.Container implements Main {
	protected static final boolean SINGLEBOOL_EDEFAULT = false;

	protected EList<Integer> listint;

	protected boolean singlebool = SINGLEBOOL_EDEFAULT;

	protected EList<ConceptA> listconcepta;

	protected ConceptA singleconcepta;

	protected EList<Parent> children;

	protected MainImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return TestoperationbodyPackage.Literals.MAIN;
	}

	public EList<Integer> getListint() {
		if (listint == null) {
			listint = new EDataTypeEList<Integer>(int.class, this, TestoperationbodyPackage.MAIN__LISTINT);
		}
		return listint;
	}

	public EList<ConceptA> getListconcepta() {
		if (listconcepta == null) {
			listconcepta = new EObjectContainmentEList<ConceptA>(ConceptA.class, this, TestoperationbodyPackage.MAIN__LISTCONCEPTA);
		}
		return listconcepta;
	}

	public boolean isSinglebool() {
		return singlebool;
	}

	public void setSinglebool(boolean newSinglebool) {
		boolean oldSinglebool = singlebool;
		singlebool = newSinglebool;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestoperationbodyPackage.MAIN__SINGLEBOOL, oldSinglebool, singlebool));
	}

	public void setSingleconcepta(ConceptA newSingleconcepta) {
		ConceptA oldSingleconcepta = singleconcepta;
		singleconcepta = newSingleconcepta;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestoperationbodyPackage.MAIN__SINGLECONCEPTA, oldSingleconcepta, singleconcepta));
	}

	public ConceptA getSingleconcepta() {
		if (singleconcepta != null && singleconcepta.eIsProxy()) {
			InternalEObject oldSingleconcepta = (InternalEObject) singleconcepta;
			singleconcepta = (ConceptA) eResolveProxy(oldSingleconcepta);
			if (singleconcepta != oldSingleconcepta) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TestoperationbodyPackage.MAIN__SINGLECONCEPTA,
							oldSingleconcepta, singleconcepta));
			}
		}
		return singleconcepta;
	}

	public EList<Parent> getChildren() {
		if (children == null) {
			children = new EObjectContainmentEList<Parent>(Parent.class, this, TestoperationbodyPackage.MAIN__CHILDREN);
		}
		return children;
	}

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case TestoperationbodyPackage.MAIN__LISTCONCEPTA :
				return ((InternalEList<?>) getListconcepta()).basicRemove(otherEnd, msgs);
			case TestoperationbodyPackage.MAIN__CHILDREN :
				return ((InternalEList<?>) getChildren()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TestoperationbodyPackage.MAIN__LISTINT :
				return getListint();
			case TestoperationbodyPackage.MAIN__LISTCONCEPTA :
				return getListconcepta();
			case TestoperationbodyPackage.MAIN__SINGLEBOOL :
				return isSinglebool();
			case TestoperationbodyPackage.MAIN__SINGLECONCEPTA :
				if (resolve)
					return getSingleconcepta();
				return basicGetSingleconcepta();
			case TestoperationbodyPackage.MAIN__CHILDREN :
				return getChildren();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TestoperationbodyPackage.MAIN__LISTINT :
				getListint().clear();
				getListint().addAll((Collection<? extends Integer>) newValue);
				return;
			case TestoperationbodyPackage.MAIN__LISTCONCEPTA :
				getListconcepta().clear();
				getListconcepta().addAll((Collection<? extends ConceptA>) newValue);
				return;
			case TestoperationbodyPackage.MAIN__SINGLEBOOL :
				setSinglebool((Boolean) newValue);
				return;
			case TestoperationbodyPackage.MAIN__SINGLECONCEPTA :
				setSingleconcepta((ConceptA) newValue);
				return;
			case TestoperationbodyPackage.MAIN__CHILDREN :
				getChildren().clear();
				getChildren().addAll((Collection<? extends Parent>) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TestoperationbodyPackage.MAIN__LISTINT :
				getListint().clear();
				return;
			case TestoperationbodyPackage.MAIN__LISTCONCEPTA :
				getListconcepta().clear();
				return;
			case TestoperationbodyPackage.MAIN__SINGLEBOOL :
				setSinglebool(SINGLEBOOL_EDEFAULT);
				return;
			case TestoperationbodyPackage.MAIN__SINGLECONCEPTA :
				setSingleconcepta((ConceptA) null);
				return;
			case TestoperationbodyPackage.MAIN__CHILDREN :
				getChildren().clear();
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TestoperationbodyPackage.MAIN__LISTINT :
				return listint != null && !listint.isEmpty();
			case TestoperationbodyPackage.MAIN__LISTCONCEPTA :
				return listconcepta != null && !listconcepta.isEmpty();
			case TestoperationbodyPackage.MAIN__SINGLEBOOL :
				return singlebool != SINGLEBOOL_EDEFAULT;
			case TestoperationbodyPackage.MAIN__SINGLECONCEPTA :
				return singleconcepta != null;
			case TestoperationbodyPackage.MAIN__CHILDREN :
				return children != null && !children.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visittestoperationbody__Main(this);
	}
}
