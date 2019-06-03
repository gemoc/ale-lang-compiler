package boa.visitor.boa.impl;

import boa.visitor.boa.BoaPackage;
import boa.visitor.boa.Copy;
import boa.visitor.boa.Expr;
import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import visitor.VisitorInterface;

public class CopyImpl extends ExprImpl implements Copy {
	protected Expr copy;

	protected CopyImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return BoaPackage.Literals.COPY;
	}

	public Expr getCopy() {
		return copy;
	}

	public NotificationChain basicSetCopy(Expr newCopy, NotificationChain msgs) {
		Expr oldCopy = copy;
		copy = newCopy;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BoaPackage.COPY__COPY, oldCopy, newCopy);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	public void setCopy(Expr newCopy) {
		if (newCopy != copy) {
			NotificationChain msgs = null;
			if (copy != null)
				msgs = ((InternalEObject) copy).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BoaPackage.COPY__COPY, null, msgs);
			if (newCopy != null)
				msgs = ((InternalEObject) newCopy).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BoaPackage.COPY__COPY, null, msgs);
			msgs = basicSetCopy(newCopy, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BoaPackage.COPY__COPY, newCopy, newCopy));
	}

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case BoaPackage.COPY__COPY :
				return basicSetCopy(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BoaPackage.COPY__COPY :
				return getCopy();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BoaPackage.COPY__COPY :
				setCopy((Expr) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case BoaPackage.COPY__COPY :
				setCopy((Expr) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case BoaPackage.COPY__COPY :
				return copy != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visitboa__Copy(this);
	}
}
