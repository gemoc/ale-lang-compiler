package kmLogo.interpreter.kmLogo.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.Node.Child;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Object;
import java.lang.Override;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;

@NodeInfo(
		description = "If"
)
public class IfImpl extends ControlStructureImpl {
	@Child
	protected BlockImpl thenPart;

	@Child
	protected BlockImpl elsePart;

	protected IfImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.IF;
	}

	@TruffleBoundary
	public BlockImpl getThenPart() {
		return thenPart;
	}

	@TruffleBoundary
	public NotificationChain basicSetThenPart(BlockImpl newThenPart, NotificationChain msgs) {
		BlockImpl oldThenPart = thenPart;
		thenPart = newThenPart;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, KmLogoPackage.IF__THEN_PART, oldThenPart, newThenPart);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	@TruffleBoundary
	public void setThenPart(BlockImpl newThenPart) {
		if (newThenPart != thenPart) {
			NotificationChain msgs = null;
			if (thenPart != null)
				msgs = ((InternalEObject) thenPart).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - KmLogoPackage.IF__THEN_PART, null, msgs);
			if (newThenPart != null)
				msgs = ((InternalEObject) newThenPart).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - KmLogoPackage.IF__THEN_PART, null, msgs);
			msgs = basicSetThenPart(newThenPart, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KmLogoPackage.IF__THEN_PART, newThenPart, newThenPart));
	}

	@TruffleBoundary
	public BlockImpl getElsePart() {
		return elsePart;
	}

	@TruffleBoundary
	public NotificationChain basicSetElsePart(BlockImpl newElsePart, NotificationChain msgs) {
		BlockImpl oldElsePart = elsePart;
		elsePart = newElsePart;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, KmLogoPackage.IF__ELSE_PART, oldElsePart, newElsePart);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	@TruffleBoundary
	public void setElsePart(BlockImpl newElsePart) {
		if (newElsePart != elsePart) {
			NotificationChain msgs = null;
			if (elsePart != null)
				msgs = ((InternalEObject) elsePart).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - KmLogoPackage.IF__ELSE_PART, null, msgs);
			if (newElsePart != null)
				msgs = ((InternalEObject) newElsePart).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - KmLogoPackage.IF__ELSE_PART, null, msgs);
			msgs = basicSetElsePart(newElsePart, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KmLogoPackage.IF__ELSE_PART, newElsePart, newElsePart));
	}

	@Override
	@TruffleBoundary
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case KmLogoPackage.IF__THEN_PART :
				return basicSetThenPart(null, msgs);
			case KmLogoPackage.IF__ELSE_PART :
				return basicSetElsePart(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	@TruffleBoundary
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case KmLogoPackage.IF__THEN_PART :
				return getThenPart();
			case KmLogoPackage.IF__ELSE_PART :
				return getElsePart();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	@TruffleBoundary
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case KmLogoPackage.IF__THEN_PART :
				setThenPart((BlockImpl) newValue);
				return;
			case KmLogoPackage.IF__ELSE_PART :
				setElsePart((BlockImpl) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	@TruffleBoundary
	public void eUnset(int featureID) {
		switch (featureID) {
			case KmLogoPackage.IF__THEN_PART :
				setThenPart((BlockImpl) null);
				return;
			case KmLogoPackage.IF__ELSE_PART :
				setElsePart((BlockImpl) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	@TruffleBoundary
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case KmLogoPackage.IF__THEN_PART :
				return thenPart != null;
			case KmLogoPackage.IF__ELSE_PART :
				return elsePart != null;
		}
		return super.eIsSet(featureID);
	}

	public double eval(TurtleImpl turtle) {
		double result;
		if (!EqualService.equals((((ExpressionImpl) (this.condition)).eval((TurtleImpl) (turtle))), (0.0))) {
			result = (double) (((BlockImpl) (this.getThenPart())).eval((TurtleImpl) (turtle))) ;
		}
		else {
			if (!EqualService.equals((this.getElsePart()), (null))) {
				result = (double) (((BlockImpl) (this.getElsePart())).eval((TurtleImpl) (turtle))) ;
			}
			else {
				result = (double) (0.0) ;
			}
		}
		return result;
	}
}
