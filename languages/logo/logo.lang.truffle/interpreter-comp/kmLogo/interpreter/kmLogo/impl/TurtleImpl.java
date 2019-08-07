package kmLogo.interpreter.kmLogo.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import java.lang.Boolean;
import java.lang.Double;
import java.lang.Object;
import java.lang.Override;
import java.util.Collection;
import kmLogo.interpreter.kmLogo.CallStack;
import kmLogo.interpreter.kmLogo.KmLogoFactory;
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
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecoretools.ale.core.interpreter.services.TrigoServices;

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

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.TURTLE;
	}

	@TruffleBoundary
	public Point getPosition() {
		return position;
	}

	@TruffleBoundary
	public NotificationChain basicSetPosition(Point newPosition, NotificationChain msgs) {
		Point oldPosition = position;
		position = newPosition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, KmLogoPackage.TURTLE__POSITION, oldPosition, newPosition);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	@TruffleBoundary
	public void setPosition(Point newPosition) {
		if (newPosition != position) {
			NotificationChain msgs = null;
			if (position != null)
				msgs = ((InternalEObject) position).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - KmLogoPackage.TURTLE__POSITION, null, msgs);
			if (newPosition != null)
				msgs = ((InternalEObject) newPosition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - KmLogoPackage.TURTLE__POSITION, null, msgs);
			msgs = basicSetPosition(newPosition, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KmLogoPackage.TURTLE__POSITION, newPosition, newPosition));
	}

	@TruffleBoundary
	public double getHeading() {
		return heading;
	}

	@TruffleBoundary
	public void setHeading(double newHeading) {
		double oldHeading = heading;
		heading = newHeading;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KmLogoPackage.TURTLE__HEADING, oldHeading, heading));
	}

	@TruffleBoundary
	public boolean isPenUp() {
		return penUp;
	}

	@TruffleBoundary
	public void setPenUp(boolean newPenUp) {
		boolean oldPenUp = penUp;
		penUp = newPenUp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KmLogoPackage.TURTLE__PEN_UP, oldPenUp, penUp));
	}

	@TruffleBoundary
	public EList<Segment> getDrawings() {
		if (drawings == null) {
			drawings = new EObjectContainmentEList<Segment>(Segment.class, this, KmLogoPackage.TURTLE__DRAWINGS);
		}
		return drawings;
	}

	@TruffleBoundary
	public CallStack getCallStack() {
		return callStack;
	}

	@TruffleBoundary
	public NotificationChain basicSetCallStack(CallStack newCallStack, NotificationChain msgs) {
		CallStack oldCallStack = callStack;
		callStack = newCallStack;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, KmLogoPackage.TURTLE__CALL_STACK, oldCallStack, newCallStack);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	@TruffleBoundary
	public void setCallStack(CallStack newCallStack) {
		if (newCallStack != callStack) {
			NotificationChain msgs = null;
			if (callStack != null)
				msgs = ((InternalEObject) callStack).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - KmLogoPackage.TURTLE__CALL_STACK, null, msgs);
			if (newCallStack != null)
				msgs = ((InternalEObject) newCallStack).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - KmLogoPackage.TURTLE__CALL_STACK, null, msgs);
			msgs = basicSetCallStack(newCallStack, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KmLogoPackage.TURTLE__CALL_STACK, newCallStack, newCallStack));
	}

	@Override
	@TruffleBoundary
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case KmLogoPackage.TURTLE__POSITION :
				return basicSetPosition(null, msgs);
			case KmLogoPackage.TURTLE__DRAWINGS :
				return ((InternalEList<?>) getDrawings()).basicRemove(otherEnd, msgs);
			case KmLogoPackage.TURTLE__CALL_STACK :
				return basicSetCallStack(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	@TruffleBoundary
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case KmLogoPackage.TURTLE__POSITION :
				return getPosition();
			case KmLogoPackage.TURTLE__HEADING :
				return getHeading();
			case KmLogoPackage.TURTLE__PEN_UP :
				return isPenUp();
			case KmLogoPackage.TURTLE__DRAWINGS :
				return getDrawings();
			case KmLogoPackage.TURTLE__CALL_STACK :
				return getCallStack();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	@TruffleBoundary
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case KmLogoPackage.TURTLE__POSITION :
				setPosition((Point) newValue);
				return;
			case KmLogoPackage.TURTLE__HEADING :
				setHeading((Double) newValue);
				return;
			case KmLogoPackage.TURTLE__PEN_UP :
				setPenUp((Boolean) newValue);
				return;
			case KmLogoPackage.TURTLE__DRAWINGS :
				getDrawings().clear();
				getDrawings().addAll((Collection<? extends Segment>) newValue);
				return;
			case KmLogoPackage.TURTLE__CALL_STACK :
				setCallStack((CallStack) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	@TruffleBoundary
	public void eUnset(int featureID) {
		switch (featureID) {
			case KmLogoPackage.TURTLE__POSITION :
				setPosition((Point) null);
				return;
			case KmLogoPackage.TURTLE__HEADING :
				setHeading(HEADING_EDEFAULT);
				return;
			case KmLogoPackage.TURTLE__PEN_UP :
				setPenUp(PENUP_EDEFAULT);
				return;
			case KmLogoPackage.TURTLE__DRAWINGS :
				getDrawings().clear();
				return;
			case KmLogoPackage.TURTLE__CALL_STACK :
				setCallStack((CallStack) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	@TruffleBoundary
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case KmLogoPackage.TURTLE__POSITION :
				return position != null;
			case KmLogoPackage.TURTLE__HEADING :
				return heading != HEADING_EDEFAULT;
			case KmLogoPackage.TURTLE__PEN_UP :
				return penUp != PENUP_EDEFAULT;
			case KmLogoPackage.TURTLE__DRAWINGS :
				return drawings != null && !drawings.isEmpty();
			case KmLogoPackage.TURTLE__CALL_STACK :
				return callStack != null;
		}
		return super.eIsSet(featureID);
	}

	@TruffleBoundary
	public void move(double dx, double dy) {
		Point newPos = ((Point) (KmLogoFactory.eINSTANCE.createPoint()));
		newPos.setX((this.getPosition().getX()) + (dx));
		newPos.setY((this.getPosition().getY()) + (dy));
		if (this.penUp) {
		}
		else {
			Segment newSegment = ((Segment) (KmLogoFactory.eINSTANCE.createSegment()));
			newSegment.setBegin(this.getPosition());
			newSegment.setEnd(newPos);
			this.getDrawings().add(newSegment);
		}
		Point newPosCopy = ((Point) (KmLogoFactory.eINSTANCE.createPoint()));
		newPosCopy.setX(newPos.getX());
		newPosCopy.setY(newPos.getY());
		this.setPosition(newPosCopy);
	}

	@TruffleBoundary
	public void forward(double steps) {
		((Turtle) (this)).move((Double) ((steps) * (TrigoServices.cosinus((double) (this.heading)))), (Double) ((steps) * (TrigoServices.sinus((double) (this.heading)))));
	}

	@TruffleBoundary
	public void rotate(double angle) {
		double newAngle = ((double) ((this.heading) + (angle)));
		if ((newAngle) > (360.0)) {
			newAngle = (newAngle) - (360.0);
			this.setHeading(newAngle);
		}
		else {
			if ((newAngle) < (0.0)) {
				newAngle = (360.0) + (newAngle);
				this.setHeading(newAngle);
			}
			else {
				this.setHeading(newAngle);
			}
		}
	}
}
