package miniJava.interpreter.miniJava.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import miniJava.interpreter.miniJava.Expression;
import miniJava.interpreter.miniJava.Field;
import miniJava.interpreter.miniJava.FieldAccess;
import miniJava.interpreter.miniJava.FieldBinding;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.ObjectInstance;
import miniJava.interpreter.miniJava.ObjectRefValue;
import miniJava.interpreter.miniJava.State;
import miniJava.interpreter.miniJava.Value;

public class FieldAccessImpl extends ExpressionImpl implements FieldAccess {
	protected Field field;

	protected Expression receiver;

	protected FieldAccessImpl() {
		super();
	}

	public Field basicGetField() {
		return field;
	}

	public NotificationChain basicSetReceiver(Expression newReceiver, NotificationChain msgs) {
		Expression oldReceiver = receiver;
		receiver = newReceiver;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					MiniJavaPackage.FIELD_ACCESS__RECEIVER, oldReceiver, newReceiver);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case MiniJavaPackage.FIELD_ACCESS__RECEIVER:
			return getReceiver();
		case MiniJavaPackage.FIELD_ACCESS__FIELD:
			if (resolve)
				return getField();
			return basicGetField();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case MiniJavaPackage.FIELD_ACCESS__RECEIVER:
			return basicSetReceiver(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case MiniJavaPackage.FIELD_ACCESS__RECEIVER:
			return receiver != null;
		case MiniJavaPackage.FIELD_ACCESS__FIELD:
			return field != null;
		}
		return super.eIsSet(featureID);
	}

	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case MiniJavaPackage.FIELD_ACCESS__RECEIVER:
			setReceiver((Expression) newValue);
			return;
		case MiniJavaPackage.FIELD_ACCESS__FIELD:
			setField((Field) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.FIELD_ACCESS;
	}

	public void eUnset(int featureID) {
		switch (featureID) {
		case MiniJavaPackage.FIELD_ACCESS__RECEIVER:
			setReceiver((Expression) null);
			return;
		case MiniJavaPackage.FIELD_ACCESS__FIELD:
			setField((Field) null);
			return;
		}
		super.eUnset(featureID);
	}

	public Value evaluateExpression(State state) {
		Value result;
		ObjectRefValue tmp0 = ((ObjectRefValue) this.receiver.evaluateExpression(state));
		ObjectInstance realReceiver = ((ObjectInstance) tmp0.getInstance());
		Field fld = ((Field) this.field);
		FieldBinding fb = ((FieldBinding) org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.head(
				org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.select(realReceiver.getFieldbindings(),
						(x) -> java.util.Objects.equals((x.getField()), (fld)))));
		result = fb.getValue();
		;
		return result;
	}

	public Field getField() {
		if (field != null && field.eIsProxy()) {
			InternalEObject oldField = (InternalEObject) field;
			field = (Field) eResolveProxy(oldField);
			if (field != oldField) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MiniJavaPackage.FIELD_ACCESS__FIELD,
							oldField, field));
			}
		}
		return field;
	}

	public Expression getReceiver() {
		return receiver;
	}

	public void setField(Field newField) {
		Field oldField = field;
		field = newField;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.FIELD_ACCESS__FIELD, oldField,
					field));
	}

	public void setReceiver(Expression newReceiver) {
		if (newReceiver != receiver) {
			NotificationChain msgs = null;
			if (receiver != null)
				msgs = ((InternalEObject) receiver).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - MiniJavaPackage.FIELD_ACCESS__RECEIVER, null, msgs);
			if (newReceiver != null)
				msgs = ((InternalEObject) newReceiver).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - MiniJavaPackage.FIELD_ACCESS__RECEIVER, null, msgs);
			msgs = basicSetReceiver(newReceiver, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.FIELD_ACCESS__RECEIVER, newReceiver,
					newReceiver));
	}
}
