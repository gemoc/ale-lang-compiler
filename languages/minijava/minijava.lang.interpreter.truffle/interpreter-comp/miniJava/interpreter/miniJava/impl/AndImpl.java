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

@NodeInfo(
		description = "And"
)
public class AndImpl extends ExpressionImpl {
	@Child
	protected ExpressionImpl left;

	@Child
	protected ExpressionImpl right;

	protected AndImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.AND;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MiniJavaPackage.AND__LEFT, oldLeft, newLeft);
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
				msgs = ((InternalEObject) left).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.AND__LEFT, null, msgs);
			if (newLeft != null)
				msgs = ((InternalEObject) newLeft).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.AND__LEFT, null, msgs);
			msgs = basicSetLeft(newLeft, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.AND__LEFT, newLeft, newLeft));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MiniJavaPackage.AND__RIGHT, oldRight, newRight);
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
				msgs = ((InternalEObject) right).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.AND__RIGHT, null, msgs);
			if (newRight != null)
				msgs = ((InternalEObject) newRight).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.AND__RIGHT, null, msgs);
			msgs = basicSetRight(newRight, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.AND__RIGHT, newRight, newRight));
	}

	@Override
	@TruffleBoundary
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case MiniJavaPackage.AND__LEFT :
				return basicSetLeft(null, msgs);
			case MiniJavaPackage.AND__RIGHT :
				return basicSetRight(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	@TruffleBoundary
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MiniJavaPackage.AND__LEFT :
				return getLeft();
			case MiniJavaPackage.AND__RIGHT :
				return getRight();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	@TruffleBoundary
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MiniJavaPackage.AND__LEFT :
				setLeft((ExpressionImpl) newValue);
				return;
			case MiniJavaPackage.AND__RIGHT :
				setRight((ExpressionImpl) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	@TruffleBoundary
	public void eUnset(int featureID) {
		switch (featureID) {
			case MiniJavaPackage.AND__LEFT :
				setLeft((ExpressionImpl) null);
				return;
			case MiniJavaPackage.AND__RIGHT :
				setRight((ExpressionImpl) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	@TruffleBoundary
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MiniJavaPackage.AND__LEFT :
				return left != null;
			case MiniJavaPackage.AND__RIGHT :
				return right != null;
		}
		return super.eIsSet(featureID);
	}

	public ValueImpl evaluateExpression(StateImpl state) {
		ValueImpl result;
		ValueImpl left = ((ValueImpl) (((ExpressionImpl) (this.getLeft())).evaluateExpression((StateImpl) (state))));
		ValueImpl right = ((ValueImpl) (((ExpressionImpl) (this.getRight())).evaluateExpression((StateImpl) (state))));
		if (left instanceof BooleanValueImpl) {
			if (right instanceof BooleanValueImpl) {
				BooleanValueImpl bleft = ((BooleanValueImpl) (left));
				BooleanValueImpl bright = ((BooleanValueImpl) (right));
				BooleanValueImpl tmp = ((BooleanValueImpl) (MiniJavaFactory.eINSTANCE.createBooleanValue()));
				tmp.setValue(((bleft.isValue()) && (bright.isValue())));
				result = (ValueImpl) (tmp) ;
			}
			else {
				result = (ValueImpl) (null) ;
			}
		}
		else {
			result = (ValueImpl) (null) ;
		}
		return result;
	}
}
