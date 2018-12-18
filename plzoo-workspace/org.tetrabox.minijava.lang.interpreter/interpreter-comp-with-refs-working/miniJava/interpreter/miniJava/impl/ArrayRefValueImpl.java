package miniJava.interpreter.miniJava.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import miniJava.interpreter.miniJava.ArrayInstance;
import miniJava.interpreter.miniJava.ArrayRefValue;
import miniJava.interpreter.miniJava.MiniJavaFactory;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.Value;

public class ArrayRefValueImpl extends ValueImpl implements ArrayRefValue {
	protected ArrayInstance instance;

	protected ArrayRefValueImpl() {
		super();
	}

	public Value copy() {
		Value result;
		ArrayRefValue tmp = ((ArrayRefValue) MiniJavaFactory.eINSTANCE.createArrayRefValue());
		tmp.setInstance(this.instance);
		result = tmp;
		;
		return result;
	}

	public ArrayInstance basicGetInstance() {
		return instance;
	}

	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case MiniJavaPackage.ARRAY_REF_VALUE__INSTANCE:
			if (resolve)
				return getInstance();
			return basicGetInstance();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case MiniJavaPackage.ARRAY_REF_VALUE__INSTANCE:
			return instance != null;
		}
		return super.eIsSet(featureID);
	}

	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case MiniJavaPackage.ARRAY_REF_VALUE__INSTANCE:
			setInstance((ArrayInstance) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.ARRAY_REF_VALUE;
	}

	public void eUnset(int featureID) {
		switch (featureID) {
		case MiniJavaPackage.ARRAY_REF_VALUE__INSTANCE:
			setInstance((ArrayInstance) null);
			return;
		}
		super.eUnset(featureID);
	}

	public ArrayInstance getInstance() {
		return instance;
	}

	public void setInstance(ArrayInstance newInstance) {
		ArrayInstance oldInstance = instance;
		instance = newInstance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.ARRAY_REF_VALUE__INSTANCE,
					oldInstance, instance));
	}
}
