package kmLogo.visitor.kmLogo.impl;

import java.lang.Object;
import java.lang.Override;
import kmLogo.visitor.kmLogo.Expression;
import kmLogo.visitor.kmLogo.KmLogoPackage;
import kmLogo.visitor.kmLogo.Right;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import visitor.VisitorInterface;

public class RightImpl extends PrimitiveImpl implements Right {
	protected Expression angle;

	protected RightImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.RIGHT;
	}

	public Expression getAngle() {
		return angle;
	}

	public NotificationChain basicSetAngle(Expression newAngle, NotificationChain msgs) {
		Expression oldAngle = angle;
		angle = newAngle;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, KmLogoPackage.RIGHT__ANGLE, oldAngle, newAngle);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	public void setAngle(Expression newAngle) {
		if (newAngle != angle) {
			NotificationChain msgs = null;
			if (angle != null)
				msgs = ((InternalEObject) angle).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - KmLogoPackage.RIGHT__ANGLE, null, msgs);
			if (newAngle != null)
				msgs = ((InternalEObject) newAngle).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - KmLogoPackage.RIGHT__ANGLE, null, msgs);
			msgs = basicSetAngle(newAngle, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KmLogoPackage.RIGHT__ANGLE, newAngle, newAngle));
	}

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case KmLogoPackage.RIGHT__ANGLE :
				return basicSetAngle(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case KmLogoPackage.RIGHT__ANGLE :
				return getAngle();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case KmLogoPackage.RIGHT__ANGLE :
				setAngle((Expression) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case KmLogoPackage.RIGHT__ANGLE :
				setAngle((Expression) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case KmLogoPackage.RIGHT__ANGLE :
				return angle != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visitkmLogo__Right(this);
	}
}
