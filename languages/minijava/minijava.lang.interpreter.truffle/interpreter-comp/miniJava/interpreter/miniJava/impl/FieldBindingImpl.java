package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import java.lang.Object;
import java.lang.Override;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

public class FieldBindingImpl extends MinimalEObjectImpl.Container {
	protected FieldImpl field;

	protected ValueImpl value;

	protected FieldBindingImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.FIELD_BINDING;
	}

	@TruffleBoundary
	public FieldImpl getField() {
		if (field != null && field.eIsProxy()) {
			InternalEObject oldField = (InternalEObject) field;
			field = (FieldImpl) eResolveProxy(oldField);
			if (field != oldField) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MiniJavaPackage.FIELD_BINDING__FIELD, oldField, field));
			}
		}
		return field;
	}

	public FieldImpl basicGetField() {
		return field;
	}

	@TruffleBoundary
	public void setField(FieldImpl newField) {
		FieldImpl oldField = field;
		field = newField;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.FIELD_BINDING__FIELD, oldField, field));
	}

	@TruffleBoundary
	public ValueImpl getValue() {
		return value;
	}

	@TruffleBoundary
	public NotificationChain basicSetValue(ValueImpl newValue, NotificationChain msgs) {
		ValueImpl oldValue = value;
		value = newValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MiniJavaPackage.FIELD_BINDING__VALUE, oldValue, newValue);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	@TruffleBoundary
	public void setValue(ValueImpl newValue) {
		if (newValue != value) {
			NotificationChain msgs = null;
			if (value != null)
				msgs = ((InternalEObject) value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.FIELD_BINDING__VALUE, null, msgs);
			if (newValue != null)
				msgs = ((InternalEObject) newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.FIELD_BINDING__VALUE, null, msgs);
			msgs = basicSetValue(newValue, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.FIELD_BINDING__VALUE, newValue, newValue));
	}

	@Override
	@TruffleBoundary
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case MiniJavaPackage.FIELD_BINDING__VALUE :
				return basicSetValue(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	@TruffleBoundary
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MiniJavaPackage.FIELD_BINDING__FIELD :
				if (resolve)
					return getField();
				return basicGetField();
			case MiniJavaPackage.FIELD_BINDING__VALUE :
				return getValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	@TruffleBoundary
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MiniJavaPackage.FIELD_BINDING__FIELD :
				setField((FieldImpl) newValue);
				return;
			case MiniJavaPackage.FIELD_BINDING__VALUE :
				setValue((ValueImpl) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	@TruffleBoundary
	public void eUnset(int featureID) {
		switch (featureID) {
			case MiniJavaPackage.FIELD_BINDING__FIELD :
				setField((FieldImpl) null);
				return;
			case MiniJavaPackage.FIELD_BINDING__VALUE :
				setValue((ValueImpl) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	@TruffleBoundary
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MiniJavaPackage.FIELD_BINDING__FIELD :
				return field != null;
			case MiniJavaPackage.FIELD_BINDING__VALUE :
				return value != null;
		}
		return super.eIsSet(featureID);
	}
}
