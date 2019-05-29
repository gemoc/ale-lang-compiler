/**
 */
package testoperationbody.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import testoperationbody.ConceptA;
import testoperationbody.Main;
import testoperationbody.Parent;
import testoperationbody.TestoperationbodyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Main</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link testoperationbody.impl.MainImpl#getListint <em>Listint</em>}</li>
 *   <li>{@link testoperationbody.impl.MainImpl#getListconcepta <em>Listconcepta</em>}</li>
 *   <li>{@link testoperationbody.impl.MainImpl#isSinglebool <em>Singlebool</em>}</li>
 *   <li>{@link testoperationbody.impl.MainImpl#getSingleconcepta <em>Singleconcepta</em>}</li>
 *   <li>{@link testoperationbody.impl.MainImpl#getChildren <em>Children</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MainImpl extends MinimalEObjectImpl.Container implements Main {
	/**
	 * The cached value of the '{@link #getListint() <em>Listint</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getListint()
	 * @generated
	 * @ordered
	 */
	protected EList<Integer> listint;

	/**
	 * The cached value of the '{@link #getListconcepta() <em>Listconcepta</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getListconcepta()
	 * @generated
	 * @ordered
	 */
	protected EList<ConceptA> listconcepta;

	/**
	 * The default value of the '{@link #isSinglebool() <em>Singlebool</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSinglebool()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SINGLEBOOL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSinglebool() <em>Singlebool</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSinglebool()
	 * @generated
	 * @ordered
	 */
	protected boolean singlebool = SINGLEBOOL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSingleconcepta() <em>Singleconcepta</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSingleconcepta()
	 * @generated
	 * @ordered
	 */
	protected ConceptA singleconcepta;

	/**
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<Parent> children;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MainImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TestoperationbodyPackage.Literals.MAIN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Integer> getListint() {
		if (listint == null) {
			listint = new EDataTypeUniqueEList<Integer>(Integer.class, this, TestoperationbodyPackage.MAIN__LISTINT);
		}
		return listint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConceptA> getListconcepta() {
		if (listconcepta == null) {
			listconcepta = new EObjectContainmentEList<ConceptA>(ConceptA.class, this, TestoperationbodyPackage.MAIN__LISTCONCEPTA);
		}
		return listconcepta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSinglebool() {
		return singlebool;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSinglebool(boolean newSinglebool) {
		boolean oldSinglebool = singlebool;
		singlebool = newSinglebool;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestoperationbodyPackage.MAIN__SINGLEBOOL, oldSinglebool, singlebool));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConceptA getSingleconcepta() {
		if (singleconcepta != null && singleconcepta.eIsProxy()) {
			InternalEObject oldSingleconcepta = (InternalEObject)singleconcepta;
			singleconcepta = (ConceptA)eResolveProxy(oldSingleconcepta);
			if (singleconcepta != oldSingleconcepta) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TestoperationbodyPackage.MAIN__SINGLECONCEPTA, oldSingleconcepta, singleconcepta));
			}
		}
		return singleconcepta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConceptA basicGetSingleconcepta() {
		return singleconcepta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSingleconcepta(ConceptA newSingleconcepta) {
		ConceptA oldSingleconcepta = singleconcepta;
		singleconcepta = newSingleconcepta;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestoperationbodyPackage.MAIN__SINGLECONCEPTA, oldSingleconcepta, singleconcepta));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Parent> getChildren() {
		if (children == null) {
			children = new EObjectContainmentEList<Parent>(Parent.class, this, TestoperationbodyPackage.MAIN__CHILDREN);
		}
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TestoperationbodyPackage.MAIN__LISTCONCEPTA:
				return ((InternalEList<?>)getListconcepta()).basicRemove(otherEnd, msgs);
			case TestoperationbodyPackage.MAIN__CHILDREN:
				return ((InternalEList<?>)getChildren()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TestoperationbodyPackage.MAIN__LISTINT:
				return getListint();
			case TestoperationbodyPackage.MAIN__LISTCONCEPTA:
				return getListconcepta();
			case TestoperationbodyPackage.MAIN__SINGLEBOOL:
				return isSinglebool();
			case TestoperationbodyPackage.MAIN__SINGLECONCEPTA:
				if (resolve) return getSingleconcepta();
				return basicGetSingleconcepta();
			case TestoperationbodyPackage.MAIN__CHILDREN:
				return getChildren();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TestoperationbodyPackage.MAIN__LISTINT:
				getListint().clear();
				getListint().addAll((Collection<? extends Integer>) newValue);
				return;
			case TestoperationbodyPackage.MAIN__LISTCONCEPTA:
				getListconcepta().clear();
				getListconcepta().addAll((Collection<? extends ConceptA>) newValue);
				return;
			case TestoperationbodyPackage.MAIN__SINGLEBOOL:
				setSinglebool((Boolean)newValue);
				return;
			case TestoperationbodyPackage.MAIN__SINGLECONCEPTA:
				setSingleconcepta((ConceptA)newValue);
				return;
			case TestoperationbodyPackage.MAIN__CHILDREN:
				getChildren().clear();
				getChildren().addAll((Collection<? extends Parent>) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TestoperationbodyPackage.MAIN__LISTINT:
				getListint().clear();
				return;
			case TestoperationbodyPackage.MAIN__LISTCONCEPTA:
				getListconcepta().clear();
				return;
			case TestoperationbodyPackage.MAIN__SINGLEBOOL:
				setSinglebool(SINGLEBOOL_EDEFAULT);
				return;
			case TestoperationbodyPackage.MAIN__SINGLECONCEPTA:
				setSingleconcepta((ConceptA)null);
				return;
			case TestoperationbodyPackage.MAIN__CHILDREN:
				getChildren().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TestoperationbodyPackage.MAIN__LISTINT:
				return listint != null && !listint.isEmpty();
			case TestoperationbodyPackage.MAIN__LISTCONCEPTA:
				return listconcepta != null && !listconcepta.isEmpty();
			case TestoperationbodyPackage.MAIN__SINGLEBOOL:
				return singlebool != SINGLEBOOL_EDEFAULT;
			case TestoperationbodyPackage.MAIN__SINGLECONCEPTA:
				return singleconcepta != null;
			case TestoperationbodyPackage.MAIN__CHILDREN:
				return children != null && !children.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (listint: ");
		result.append(listint);
		result.append(", singlebool: ");
		result.append(singlebool);
		result.append(')');
		return result.toString();
	}

} //MainImpl
