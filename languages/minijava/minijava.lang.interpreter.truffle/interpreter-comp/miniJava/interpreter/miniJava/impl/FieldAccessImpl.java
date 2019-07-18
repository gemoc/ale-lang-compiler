package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.Node.Child;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Object;
import java.lang.Override;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService;
import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;

@NodeInfo(
		description = "FieldAccess"
)
public class FieldAccessImpl extends ExpressionImpl {
	@Child
	protected ExpressionImpl receiver;

	protected FieldImpl field;

	protected FieldAccessImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.FIELD_ACCESS;
	}

	@TruffleBoundary
	public ExpressionImpl getReceiver() {
		return receiver;
	}

	@TruffleBoundary
	public NotificationChain basicSetReceiver(ExpressionImpl newReceiver, NotificationChain msgs) {
		ExpressionImpl oldReceiver = receiver;
		receiver = newReceiver;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MiniJavaPackage.FIELD_ACCESS__RECEIVER, oldReceiver, newReceiver);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	@TruffleBoundary
	public void setReceiver(ExpressionImpl newReceiver) {
		if (newReceiver != receiver) {
			NotificationChain msgs = null;
			if (receiver != null)
				msgs = ((InternalEObject) receiver).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.FIELD_ACCESS__RECEIVER, null, msgs);
			if (newReceiver != null)
				msgs = ((InternalEObject) newReceiver).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.FIELD_ACCESS__RECEIVER, null, msgs);
			msgs = basicSetReceiver(newReceiver, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.FIELD_ACCESS__RECEIVER, newReceiver, newReceiver));
	}

	@TruffleBoundary
	public FieldImpl getField() {
		if (field != null && field.eIsProxy()) {
			InternalEObject oldField = (InternalEObject) field;
			field = (FieldImpl) eResolveProxy(oldField);
			if (field != oldField) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MiniJavaPackage.FIELD_ACCESS__FIELD, oldField, field));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.FIELD_ACCESS__FIELD, oldField, field));
	}

	@Override
	@TruffleBoundary
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case MiniJavaPackage.FIELD_ACCESS__RECEIVER :
				return basicSetReceiver(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	@TruffleBoundary
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MiniJavaPackage.FIELD_ACCESS__RECEIVER :
				return getReceiver();
			case MiniJavaPackage.FIELD_ACCESS__FIELD :
				if (resolve)
					return getField();
				return basicGetField();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	@TruffleBoundary
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MiniJavaPackage.FIELD_ACCESS__RECEIVER :
				setReceiver((ExpressionImpl) newValue);
				return;
			case MiniJavaPackage.FIELD_ACCESS__FIELD :
				setField((FieldImpl) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	@TruffleBoundary
	public void eUnset(int featureID) {
		switch (featureID) {
			case MiniJavaPackage.FIELD_ACCESS__RECEIVER :
				setReceiver((ExpressionImpl) null);
				return;
			case MiniJavaPackage.FIELD_ACCESS__FIELD :
				setField((FieldImpl) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	@TruffleBoundary
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MiniJavaPackage.FIELD_ACCESS__RECEIVER :
				return receiver != null;
			case MiniJavaPackage.FIELD_ACCESS__FIELD :
				return field != null;
		}
		return super.eIsSet(featureID);
	}

	public ValueImpl evaluateExpression(StateImpl state) {
		ValueImpl result;
		ObjectRefValueImpl tmp0 = ((ObjectRefValueImpl) (((ExpressionImpl) (this.getReceiver())).evaluateExpression((StateImpl) (state))));
		ObjectInstanceImpl realReceiver = ((ObjectInstanceImpl) (tmp0.getInstance()));
		FieldImpl fld = ((FieldImpl) (this.getField()));
		FieldBindingImpl fb = ((FieldBindingImpl) (CollectionService.head(CollectionService.select(realReceiver.getFieldbindings(), (x) -> EqualService.equals((x.getField()), (fld))))));
		result = (ValueImpl) (fb.getValue()) ;
		return result;
	}
}
