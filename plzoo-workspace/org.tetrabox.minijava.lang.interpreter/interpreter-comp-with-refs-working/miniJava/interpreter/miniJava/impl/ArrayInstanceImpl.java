package miniJava.interpreter.miniJava.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import miniJava.interpreter.miniJava.ArrayInstance;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.Value;

public class ArrayInstanceImpl extends MinimalEObjectImpl.Container implements ArrayInstance {
	protected static final int SIZE_EDEFAULT = 0;

	protected int size = SIZE_EDEFAULT;

	protected EList<Value> value;

	protected ArrayInstanceImpl() {
		super();
	}

	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case MiniJavaPackage.ARRAY_INSTANCE__VALUE:
			return getValue();
		case MiniJavaPackage.ARRAY_INSTANCE__SIZE:
			return getSize();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case MiniJavaPackage.ARRAY_INSTANCE__VALUE:
			return ((InternalEList<?>) getValue()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case MiniJavaPackage.ARRAY_INSTANCE__VALUE:
			return value != null && !value.isEmpty();
		case MiniJavaPackage.ARRAY_INSTANCE__SIZE:
			return size != SIZE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case MiniJavaPackage.ARRAY_INSTANCE__VALUE:
			getValue().clear();
			getValue().addAll((Collection<? extends Value>) newValue);
			return;
		case MiniJavaPackage.ARRAY_INSTANCE__SIZE:
			setSize((int) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.ARRAY_INSTANCE;
	}

	public void eUnset(int featureID) {
		switch (featureID) {
		case MiniJavaPackage.ARRAY_INSTANCE__VALUE:
			getValue().clear();
			return;
		case MiniJavaPackage.ARRAY_INSTANCE__SIZE:
			setSize(SIZE_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	public int getSize() {
		return size;
	}

	public EList<Value> getValue() {
		if (value == null) {
			value = new EObjectContainmentEList<Value>(Value.class, this, MiniJavaPackage.ARRAY_INSTANCE__VALUE);
		}
		return value;
	}

	public void setSize(int newSize) {
		int oldSize = size;
		size = newSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.ARRAY_INSTANCE__SIZE, oldSize, size));
	}
}
