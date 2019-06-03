package interpreter.imp.interpreter.imp.impl;

import interpreter.imp.interpreter.imp.Expr;
import interpreter.imp.interpreter.imp.ImpPackage;
import interpreter.imp.interpreter.imp.Unary;
import interpreter.imp.interpreter.imp.UnaryOp;
import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

public class UnaryImpl extends ExprImpl implements Unary {
	protected static final UnaryOp OP_EDEFAULT = UnaryOp.NEGATE;

	protected UnaryOp op = OP_EDEFAULT;

	protected Expr expr;

	protected UnaryImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return ImpPackage.Literals.UNARY;
	}

	public UnaryOp getOp() {
		return op;
	}

	public void setOp(UnaryOp newOp) {
		UnaryOp oldOp = op;
		op = newOp == null ? OP_EDEFAULT : newOp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImpPackage.UNARY__OP, oldOp, op));
	}

	public Expr getExpr() {
		return expr;
	}

	public NotificationChain basicSetExpr(Expr newExpr, NotificationChain msgs) {
		Expr oldExpr = expr;
		expr = newExpr;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ImpPackage.UNARY__EXPR, oldExpr, newExpr);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	public void setExpr(Expr newExpr) {
		if (newExpr != expr) {
			NotificationChain msgs = null;
			if (expr != null)
				msgs = ((InternalEObject) expr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ImpPackage.UNARY__EXPR, null, msgs);
			if (newExpr != null)
				msgs = ((InternalEObject) newExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ImpPackage.UNARY__EXPR, null, msgs);
			msgs = basicSetExpr(newExpr, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImpPackage.UNARY__EXPR, newExpr, newExpr));
	}

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case ImpPackage.UNARY__EXPR :
				return basicSetExpr(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ImpPackage.UNARY__OP :
				return getOp();
			case ImpPackage.UNARY__EXPR :
				return getExpr();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ImpPackage.UNARY__OP :
				setOp((UnaryOp) newValue);
				return;
			case ImpPackage.UNARY__EXPR :
				setExpr((Expr) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ImpPackage.UNARY__OP :
				setOp(OP_EDEFAULT);
				return;
			case ImpPackage.UNARY__EXPR :
				setExpr((Expr) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ImpPackage.UNARY__OP :
				return op != OP_EDEFAULT;
			case ImpPackage.UNARY__EXPR :
				return expr != null;
		}
		return super.eIsSet(featureID);
	}
}
