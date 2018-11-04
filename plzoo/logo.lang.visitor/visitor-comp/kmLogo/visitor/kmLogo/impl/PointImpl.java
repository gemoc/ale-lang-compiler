package kmLogo.visitor.kmLogo.impl;

import java.lang.Object;
import kmLogo.visitor.kmLogo.KmLogoPackage;
import kmLogo.visitor.kmLogo.Point;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import visitor.VisitorInterface;

public class PointImpl extends MinimalEObjectImpl.Container implements Point {
  protected static final double X_EDEFAULT = 0.0;

  protected static final double Y_EDEFAULT = 0.0;

  protected double x = X_EDEFAULT;

  protected double y = Y_EDEFAULT;

  protected PointImpl() {
    super();
  }

  public double getX() {
    return x;}

  public void setX(double x) {
    this.x = x;}

  public double getY() {
    return y;}

  public void setY(double y) {
    this.y = y;}

  protected EClass eStaticClass() {
    return KmLogoPackage.Literals.POINT;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case KmLogoPackage.POINT__X:
    	setX((double) newValue);
    return;
    case KmLogoPackage.POINT__Y:
    	setY((double) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case KmLogoPackage.POINT__X:
    	setX(X_EDEFAULT);
    return;
    case KmLogoPackage.POINT__Y:
    	setY(Y_EDEFAULT);
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case KmLogoPackage.POINT__X:
    return getX();
    case KmLogoPackage.POINT__Y:
    return getY();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case KmLogoPackage.POINT__X:
    	return x != X_EDEFAULT;
    case KmLogoPackage.POINT__Y:
    	return y != Y_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  public Object accept(VisitorInterface visitor) {
    return visitor.visitkmLogo__Point(this);}
}
