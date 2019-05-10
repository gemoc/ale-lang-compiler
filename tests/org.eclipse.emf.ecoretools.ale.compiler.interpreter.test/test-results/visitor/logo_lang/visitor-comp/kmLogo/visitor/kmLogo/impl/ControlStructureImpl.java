package kmLogo.visitor.kmLogo.impl;

import java.lang.Object;
import java.lang.Override;
import kmLogo.visitor.kmLogo.ControlStructure;
import kmLogo.visitor.kmLogo.Expression;
import kmLogo.visitor.kmLogo.KmLogoPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import visitor.VisitorInterface;

public class ControlStructureImpl extends InstructionImpl implements ControlStructure {
	protected Expression condition;

	protected ControlStructureImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.CONTROL_STRUCTURE;
	}

	public Expression getCondition() {
		return condition;
	}

	public NotificationChain basicSetCondition(Expression newCondition, NotificationChain msgs) {
		Expression oldCondition = condition;
		condition = newCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, KmLogoPackage.CONTROL_STRUCTURE__CONDITION, oldCondition, newCondition);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	public void setCondition(Expression newCondition) {
		if (newCondition != condition) {
			NotificationChain msgs = null;
			if (condition != null)
				msgs = ((InternalEObject) condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - KmLogoPackage.CONTROL_STRUCTURE__CONDITION, null, msgs);
			if (newCondition != null)
				msgs = ((InternalEObject) newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - KmLogoPackage.CONTROL_STRUCTURE__CONDITION, null, msgs);
			msgs = basicSetCondition(newCondition, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, KmLogoPackage.CONTROL_STRUCTURE__CONDITION, newCondition, newCondition));
	}

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case KmLogoPackage.CONTROL_STRUCTURE__CONDITION :
				return basicSetCondition(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case KmLogoPackage.CONTROL_STRUCTURE__CONDITION :
				return getCondition();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case KmLogoPackage.CONTROL_STRUCTURE__CONDITION :
				setCondition((Expression) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case KmLogoPackage.CONTROL_STRUCTURE__CONDITION :
				setCondition((Expression) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case KmLogoPackage.CONTROL_STRUCTURE__CONDITION :
				return condition != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visitkmLogo__ControlStructure(this);
	}
}
