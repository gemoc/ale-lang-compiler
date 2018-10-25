package kmLogo.interpreter.kmLogo.impl;

import java.lang.Object;
import kmLogo.interpreter.kmLogo.CallStack;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import kmLogo.interpreter.kmLogo.Point;
import kmLogo.interpreter.kmLogo.Segment;
import kmLogo.interpreter.kmLogo.Turtle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;

public class TurtleImpl extends MinimalEObjectImpl.Container implements Turtle {
  protected static final double HEADING_EDEFAULT = 0.0;

  protected static final boolean PENUP_EDEFAULT = false;

  protected double heading = HEADING_EDEFAULT;

  protected boolean penUp = PENUP_EDEFAULT;

  protected Point position;

  protected EList<Segment> drawings;

  protected CallStack callStack;

  protected TurtleImpl() {
    super();
  }

  public double getHeading() {
    return heading;}

  public void setHeading(double heading) {
    this.heading = heading;}

  public boolean isPenUp() {
    return penUp;}

  public void setPenUp(boolean penUp) {
    this.penUp = penUp;}

  public void setPosition(Point newPosition) {
    if (newPosition != position) {
    	NotificationChain msgs = null;
    	if (position != null)
    		msgs = ((InternalEObject)position).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - kmLogo.interpreter.kmLogo.KmLogoPackage.TURTLE__POSITION, null, msgs);
    	if (newPosition != null)
    		msgs = ((InternalEObject)newPosition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - kmLogo.interpreter.kmLogo.KmLogoPackage.TURTLE__POSITION, null, msgs);
    	msgs = basicSetPosition(newPosition, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, kmLogo.interpreter.kmLogo.KmLogoPackage.TURTLE__POSITION, newPosition, newPosition));
  }

  public NotificationChain basicSetPosition(Point newPosition, NotificationChain msgs) {
    Point oldPosition = position;
    position = newPosition;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, kmLogo.interpreter.kmLogo.KmLogoPackage.TURTLE__POSITION, oldPosition, newPosition);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  public Point getPosition() {
    return position;}

  public EList<Segment> getDrawings() {
    if(drawings == null) {
    	drawings = new EObjectContainmentEList<Segment>(kmLogo.interpreter.kmLogo.Segment.class, this, KmLogoPackage.TURTLE__DRAWINGS);
    }
    return drawings;
  }

  public void setCallStack(CallStack newCallStack) {
    if (newCallStack != callStack) {
    	NotificationChain msgs = null;
    	if (callStack != null)
    		msgs = ((InternalEObject)callStack).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - kmLogo.interpreter.kmLogo.KmLogoPackage.TURTLE__CALL_STACK, null, msgs);
    	if (newCallStack != null)
    		msgs = ((InternalEObject)newCallStack).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - kmLogo.interpreter.kmLogo.KmLogoPackage.TURTLE__CALL_STACK, null, msgs);
    	msgs = basicSetCallStack(newCallStack, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, kmLogo.interpreter.kmLogo.KmLogoPackage.TURTLE__CALL_STACK, newCallStack, newCallStack));
  }

  public NotificationChain basicSetCallStack(CallStack newCallStack, NotificationChain msgs) {
    CallStack oldCallStack = callStack;
    callStack = newCallStack;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, kmLogo.interpreter.kmLogo.KmLogoPackage.TURTLE__CALL_STACK, oldCallStack, newCallStack);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  public CallStack getCallStack() {
    return callStack;}

  protected EClass eStaticClass() {
    return KmLogoPackage.Literals.TURTLE;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case KmLogoPackage.TURTLE__POSITION:
    	setPosition((kmLogo.interpreter.kmLogo.Point) newValue);
    return;
    case KmLogoPackage.TURTLE__HEADING:
    	setHeading((double) newValue);
    return;
    case KmLogoPackage.TURTLE__PEN_UP:
    	setPenUp((boolean) newValue);
    return;
    case KmLogoPackage.TURTLE__DRAWINGS:
    	getDrawings().clear();
    	getDrawings().addAll((java.util.Collection<? extends kmLogo.interpreter.kmLogo.Segment>) newValue);
    return;
    case KmLogoPackage.TURTLE__CALL_STACK:
    	setCallStack((kmLogo.interpreter.kmLogo.CallStack) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case KmLogoPackage.TURTLE__POSITION:
    	setPosition((kmLogo.interpreter.kmLogo.Point) null);
    return;
    case KmLogoPackage.TURTLE__HEADING:
    	setHeading(HEADING_EDEFAULT);
    return;
    case KmLogoPackage.TURTLE__PEN_UP:
    	setPenUp(PENUP_EDEFAULT);
    return;
    case KmLogoPackage.TURTLE__DRAWINGS:
    	getDrawings().clear();
    return;
    case KmLogoPackage.TURTLE__CALL_STACK:
    	setCallStack((kmLogo.interpreter.kmLogo.CallStack) null);
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case KmLogoPackage.TURTLE__POSITION:
    	return getPosition();
    case KmLogoPackage.TURTLE__HEADING:
    	return getHeading();
    case KmLogoPackage.TURTLE__PEN_UP:
    	return isPenUp();
    case KmLogoPackage.TURTLE__DRAWINGS:
    	return getDrawings();
    case KmLogoPackage.TURTLE__CALL_STACK:
    	return getCallStack();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case KmLogoPackage.TURTLE__POSITION:
    	return position != null;
    case KmLogoPackage.TURTLE__HEADING:
    	return heading != HEADING_EDEFAULT;
    case KmLogoPackage.TURTLE__PEN_UP:
    	return penUp != PENUP_EDEFAULT;
    case KmLogoPackage.TURTLE__DRAWINGS:
    	return drawings != null && !drawings.isEmpty();
    case KmLogoPackage.TURTLE__CALL_STACK:
    	return callStack != null;
    }
    return super.eIsSet(featureID);
  }

  public void move(double dx, double dy) {
    Point newPos = ((Point)kmLogo.interpreter.kmLogo.KmLogoFactory.eINSTANCE.createPoint());
    newPos.setX((this.getPosition().getX()) + (dx));
    newPos.setY((this.getPosition().getY()) + (dy));
    if(this.isPenUp()) {
    }
    else {
      Segment newSegment = ((Segment)kmLogo.interpreter.kmLogo.KmLogoFactory.eINSTANCE.createSegment());
      newSegment.setBegin(this.getPosition());
      newSegment.setEnd(newPos);
      this.getDrawings().add(newSegment);
    }
    Point newPosCopy = ((Point)kmLogo.interpreter.kmLogo.KmLogoFactory.eINSTANCE.createPoint());
    newPosCopy.setX(newPos.getX());
    newPosCopy.setY(newPos.getY());
    this.setPosition(newPosCopy);
  }

  public void forward(double steps) {
    this.move((steps) * (org.eclipse.emf.ecoretools.ale.core.interpreter.services.TrigoServices.cosinus(this.getHeading())),(steps) * (org.eclipse.emf.ecoretools.ale.core.interpreter.services.TrigoServices.sinus(this.getHeading())));
  }

  public void rotate(double angle) {
    double newAngle = ((double)(this.getHeading()) + (angle));
    if((newAngle) > (360.0)) {
      newAngle = (newAngle) - (360.0);
      this.setHeading(newAngle);
    }
    else {
      if((newAngle) < (0.0)) {
        newAngle = (360.0) + (newAngle);
        this.setHeading(newAngle);
      }
      else {
        this.setHeading(newAngle);
      }
    }
  }
}
