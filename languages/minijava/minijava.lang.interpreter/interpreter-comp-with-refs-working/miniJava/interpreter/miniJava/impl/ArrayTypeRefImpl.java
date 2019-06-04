package miniJava.interpreter.miniJava.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import miniJava.interpreter.miniJava.ArrayTypeRef;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.SingleTypeRef;

public class ArrayTypeRefImpl extends TypeRefImpl implements ArrayTypeRef {
	protected SingleTypeRef typeRef;

	protected ArrayTypeRefImpl() {
		super();
	}

	public NotificationChain basicSetTypeRef(SingleTypeRef newTypeRef, NotificationChain msgs) {
		SingleTypeRef oldTypeRef = typeRef;
		typeRef = newTypeRef;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					MiniJavaPackage.ARRAY_TYPE_REF__TYPE_REF, oldTypeRef, newTypeRef);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case MiniJavaPackage.ARRAY_TYPE_REF__TYPE_REF:
			return getTypeRef();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case MiniJavaPackage.ARRAY_TYPE_REF__TYPE_REF:
			return basicSetTypeRef(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case MiniJavaPackage.ARRAY_TYPE_REF__TYPE_REF:
			return typeRef != null;
		}
		return super.eIsSet(featureID);
	}

	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case MiniJavaPackage.ARRAY_TYPE_REF__TYPE_REF:
			setTypeRef((SingleTypeRef) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.ARRAY_TYPE_REF;
	}

	public void eUnset(int featureID) {
		switch (featureID) {
		case MiniJavaPackage.ARRAY_TYPE_REF__TYPE_REF:
			setTypeRef((SingleTypeRef) null);
			return;
		}
		super.eUnset(featureID);
	}

	public SingleTypeRef getTypeRef() {
		return typeRef;
	}

	public void setTypeRef(SingleTypeRef newTypeRef) {
		if (newTypeRef != typeRef) {
			NotificationChain msgs = null;
			if (typeRef != null)
				msgs = ((InternalEObject) typeRef).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - MiniJavaPackage.ARRAY_TYPE_REF__TYPE_REF, null, msgs);
			if (newTypeRef != null)
				msgs = ((InternalEObject) newTypeRef).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - MiniJavaPackage.ARRAY_TYPE_REF__TYPE_REF, null, msgs);
			msgs = basicSetTypeRef(newTypeRef, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.ARRAY_TYPE_REF__TYPE_REF, newTypeRef,
					newTypeRef));
	}
}
