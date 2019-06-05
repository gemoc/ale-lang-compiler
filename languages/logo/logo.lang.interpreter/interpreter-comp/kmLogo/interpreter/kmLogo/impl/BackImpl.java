package kmLogo.interpreter.kmLogo.impl;

import java.lang.Double;
import java.lang.Object;
import java.lang.Override;
import kmLogo.interpreter.kmLogo.Back;
import kmLogo.interpreter.kmLogo.Expression;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import kmLogo.interpreter.kmLogo.Turtle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

public class BackImpl extends PrimitiveImpl implements Back {
	protected Expression steps;

	protected BackImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.BACK;
	}

	public Expression getSteps() {
		return steps;
	}

	public NotificationChain basicSetSteps(Expression newSteps, NotificationChain msgs) {
		Expression oldSteps = steps;
		steps = newSteps;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, KmLogoPackage.BACK__STEPS, oldSteps, newSteps);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	public void setSteps(Expression newSteps) {
		if (newSteps != steps) {
			NotificationChain msgs = null;
			if (steps != null)
				msgs = ((InternalEObject) steps).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - KmLogoPackage.BACK__STEPS, null, msgs);
			if (newSteps != null)
				msgs = ((InternalEObject) newSteps).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - KmLogoPackage.BACK__STEPS, null, msgs);
			msgs = basicSetSteps(newSteps, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KmLogoPackage.BACK__STEPS, newSteps, newSteps));
	}

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case KmLogoPackage.BACK__STEPS :
				return basicSetSteps(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case KmLogoPackage.BACK__STEPS :
				return getSteps();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case KmLogoPackage.BACK__STEPS :
				setSteps((Expression) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case KmLogoPackage.BACK__STEPS :
				setSteps((Expression) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case KmLogoPackage.BACK__STEPS :
				return steps != null;
		}
		return super.eIsSet(featureID);
	}

	public double eval(Turtle turtle) {
		double result;
		double move = ((double) (((Expression) (this.getSteps())).eval((Turtle) (turtle))));
		((Turtle) (turtle)).forward((Double) (-(move)));
		result = (double) (0.0) ;
		return result;
	}
}
