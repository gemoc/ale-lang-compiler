package kmLogo.interpreter.kmLogo.impl;

import java.lang.Object;
import java.lang.Override;
import kmLogo.interpreter.kmLogo.BinaryExp;
import kmLogo.interpreter.kmLogo.Expression;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

public abstract class BinaryExpImpl extends ExpressionImpl implements BinaryExp {
	protected Expression lhs;

	protected Expression rhs;

	protected BinaryExpImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.BINARY_EXP;
	}

	public Expression getLhs() {
		return lhs;
	}

	public NotificationChain basicSetLhs(Expression newLhs, NotificationChain msgs) {
		Expression oldLhs = lhs;
		lhs = newLhs;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, KmLogoPackage.BINARY_EXP__LHS, oldLhs, newLhs);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	public void setLhs(Expression newLhs) {
		if (newLhs != lhs) {
			NotificationChain msgs = null;
			if (lhs != null)
				msgs = ((InternalEObject) lhs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - KmLogoPackage.BINARY_EXP__LHS, null, msgs);
			if (newLhs != null)
				msgs = ((InternalEObject) newLhs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - KmLogoPackage.BINARY_EXP__LHS, null, msgs);
			msgs = basicSetLhs(newLhs, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KmLogoPackage.BINARY_EXP__LHS, newLhs, newLhs));
	}

	public Expression getRhs() {
		return rhs;
	}

	public NotificationChain basicSetRhs(Expression newRhs, NotificationChain msgs) {
		Expression oldRhs = rhs;
		rhs = newRhs;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, KmLogoPackage.BINARY_EXP__RHS, oldRhs, newRhs);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	public void setRhs(Expression newRhs) {
		if (newRhs != rhs) {
			NotificationChain msgs = null;
			if (rhs != null)
				msgs = ((InternalEObject) rhs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - KmLogoPackage.BINARY_EXP__RHS, null, msgs);
			if (newRhs != null)
				msgs = ((InternalEObject) newRhs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - KmLogoPackage.BINARY_EXP__RHS, null, msgs);
			msgs = basicSetRhs(newRhs, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KmLogoPackage.BINARY_EXP__RHS, newRhs, newRhs));
	}

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case KmLogoPackage.BINARY_EXP__LHS :
				return basicSetLhs(null, msgs);
			case KmLogoPackage.BINARY_EXP__RHS :
				return basicSetRhs(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case KmLogoPackage.BINARY_EXP__LHS :
				return getLhs();
			case KmLogoPackage.BINARY_EXP__RHS :
				return getRhs();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case KmLogoPackage.BINARY_EXP__LHS :
				setLhs((Expression) newValue);
				return;
			case KmLogoPackage.BINARY_EXP__RHS :
				setRhs((Expression) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case KmLogoPackage.BINARY_EXP__LHS :
				setLhs((Expression) null);
				return;
			case KmLogoPackage.BINARY_EXP__RHS :
				setRhs((Expression) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case KmLogoPackage.BINARY_EXP__LHS :
				return lhs != null;
			case KmLogoPackage.BINARY_EXP__RHS :
				return rhs != null;
		}
		return super.eIsSet(featureID);
	}
}
