/**
 */
package boa.impl;

import boa.BoaPackage;
import boa.Copy;
import boa.Expr;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Copy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link boa.impl.CopyImpl#getCopy <em>Copy</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CopyImpl extends ExprImpl implements Copy {
	/**
	 * The cached value of the '{@link #getCopy() <em>Copy</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCopy()
	 * @generated
	 * @ordered
	 */
	protected Expr copy;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CopyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BoaPackage.Literals.COPY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expr getCopy() {
		return copy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCopy(Expr newCopy, NotificationChain msgs) {
		Expr oldCopy = copy;
		copy = newCopy;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BoaPackage.COPY__COPY, oldCopy, newCopy);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCopy(Expr newCopy) {
		if (newCopy != copy) {
			NotificationChain msgs = null;
			if (copy != null)
				msgs = ((InternalEObject)copy).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BoaPackage.COPY__COPY, null, msgs);
			if (newCopy != null)
				msgs = ((InternalEObject)newCopy).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BoaPackage.COPY__COPY, null, msgs);
			msgs = basicSetCopy(newCopy, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BoaPackage.COPY__COPY, newCopy, newCopy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BoaPackage.COPY__COPY:
				return basicSetCopy(null, msgs);
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
			case BoaPackage.COPY__COPY:
				return getCopy();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BoaPackage.COPY__COPY:
				setCopy((Expr)newValue);
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
			case BoaPackage.COPY__COPY:
				setCopy((Expr)null);
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
			case BoaPackage.COPY__COPY:
				return copy != null;
		}
		return super.eIsSet(featureID);
	}

} //CopyImpl
