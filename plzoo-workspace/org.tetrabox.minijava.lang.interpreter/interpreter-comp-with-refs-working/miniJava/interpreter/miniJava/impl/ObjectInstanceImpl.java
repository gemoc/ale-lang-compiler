package miniJava.interpreter.miniJava.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;

import miniJava.interpreter.miniJava.Clazz;
import miniJava.interpreter.miniJava.FieldBinding;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.ObjectInstance;

public class ObjectInstanceImpl extends MinimalEObjectImpl.Container implements ObjectInstance {
	protected EList<FieldBinding> fieldbindings;

	protected Clazz type;

	protected ObjectInstanceImpl() {
		super();
	}

	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case MiniJavaPackage.OBJECT_INSTANCE__FIELDBINDINGS:
			return getFieldbindings();
		case MiniJavaPackage.OBJECT_INSTANCE__TYPE:
			return getType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case MiniJavaPackage.OBJECT_INSTANCE__FIELDBINDINGS:
			return ((org.eclipse.emf.ecore.util.InternalEList<?>) getFieldbindings()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case MiniJavaPackage.OBJECT_INSTANCE__FIELDBINDINGS:
			return fieldbindings != null && !fieldbindings.isEmpty();
		case MiniJavaPackage.OBJECT_INSTANCE__TYPE:
			return type != null;
		}
		return super.eIsSet(featureID);
	}

	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case MiniJavaPackage.OBJECT_INSTANCE__FIELDBINDINGS:
			getFieldbindings().clear();
			getFieldbindings().addAll((java.util.Collection<? extends FieldBinding>) newValue);
			return;
		case MiniJavaPackage.OBJECT_INSTANCE__TYPE:
			setType((Clazz) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.OBJECT_INSTANCE;
	}

	public void eUnset(int featureID) {
		switch (featureID) {
		case MiniJavaPackage.OBJECT_INSTANCE__FIELDBINDINGS:
			getFieldbindings().clear();
			return;
		case MiniJavaPackage.OBJECT_INSTANCE__TYPE:
			setType((Clazz) null);
			return;
		}
		super.eUnset(featureID);
	}

	public EList<FieldBinding> getFieldbindings() {
		if (fieldbindings == null) {
			fieldbindings = new EObjectContainmentEList<FieldBinding>(FieldBinding.class, this,
					MiniJavaPackage.OBJECT_INSTANCE__FIELDBINDINGS);
		}
		return fieldbindings;
	}

	public Clazz getType() {
		return type;
	}

	public void setType(Clazz newType) {
		Clazz oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.OBJECT_INSTANCE__TYPE, oldType,
					type));
	}
}
