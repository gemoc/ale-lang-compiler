package miniJava.interpreter.miniJava.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import miniJava.interpreter.miniJava.MiniJavaFactory;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.ObjectInstance;
import miniJava.interpreter.miniJava.ObjectRefValue;
import miniJava.interpreter.miniJava.Value;

public class ObjectRefValueImpl extends ValueImpl implements ObjectRefValue {
	protected ObjectInstance instance;

	protected ObjectRefValueImpl() {
		super();
	}

	public Value copy() {
		Value result;
		ObjectRefValue tmp = ((ObjectRefValue) MiniJavaFactory.eINSTANCE.createObjectRefValue());
		tmp.setInstance(this.instance);
		result = tmp;
		;
		return result;
	}

	public String customToString() {
		String result;
		result = this.instance.toString();
		;
		return result;
	}

	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case MiniJavaPackage.OBJECT_REF_VALUE__INSTANCE:
			return getInstance();
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
		case MiniJavaPackage.OBJECT_REF_VALUE__INSTANCE:
			return instance != null;
		}
		return super.eIsSet(featureID);
	}

	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case MiniJavaPackage.OBJECT_REF_VALUE__INSTANCE:
			setInstance((ObjectInstance) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.OBJECT_REF_VALUE;
	}

	public void eUnset(int featureID) {
		switch (featureID) {
		case MiniJavaPackage.OBJECT_REF_VALUE__INSTANCE:
			setInstance((ObjectInstance) null);
			return;
		}
		super.eUnset(featureID);
	}

	public ObjectInstance getInstance() {
		return instance;
	}

	public void setInstance(ObjectInstance newInstance) {
		ObjectInstance oldInstance = instance;
		instance = newInstance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.OBJECT_REF_VALUE__INSTANCE,
					oldInstance, instance));
	}
}
