package interpreter.kmLogo.interpreter.kmLogo.impl;

import interpreter.kmLogo.interpreter.kmLogo.KmLogoPackage;
import interpreter.kmLogo.interpreter.kmLogo.Point;
import java.lang.Double;
import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

public class PointImpl extends MinimalEObjectImpl.Container implements Point {
	protected static final double X_EDEFAULT = 0.0;

	protected static final double Y_EDEFAULT = 0.0;

	protected double x = X_EDEFAULT;

	protected double y = Y_EDEFAULT;

	protected PointImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.POINT;
	}

	public double getX() {
		return x;
	}

	public void setX(double newX) {
		double oldX = x;
		x = newX;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KmLogoPackage.POINT__X, oldX, x));
	}

	public double getY() {
		return y;
	}

	public void setY(double newY) {
		double oldY = y;
		y = newY;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KmLogoPackage.POINT__Y, oldY, y));
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case KmLogoPackage.POINT__X :
				return getX();
			case KmLogoPackage.POINT__Y :
				return getY();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case KmLogoPackage.POINT__X :
				setX((Double) newValue);
				return;
			case KmLogoPackage.POINT__Y :
				setY((Double) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case KmLogoPackage.POINT__X :
				setX(X_EDEFAULT);
				return;
			case KmLogoPackage.POINT__Y :
				setY(Y_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case KmLogoPackage.POINT__X :
				return x != X_EDEFAULT;
			case KmLogoPackage.POINT__Y :
				return y != Y_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}
}
