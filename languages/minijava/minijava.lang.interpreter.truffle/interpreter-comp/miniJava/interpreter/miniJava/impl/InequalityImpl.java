package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.Node.Child;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Object;
import java.lang.Override;
import miniJava.interpreter.miniJava.MiniJavaFactory;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;

@NodeInfo(
		description = "Inequality"
)
public class InequalityImpl extends ExpressionImpl {
	@Child
	protected ExpressionImpl left;

	@Child
	protected ExpressionImpl right;

	protected InequalityImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.INEQUALITY;
	}

	@TruffleBoundary
	public ExpressionImpl getLeft() {
		return left;
	}

	@TruffleBoundary
	public NotificationChain basicSetLeft(ExpressionImpl newLeft, NotificationChain msgs) {
		ExpressionImpl oldLeft = left;
		left = newLeft;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MiniJavaPackage.INEQUALITY__LEFT, oldLeft, newLeft);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	@TruffleBoundary
	public void setLeft(ExpressionImpl newLeft) {
		if (newLeft != left) {
			NotificationChain msgs = null;
			if (left != null)
				msgs = ((InternalEObject) left).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.INEQUALITY__LEFT, null, msgs);
			if (newLeft != null)
				msgs = ((InternalEObject) newLeft).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.INEQUALITY__LEFT, null, msgs);
			msgs = basicSetLeft(newLeft, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.INEQUALITY__LEFT, newLeft, newLeft));
	}

	@TruffleBoundary
	public ExpressionImpl getRight() {
		return right;
	}

	@TruffleBoundary
	public NotificationChain basicSetRight(ExpressionImpl newRight, NotificationChain msgs) {
		ExpressionImpl oldRight = right;
		right = newRight;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MiniJavaPackage.INEQUALITY__RIGHT, oldRight, newRight);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	@TruffleBoundary
	public void setRight(ExpressionImpl newRight) {
		if (newRight != right) {
			NotificationChain msgs = null;
			if (right != null)
				msgs = ((InternalEObject) right).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.INEQUALITY__RIGHT, null, msgs);
			if (newRight != null)
				msgs = ((InternalEObject) newRight).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.INEQUALITY__RIGHT, null, msgs);
			msgs = basicSetRight(newRight, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.INEQUALITY__RIGHT, newRight, newRight));
	}

	@Override
	@TruffleBoundary
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case MiniJavaPackage.INEQUALITY__LEFT :
				return basicSetLeft(null, msgs);
			case MiniJavaPackage.INEQUALITY__RIGHT :
				return basicSetRight(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	@TruffleBoundary
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MiniJavaPackage.INEQUALITY__LEFT :
				return getLeft();
			case MiniJavaPackage.INEQUALITY__RIGHT :
				return getRight();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	@TruffleBoundary
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MiniJavaPackage.INEQUALITY__LEFT :
				setLeft((ExpressionImpl) newValue);
				return;
			case MiniJavaPackage.INEQUALITY__RIGHT :
				setRight((ExpressionImpl) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	@TruffleBoundary
	public void eUnset(int featureID) {
		switch (featureID) {
			case MiniJavaPackage.INEQUALITY__LEFT :
				setLeft((ExpressionImpl) null);
				return;
			case MiniJavaPackage.INEQUALITY__RIGHT :
				setRight((ExpressionImpl) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	@TruffleBoundary
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MiniJavaPackage.INEQUALITY__LEFT :
				return left != null;
			case MiniJavaPackage.INEQUALITY__RIGHT :
				return right != null;
		}
		return super.eIsSet(featureID);
	}

	public ValueImpl evaluateExpression(StateImpl state) {
		ValueImpl result;
		ValueImpl left = ((ValueImpl) (((ExpressionImpl) (this.getLeft())).evaluateExpression((StateImpl) (state))));
		ValueImpl right = ((ValueImpl) (((ExpressionImpl) (this.getRight())).evaluateExpression((StateImpl) (state))));
		boolean tmp = ((boolean) (false));
		if (left instanceof IntegerValueImpl) {
			if (right instanceof IntegerValueImpl) {
				IntegerValueImpl ileft = ((IntegerValueImpl) (left));
				IntegerValueImpl iright = ((IntegerValueImpl) (right));
				tmp = EqualService.equals((ileft.getValue()), (iright.getValue()));
			}
		}
		else {
			if (left instanceof StringValueImpl) {
				if (right instanceof StringValueImpl) {
					StringValueImpl ileft = ((StringValueImpl) (left));
					StringValueImpl iright = ((StringValueImpl) (right));
					tmp = EqualService.equals((ileft.getValue()), (iright.getValue()));
				}
			}
			else {
				if (left instanceof BooleanValueImpl) {
					if (right instanceof BooleanValueImpl) {
						BooleanValueImpl ileft = ((BooleanValueImpl) (left));
						BooleanValueImpl iright = ((BooleanValueImpl) (right));
						tmp = EqualService.equals((ileft.isValue()), (iright.isValue()));
					}
				}
				else {
					if (left instanceof NullValueImpl) {
						if (right instanceof NullValueImpl) {
							tmp = true;
						}
					}
					else {
						if (left instanceof ObjectRefValueImpl) {
							if (right instanceof ObjectRefValueImpl) {
								ObjectRefValueImpl ileft = ((ObjectRefValueImpl) (left));
								ObjectRefValueImpl iright = ((ObjectRefValueImpl) (right));
								tmp = EqualService.equals((ileft.getInstance()), (iright.getInstance()));
							}
						}
					}
				}
			}
		}
		BooleanValueImpl tmpo = ((BooleanValueImpl) (MiniJavaFactory.eINSTANCE.createBooleanValue()));
		tmpo.setValue(!(tmp));
		result = (ValueImpl) (tmpo) ;
		return result;
	}
}
