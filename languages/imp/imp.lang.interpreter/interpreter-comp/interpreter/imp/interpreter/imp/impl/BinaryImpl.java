package interpreter.imp.interpreter.imp.impl;

import interpreter.imp.interpreter.imp.Binary;
import interpreter.imp.interpreter.imp.BinaryOp;
import interpreter.imp.interpreter.imp.Expr;
import interpreter.imp.interpreter.imp.ImpPackage;
import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

public class BinaryImpl extends ExprImpl implements Binary {
	protected static final BinaryOp OP_EDEFAULT = BinaryOp.ADD;

	protected BinaryOp op = OP_EDEFAULT;

	protected Expr lhs;

	protected Expr rhs;

	protected BinaryImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return ImpPackage.Literals.BINARY;
	}

	public Expr getLhs() {
		return lhs;
	}

	public NotificationChain basicSetLhs(Expr newLhs, NotificationChain msgs) {
		Expr oldLhs = lhs;
		lhs = newLhs;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ImpPackage.BINARY__LHS, oldLhs, newLhs);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	public void setLhs(Expr newLhs) {
		if (newLhs != lhs) {
			NotificationChain msgs = null;
			if (lhs != null)
				msgs = ((InternalEObject) lhs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ImpPackage.BINARY__LHS, null, msgs);
			if (newLhs != null)
				msgs = ((InternalEObject) newLhs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ImpPackage.BINARY__LHS, null, msgs);
			msgs = basicSetLhs(newLhs, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImpPackage.BINARY__LHS, newLhs, newLhs));
	}

	public Expr getRhs() {
		return rhs;
	}

	public NotificationChain basicSetRhs(Expr newRhs, NotificationChain msgs) {
		Expr oldRhs = rhs;
		rhs = newRhs;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ImpPackage.BINARY__RHS, oldRhs, newRhs);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	public void setRhs(Expr newRhs) {
		if (newRhs != rhs) {
			NotificationChain msgs = null;
			if (rhs != null)
				msgs = ((InternalEObject) rhs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ImpPackage.BINARY__RHS, null, msgs);
			if (newRhs != null)
				msgs = ((InternalEObject) newRhs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ImpPackage.BINARY__RHS, null, msgs);
			msgs = basicSetRhs(newRhs, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImpPackage.BINARY__RHS, newRhs, newRhs));
	}

	public BinaryOp getOp() {
		return op;
	}

	public void setOp(BinaryOp newOp) {
		BinaryOp oldOp = op;
		op = newOp == null ? OP_EDEFAULT : newOp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImpPackage.BINARY__OP, oldOp, op));
	}

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case ImpPackage.BINARY__LHS :
				return basicSetLhs(null, msgs);
			case ImpPackage.BINARY__RHS :
				return basicSetRhs(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ImpPackage.BINARY__LHS :
				return getLhs();
			case ImpPackage.BINARY__RHS :
				return getRhs();
			case ImpPackage.BINARY__OP :
				return getOp();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ImpPackage.BINARY__LHS :
				setLhs((Expr) newValue);
				return;
			case ImpPackage.BINARY__RHS :
				setRhs((Expr) newValue);
				return;
			case ImpPackage.BINARY__OP :
				setOp((BinaryOp) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ImpPackage.BINARY__LHS :
				setLhs((Expr) null);
				return;
			case ImpPackage.BINARY__RHS :
				setRhs((Expr) null);
				return;
			case ImpPackage.BINARY__OP :
				setOp(OP_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ImpPackage.BINARY__LHS :
				return lhs != null;
			case ImpPackage.BINARY__RHS :
				return rhs != null;
			case ImpPackage.BINARY__OP :
				return op != OP_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}
}
