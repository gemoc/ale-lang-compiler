package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import java.lang.Object;
import java.lang.Override;
import java.util.Collection;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

public class ObjectInstanceImpl extends MinimalEObjectImpl.Container {
	protected EList<FieldBindingImpl> fieldbindings;

	protected ClazzImpl type;

	protected ObjectInstanceImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.OBJECT_INSTANCE;
	}

	@TruffleBoundary
	public EList<FieldBindingImpl> getFieldbindings() {
		if (fieldbindings == null) {
			fieldbindings = new EObjectContainmentEList<FieldBindingImpl>(FieldBindingImpl.class, this, MiniJavaPackage.OBJECT_INSTANCE__FIELDBINDINGS);
		}
		return fieldbindings;
	}

	@TruffleBoundary
	public ClazzImpl getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject) type;
			type = (ClazzImpl) eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MiniJavaPackage.OBJECT_INSTANCE__TYPE, oldType, type));
			}
		}
		return type;
	}

	public ClazzImpl basicGetType() {
		return type;
	}

	@TruffleBoundary
	public void setType(ClazzImpl newType) {
		ClazzImpl oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.OBJECT_INSTANCE__TYPE, oldType, type));
	}

	@Override
	@TruffleBoundary
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case MiniJavaPackage.OBJECT_INSTANCE__FIELDBINDINGS :
				return ((InternalEList<?>) getFieldbindings()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	@TruffleBoundary
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MiniJavaPackage.OBJECT_INSTANCE__FIELDBINDINGS :
				return getFieldbindings();
			case MiniJavaPackage.OBJECT_INSTANCE__TYPE :
				if (resolve)
					return getType();
				return basicGetType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	@TruffleBoundary
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MiniJavaPackage.OBJECT_INSTANCE__FIELDBINDINGS :
				getFieldbindings().clear();
				getFieldbindings().addAll((Collection<? extends FieldBindingImpl>) newValue);
				return;
			case MiniJavaPackage.OBJECT_INSTANCE__TYPE :
				setType((ClazzImpl) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	@TruffleBoundary
	public void eUnset(int featureID) {
		switch (featureID) {
			case MiniJavaPackage.OBJECT_INSTANCE__FIELDBINDINGS :
				getFieldbindings().clear();
				return;
			case MiniJavaPackage.OBJECT_INSTANCE__TYPE :
				setType((ClazzImpl) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	@TruffleBoundary
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MiniJavaPackage.OBJECT_INSTANCE__FIELDBINDINGS :
				return fieldbindings != null && !fieldbindings.isEmpty();
			case MiniJavaPackage.OBJECT_INSTANCE__TYPE :
				return type != null;
		}
		return super.eIsSet(featureID);
	}
}
