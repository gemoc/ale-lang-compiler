package miniJava.interpreter.miniJava.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import miniJava.interpreter.miniJava.BooleanValue;
import miniJava.interpreter.miniJava.Expression;
import miniJava.interpreter.miniJava.InferiorOrEqual;
import miniJava.interpreter.miniJava.IntegerValue;
import miniJava.interpreter.miniJava.MiniJavaFactory;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.State;
import miniJava.interpreter.miniJava.Value;

public class InferiorOrEqualImpl extends ExpressionImpl implements InferiorOrEqual {
	protected Expression left;

	protected Expression right;

	protected InferiorOrEqualImpl() {
		super();
	}

	public NotificationChain basicSetLeft(Expression newLeft, NotificationChain msgs) {
		Expression oldLeft = left;
		left = newLeft;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					MiniJavaPackage.INFERIOR_OR_EQUAL__LEFT, oldLeft, newLeft);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	public NotificationChain basicSetRight(Expression newRight, NotificationChain msgs) {
		Expression oldRight = right;
		right = newRight;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					MiniJavaPackage.INFERIOR_OR_EQUAL__RIGHT, oldRight, newRight);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case MiniJavaPackage.INFERIOR_OR_EQUAL__LEFT:
			return getLeft();
		case MiniJavaPackage.INFERIOR_OR_EQUAL__RIGHT:
			return getRight();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case MiniJavaPackage.INFERIOR_OR_EQUAL__LEFT:
			return basicSetLeft(null, msgs);
		case MiniJavaPackage.INFERIOR_OR_EQUAL__RIGHT:
			return basicSetRight(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case MiniJavaPackage.INFERIOR_OR_EQUAL__LEFT:
			return left != null;
		case MiniJavaPackage.INFERIOR_OR_EQUAL__RIGHT:
			return right != null;
		}
		return super.eIsSet(featureID);
	}

	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case MiniJavaPackage.INFERIOR_OR_EQUAL__LEFT:
			setLeft((Expression) newValue);
			return;
		case MiniJavaPackage.INFERIOR_OR_EQUAL__RIGHT:
			setRight((Expression) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.INFERIOR_OR_EQUAL;
	}

	public void eUnset(int featureID) {
		switch (featureID) {
		case MiniJavaPackage.INFERIOR_OR_EQUAL__LEFT:
			setLeft((Expression) null);
			return;
		case MiniJavaPackage.INFERIOR_OR_EQUAL__RIGHT:
			setRight((Expression) null);
			return;
		}
		super.eUnset(featureID);
	}

	public Value evaluateExpression(State state) {
		Value result;
		Value left = ((Value) this.left.evaluateExpression(state));
		Value right = ((Value) this.right.evaluateExpression(state));
		if (left instanceof IntegerValue) {
			if (right instanceof IntegerValue) {
				IntegerValue bleft = ((IntegerValue) left);
				IntegerValue bright = ((IntegerValue) right);
				BooleanValue tmp = ((BooleanValue) MiniJavaFactory.eINSTANCE.createBooleanValue());
				tmp.setValue((bleft.getValue()) <= (bright.getValue()));
				result = tmp;
			} else {
				result = null;
			}
		} else {
			result = null;
		}
		;
		return result;
	}

	public Expression getLeft() {
		return left;
	}

	public Expression getRight() {
		return right;
	}

	public void setLeft(Expression newLeft) {
		if (newLeft != left) {
			NotificationChain msgs = null;
			if (left != null)
				msgs = ((InternalEObject) left).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - MiniJavaPackage.INFERIOR_OR_EQUAL__LEFT, null, msgs);
			if (newLeft != null)
				msgs = ((InternalEObject) newLeft).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - MiniJavaPackage.INFERIOR_OR_EQUAL__LEFT, null, msgs);
			msgs = basicSetLeft(newLeft, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.INFERIOR_OR_EQUAL__LEFT, newLeft,
					newLeft));
	}

	public void setRight(Expression newRight) {
		if (newRight != right) {
			NotificationChain msgs = null;
			if (right != null)
				msgs = ((InternalEObject) right).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - MiniJavaPackage.INFERIOR_OR_EQUAL__RIGHT, null, msgs);
			if (newRight != null)
				msgs = ((InternalEObject) newRight).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - MiniJavaPackage.INFERIOR_OR_EQUAL__RIGHT, null, msgs);
			msgs = basicSetRight(newRight, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.INFERIOR_OR_EQUAL__RIGHT, newRight,
					newRight));
	}
}
