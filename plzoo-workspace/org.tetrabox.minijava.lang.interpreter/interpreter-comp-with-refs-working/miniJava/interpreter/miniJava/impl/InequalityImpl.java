package miniJava.interpreter.miniJava.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import miniJava.interpreter.miniJava.BooleanValue;
import miniJava.interpreter.miniJava.Expression;
import miniJava.interpreter.miniJava.Inequality;
import miniJava.interpreter.miniJava.IntegerValue;
import miniJava.interpreter.miniJava.MiniJavaFactory;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.NullValue;
import miniJava.interpreter.miniJava.ObjectRefValue;
import miniJava.interpreter.miniJava.State;
import miniJava.interpreter.miniJava.StringValue;
import miniJava.interpreter.miniJava.Value;

public class InequalityImpl extends ExpressionImpl implements Inequality {
	protected Expression left;

	protected Expression right;

	protected InequalityImpl() {
		super();
	}

	public NotificationChain basicSetLeft(Expression newLeft, NotificationChain msgs) {
		Expression oldLeft = left;
		left = newLeft;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					MiniJavaPackage.INEQUALITY__LEFT, oldLeft, newLeft);
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
					MiniJavaPackage.INEQUALITY__RIGHT, oldRight, newRight);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case MiniJavaPackage.INEQUALITY__LEFT:
			return getLeft();
		case MiniJavaPackage.INEQUALITY__RIGHT:
			return getRight();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case MiniJavaPackage.INEQUALITY__LEFT:
			return basicSetLeft(null, msgs);
		case MiniJavaPackage.INEQUALITY__RIGHT:
			return basicSetRight(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case MiniJavaPackage.INEQUALITY__LEFT:
			return left != null;
		case MiniJavaPackage.INEQUALITY__RIGHT:
			return right != null;
		}
		return super.eIsSet(featureID);
	}

	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case MiniJavaPackage.INEQUALITY__LEFT:
			setLeft((Expression) newValue);
			return;
		case MiniJavaPackage.INEQUALITY__RIGHT:
			setRight((Expression) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.INEQUALITY;
	}

	public void eUnset(int featureID) {
		switch (featureID) {
		case MiniJavaPackage.INEQUALITY__LEFT:
			setLeft((Expression) null);
			return;
		case MiniJavaPackage.INEQUALITY__RIGHT:
			setRight((Expression) null);
			return;
		}
		super.eUnset(featureID);
	}

	public Value evaluateExpression(State state) {
		Value result;
		Value left = ((Value) this.left.evaluateExpression(state));
		Value right = ((Value) this.right.evaluateExpression(state));
		boolean tmp = ((boolean) false);
		if (left instanceof IntegerValue) {
			if (right instanceof IntegerValue) {
				IntegerValue ileft = ((IntegerValue) left);
				IntegerValue iright = ((IntegerValue) right);
				tmp = java.util.Objects.equals((ileft.getValue()), (iright.getValue()));
			}
		} else {
			if (left instanceof StringValue) {
				if (right instanceof StringValue) {
					StringValue ileft = ((StringValue) left);
					StringValue iright = ((StringValue) right);
					tmp = java.util.Objects.equals((ileft.getValue()), (iright.getValue()));
				}
			} else {
				if (left instanceof BooleanValue) {
					if (right instanceof BooleanValue) {
						BooleanValue ileft = ((BooleanValue) left);
						BooleanValue iright = ((BooleanValue) right);
						tmp = java.util.Objects.equals((ileft.isValue()), (iright.isValue()));
					}
				} else {
					if (left instanceof NullValue) {
						if (right instanceof NullValue) {
							tmp = true;
						}
					} else {
						if (left instanceof ObjectRefValue) {
							if (right instanceof ObjectRefValue) {
								ObjectRefValue ileft = ((ObjectRefValue) left);
								ObjectRefValue iright = ((ObjectRefValue) right);
								tmp = java.util.Objects.equals((ileft.getInstance()), (iright.getInstance()));
							}
						}
					}
				}
			}
		}
		BooleanValue tmpo = ((BooleanValue) MiniJavaFactory.eINSTANCE.createBooleanValue());
		tmpo.setValue(!(tmp));
		result = tmpo;
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
						EOPPOSITE_FEATURE_BASE - MiniJavaPackage.INEQUALITY__LEFT, null, msgs);
			if (newLeft != null)
				msgs = ((InternalEObject) newLeft).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - MiniJavaPackage.INEQUALITY__LEFT, null, msgs);
			msgs = basicSetLeft(newLeft, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.INEQUALITY__LEFT, newLeft, newLeft));
	}

	public void setRight(Expression newRight) {
		if (newRight != right) {
			NotificationChain msgs = null;
			if (right != null)
				msgs = ((InternalEObject) right).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - MiniJavaPackage.INEQUALITY__RIGHT, null, msgs);
			if (newRight != null)
				msgs = ((InternalEObject) newRight).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - MiniJavaPackage.INEQUALITY__RIGHT, null, msgs);
			msgs = basicSetRight(newRight, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.INEQUALITY__RIGHT, newRight,
					newRight));
	}
}
