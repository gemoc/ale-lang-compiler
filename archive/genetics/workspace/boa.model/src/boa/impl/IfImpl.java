/**
 */
package boa.impl;

import boa.BoaPackage;
import boa.Expr;
import boa.If;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>If</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link boa.impl.IfImpl#getCond <em>Cond</em>}</li>
 *   <li>{@link boa.impl.IfImpl#getThn <em>Thn</em>}</li>
 *   <li>{@link boa.impl.IfImpl#getEls <em>Els</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfImpl extends ExprImpl implements If {
	/**
	 * The cached value of the '{@link #getCond() <em>Cond</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCond()
	 * @generated
	 * @ordered
	 */
	protected Expr cond;

	/**
	 * The cached value of the '{@link #getThn() <em>Thn</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThn()
	 * @generated
	 * @ordered
	 */
	protected Expr thn;

	/**
	 * The cached value of the '{@link #getEls() <em>Els</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEls()
	 * @generated
	 * @ordered
	 */
	protected Expr els;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BoaPackage.Literals.IF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expr getCond() {
		return cond;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCond(Expr newCond, NotificationChain msgs) {
		Expr oldCond = cond;
		cond = newCond;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BoaPackage.IF__COND, oldCond, newCond);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCond(Expr newCond) {
		if (newCond != cond) {
			NotificationChain msgs = null;
			if (cond != null)
				msgs = ((InternalEObject)cond).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BoaPackage.IF__COND, null, msgs);
			if (newCond != null)
				msgs = ((InternalEObject)newCond).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BoaPackage.IF__COND, null, msgs);
			msgs = basicSetCond(newCond, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BoaPackage.IF__COND, newCond, newCond));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expr getThn() {
		return thn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetThn(Expr newThn, NotificationChain msgs) {
		Expr oldThn = thn;
		thn = newThn;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BoaPackage.IF__THN, oldThn, newThn);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThn(Expr newThn) {
		if (newThn != thn) {
			NotificationChain msgs = null;
			if (thn != null)
				msgs = ((InternalEObject)thn).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BoaPackage.IF__THN, null, msgs);
			if (newThn != null)
				msgs = ((InternalEObject)newThn).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BoaPackage.IF__THN, null, msgs);
			msgs = basicSetThn(newThn, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BoaPackage.IF__THN, newThn, newThn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expr getEls() {
		return els;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEls(Expr newEls, NotificationChain msgs) {
		Expr oldEls = els;
		els = newEls;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BoaPackage.IF__ELS, oldEls, newEls);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEls(Expr newEls) {
		if (newEls != els) {
			NotificationChain msgs = null;
			if (els != null)
				msgs = ((InternalEObject)els).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BoaPackage.IF__ELS, null, msgs);
			if (newEls != null)
				msgs = ((InternalEObject)newEls).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BoaPackage.IF__ELS, null, msgs);
			msgs = basicSetEls(newEls, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BoaPackage.IF__ELS, newEls, newEls));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BoaPackage.IF__COND:
				return basicSetCond(null, msgs);
			case BoaPackage.IF__THN:
				return basicSetThn(null, msgs);
			case BoaPackage.IF__ELS:
				return basicSetEls(null, msgs);
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
			case BoaPackage.IF__COND:
				return getCond();
			case BoaPackage.IF__THN:
				return getThn();
			case BoaPackage.IF__ELS:
				return getEls();
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
			case BoaPackage.IF__COND:
				setCond((Expr)newValue);
				return;
			case BoaPackage.IF__THN:
				setThn((Expr)newValue);
				return;
			case BoaPackage.IF__ELS:
				setEls((Expr)newValue);
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
			case BoaPackage.IF__COND:
				setCond((Expr)null);
				return;
			case BoaPackage.IF__THN:
				setThn((Expr)null);
				return;
			case BoaPackage.IF__ELS:
				setEls((Expr)null);
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
			case BoaPackage.IF__COND:
				return cond != null;
			case BoaPackage.IF__THN:
				return thn != null;
			case BoaPackage.IF__ELS:
				return els != null;
		}
		return super.eIsSet(featureID);
	}

} //IfImpl
