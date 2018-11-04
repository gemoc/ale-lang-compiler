package kmLogo.interpreter.kmLogo.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.Node.Child;
import com.oracle.truffle.api.nodes.NodeInfo;

import kmLogo.interpreter.kmLogo.KmLogoPackage;
import kmLogo.interpreter.kmLogo.Point;
import kmLogo.interpreter.kmLogo.Segment;

@NodeInfo(
    description = "Segment"
)
public class SegmentImpl extends MinimalEObjectImpl.Container implements Segment {
  @Child
  protected Point begin;

  @Child
  protected Point end;

  protected SegmentImpl() {
    super();
  }

  @TruffleBoundary
  public void setBegin(Point newBegin) {
    if (newBegin != begin) {
    	NotificationChain msgs = null;
    	if (begin != null)
    		msgs = ((InternalEObject)begin).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - kmLogo.interpreter.kmLogo.KmLogoPackage.SEGMENT__BEGIN, null, msgs);
    	if (newBegin != null)
    		msgs = ((InternalEObject)newBegin).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - kmLogo.interpreter.kmLogo.KmLogoPackage.SEGMENT__BEGIN, null, msgs);
    	msgs = basicSetBegin(newBegin, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, kmLogo.interpreter.kmLogo.KmLogoPackage.SEGMENT__BEGIN, newBegin, newBegin));
  }

  @TruffleBoundary
  public NotificationChain basicSetBegin(Point newBegin, NotificationChain msgs) {
    Point oldBegin = begin;
    begin = newBegin;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, kmLogo.interpreter.kmLogo.KmLogoPackage.SEGMENT__BEGIN, oldBegin, newBegin);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  @TruffleBoundary
  public Point getBegin() {
    return begin;}

  @TruffleBoundary
  public void setEnd(Point newEnd) {
    if (newEnd != end) {
    	NotificationChain msgs = null;
    	if (end != null)
    		msgs = ((InternalEObject)end).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - kmLogo.interpreter.kmLogo.KmLogoPackage.SEGMENT__END, null, msgs);
    	if (newEnd != null)
    		msgs = ((InternalEObject)newEnd).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - kmLogo.interpreter.kmLogo.KmLogoPackage.SEGMENT__END, null, msgs);
    	msgs = basicSetEnd(newEnd, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, kmLogo.interpreter.kmLogo.KmLogoPackage.SEGMENT__END, newEnd, newEnd));
  }

  @TruffleBoundary
  public NotificationChain basicSetEnd(Point newEnd, NotificationChain msgs) {
    Point oldEnd = end;
    end = newEnd;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, kmLogo.interpreter.kmLogo.KmLogoPackage.SEGMENT__END, oldEnd, newEnd);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  @TruffleBoundary
  public Point getEnd() {
    return end;}

  @TruffleBoundary
  protected EClass eStaticClass() {
    return KmLogoPackage.Literals.SEGMENT;}

  @TruffleBoundary
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case KmLogoPackage.SEGMENT__BEGIN:
    	setBegin((kmLogo.interpreter.kmLogo.Point) newValue);
    return;
    case KmLogoPackage.SEGMENT__END:
    	setEnd((kmLogo.interpreter.kmLogo.Point) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  @TruffleBoundary
  public void eUnset(int featureID) {
    switch (featureID) {
    case KmLogoPackage.SEGMENT__BEGIN:
    	setBegin((kmLogo.interpreter.kmLogo.Point) null);
    return;
    case KmLogoPackage.SEGMENT__END:
    	setEnd((kmLogo.interpreter.kmLogo.Point) null);
    return;
    }
    super.eUnset(featureID);
  }

  @TruffleBoundary
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case KmLogoPackage.SEGMENT__BEGIN:
    return getBegin();
    case KmLogoPackage.SEGMENT__END:
    return getEnd();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  @TruffleBoundary
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case KmLogoPackage.SEGMENT__BEGIN:
    	return begin != null;
    case KmLogoPackage.SEGMENT__END:
    	return end != null;
    }
    return super.eIsSet(featureID);
  }

  @TruffleBoundary
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case kmLogo.interpreter.kmLogo.KmLogoPackage.SEGMENT__BEGIN:
    	return basicSetBegin(null, msgs);
    case kmLogo.interpreter.kmLogo.KmLogoPackage.SEGMENT__END:
    	return basicSetEnd(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }
}
