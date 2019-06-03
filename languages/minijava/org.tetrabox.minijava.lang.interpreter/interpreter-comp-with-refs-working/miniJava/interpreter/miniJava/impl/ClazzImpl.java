package miniJava.interpreter.miniJava.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import miniJava.interpreter.miniJava.Clazz;
import miniJava.interpreter.miniJava.MiniJavaPackage;

public class ClazzImpl extends TypeDeclarationImpl implements Clazz {
	protected static final boolean ISABSTRACT_EDEFAULT = false;

	protected boolean isabstract = ISABSTRACT_EDEFAULT;

	protected Clazz superClass;

	protected ClazzImpl() {
		super();
	}public Clazz basicGetSuperClass() {
		return superClass;
	}

	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case MiniJavaPackage.CLAZZ__ISABSTRACT:
			return isIsabstract();
		case MiniJavaPackage.CLAZZ__SUPER_CLASS:
			if (resolve)
				return getSuperClass();
			return basicGetSuperClass();
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
		case MiniJavaPackage.CLAZZ__ISABSTRACT:
			return isabstract != ISABSTRACT_EDEFAULT;
		case MiniJavaPackage.CLAZZ__SUPER_CLASS:
			return superClass != null;
		}
		return super.eIsSet(featureID);
	}

	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case MiniJavaPackage.CLAZZ__ISABSTRACT:
			setIsabstract((boolean) newValue);
			return;
		case MiniJavaPackage.CLAZZ__SUPER_CLASS:
			setSuperClass((Clazz) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.CLAZZ;
	}

	public void eUnset(int featureID) {
		switch (featureID) {
		case MiniJavaPackage.CLAZZ__ISABSTRACT:
			setIsabstract(ISABSTRACT_EDEFAULT);
			return;
		case MiniJavaPackage.CLAZZ__SUPER_CLASS:
			setSuperClass((Clazz) null);
			return;
		}
		super.eUnset(featureID);
	}

	public Clazz getSuperClass() {
	if (superClass != null && superClass.eIsProxy()) {
			InternalEObject oldSuperClass = (InternalEObject) superClass;
			superClass = (Clazz) eResolveProxy(oldSuperClass);
			if (superClass != oldSuperClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MiniJavaPackage.CLAZZ__SUPER_CLASS,
							oldSuperClass, superClass));
			}
		}
		return superClass;
	}

	public boolean isIsabstract() {
		return isabstract;
	}

	public void setIsabstract(boolean newIsabstract) {
		boolean oldIsabstract = isabstract;
		isabstract = newIsabstract;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.CLAZZ__ISABSTRACT, oldIsabstract,
					isabstract));
	}

	public void setSuperClass(Clazz newSuperClass) {
		Clazz oldSuperClass = superClass;
		superClass = newSuperClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.CLAZZ__SUPER_CLASS, oldSuperClass,
					superClass));
	}
}
