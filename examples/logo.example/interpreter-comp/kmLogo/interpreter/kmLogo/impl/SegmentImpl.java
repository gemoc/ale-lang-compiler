package kmLogo.interpreter.kmLogo.impl;

import java.lang.Object;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import kmLogo.interpreter.kmLogo.Point;
import kmLogo.interpreter.kmLogo.Segment;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

public class SegmentImpl extends MinimalEObjectImpl.Container implements Segment {
  private Point begin;

  private Point end;

  public void setBegin(Point newBegin) {
    Point oldBegin = begin;
    begin = newBegin;
    if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, KmLogoPackage.SEGMENT__BEGIN, oldBegin, begin));
  }

  public Point getBegin() {
    return begin;}

  public void setEnd(Point newEnd) {
    Point oldEnd = end;
    end = newEnd;
    if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, KmLogoPackage.SEGMENT__END, oldEnd, end));
  }

  public Point getEnd() {
    return end;}

  protected EClass eStaticClass() {
    return KmLogoPackage.Literals.SEGMENT;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case KmLogoPackage.SEGMENT__BEGIN:
    	setBegin((kmLogo.interpreter.kmLogo.impl.PointImpl) newValue);
    return;
    case KmLogoPackage.SEGMENT__END:
    	setEnd((kmLogo.interpreter.kmLogo.impl.PointImpl) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case KmLogoPackage.SEGMENT__BEGIN:
    	setBegin((kmLogo.interpreter.kmLogo.impl.PointImpl) null);
    return;
    case KmLogoPackage.SEGMENT__END:
    	setEnd((kmLogo.interpreter.kmLogo.impl.PointImpl) null);
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case KmLogoPackage.SEGMENT__BEGIN:
    	return getBegin();
    case KmLogoPackage.SEGMENT__END:
    	return getEnd();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case KmLogoPackage.SEGMENT__BEGIN:
    	return begin != null;
    case KmLogoPackage.SEGMENT__END:
    	return end != null;
    }
    return super.eIsSet(featureID);
  }
}
