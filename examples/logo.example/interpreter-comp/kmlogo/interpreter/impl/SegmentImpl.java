package kmlogo.interpreter.impl;

import java.lang.Object;
import kmlogo.interpreter.KmLogoPackage;
import kmlogo.interpreter.Point;
import kmlogo.interpreter.Segment;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

public class SegmentImpl extends MinimalEObjectImpl.Container implements Segment {
  private Point begin;

  private Point end;

  public void setBegin(Point newBegin) {
    if (newBegin != begin) {
    	NotificationChain msgs = null;
    	if (begin != null)
    		msgs = ((InternalEObject) begin).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - KmLogoPackage.SEGMENT__BEGIN, null, msgs);
    	if (newBegin != null)
    		msgs = ((InternalEObject) newBegin).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - KmLogoPackage.SEGMENT__BEGIN, null, msgs);
    	msgs = basicSetBegin(newBegin, msgs);
    	if (msgs != null)
    		msgs.dispatch();
    } else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, KmLogoPackage.SEGMENT__BEGIN, newBegin, newBegin));
  }

  private NotificationChain basicSetBegin(Point newBegin, NotificationChain msgsp) {
    NotificationChain msgs = msgsp;
    Point oldBegin = begin;
    begin = newBegin;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, KmLogoPackage.SEGMENT__BEGIN,
    			oldBegin, newBegin);
    	if (msgs == null)
    		msgs = notification;
    	else
    		msgs.add(notification);
    }
    return msgs;
  }

  public Point getBegin() {
    return begin;}

  public void setEnd(Point newEnd) {
    if (newEnd != end) {
    	NotificationChain msgs = null;
    	if (end != null)
    		msgs = ((InternalEObject) end).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - KmLogoPackage.SEGMENT__END, null, msgs);
    	if (newEnd != null)
    		msgs = ((InternalEObject) newEnd).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - KmLogoPackage.SEGMENT__END, null, msgs);
    	msgs = basicSetEnd(newEnd, msgs);
    	if (msgs != null)
    		msgs.dispatch();
    } else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, KmLogoPackage.SEGMENT__END, newEnd, newEnd));
  }

  private NotificationChain basicSetEnd(Point newEnd, NotificationChain msgsp) {
    NotificationChain msgs = msgsp;
    Point oldEnd = end;
    end = newEnd;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, KmLogoPackage.SEGMENT__END,
    			oldEnd, newEnd);
    	if (msgs == null)
    		msgs = notification;
    	else
    		msgs.add(notification);
    }
    return msgs;
  }

  public Point getEnd() {
    return end;}

  protected EClass eStaticClass() {
    return KmLogoPackage.Literals.SEGMENT;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case KmLogoPackage.SEGMENT__BEGIN:
    	setBegin((kmlogo.interpreter.impl.PointImpl) newValue);
    return;
    case KmLogoPackage.SEGMENT__END:
    	setEnd((kmlogo.interpreter.impl.PointImpl) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case KmLogoPackage.SEGMENT__BEGIN:
    	setBegin((kmlogo.interpreter.impl.PointImpl) null);
    return;
    case KmLogoPackage.SEGMENT__END:
    	setEnd((kmlogo.interpreter.impl.PointImpl) null);
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
