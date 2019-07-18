package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.Node.Child;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Object;
import java.lang.Override;
import miniJava.interpreter.miniJava.MiniJavaFactory;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

@NodeInfo(
		description = "NewArray"
)
public class NewArrayImpl extends ExpressionImpl {
	@Child
	protected TypeRefImpl type;

	@Child
	protected ExpressionImpl size;

	protected NewArrayImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.NEW_ARRAY;
	}

	@TruffleBoundary
	public TypeRefImpl getType() {
		return type;
	}

	@TruffleBoundary
	public NotificationChain basicSetType(TypeRefImpl newType, NotificationChain msgs) {
		TypeRefImpl oldType = type;
		type = newType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MiniJavaPackage.NEW_ARRAY__TYPE, oldType, newType);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	@TruffleBoundary
	public void setType(TypeRefImpl newType) {
		if (newType != type) {
			NotificationChain msgs = null;
			if (type != null)
				msgs = ((InternalEObject) type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.NEW_ARRAY__TYPE, null, msgs);
			if (newType != null)
				msgs = ((InternalEObject) newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.NEW_ARRAY__TYPE, null, msgs);
			msgs = basicSetType(newType, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.NEW_ARRAY__TYPE, newType, newType));
	}

	@TruffleBoundary
	public ExpressionImpl getSize() {
		return size;
	}

	@TruffleBoundary
	public NotificationChain basicSetSize(ExpressionImpl newSize, NotificationChain msgs) {
		ExpressionImpl oldSize = size;
		size = newSize;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MiniJavaPackage.NEW_ARRAY__SIZE, oldSize, newSize);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	@TruffleBoundary
	public void setSize(ExpressionImpl newSize) {
		if (newSize != size) {
			NotificationChain msgs = null;
			if (size != null)
				msgs = ((InternalEObject) size).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.NEW_ARRAY__SIZE, null, msgs);
			if (newSize != null)
				msgs = ((InternalEObject) newSize).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.NEW_ARRAY__SIZE, null, msgs);
			msgs = basicSetSize(newSize, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.NEW_ARRAY__SIZE, newSize, newSize));
	}

	@Override
	@TruffleBoundary
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case MiniJavaPackage.NEW_ARRAY__TYPE :
				return basicSetType(null, msgs);
			case MiniJavaPackage.NEW_ARRAY__SIZE :
				return basicSetSize(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	@TruffleBoundary
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MiniJavaPackage.NEW_ARRAY__TYPE :
				return getType();
			case MiniJavaPackage.NEW_ARRAY__SIZE :
				return getSize();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	@TruffleBoundary
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MiniJavaPackage.NEW_ARRAY__TYPE :
				setType((TypeRefImpl) newValue);
				return;
			case MiniJavaPackage.NEW_ARRAY__SIZE :
				setSize((ExpressionImpl) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	@TruffleBoundary
	public void eUnset(int featureID) {
		switch (featureID) {
			case MiniJavaPackage.NEW_ARRAY__TYPE :
				setType((TypeRefImpl) null);
				return;
			case MiniJavaPackage.NEW_ARRAY__SIZE :
				setSize((ExpressionImpl) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	@TruffleBoundary
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MiniJavaPackage.NEW_ARRAY__TYPE :
				return type != null;
			case MiniJavaPackage.NEW_ARRAY__SIZE :
				return size != null;
		}
		return super.eIsSet(featureID);
	}

	public ValueImpl evaluateExpression(StateImpl state) {
		ValueImpl result;
		ArrayInstanceImpl res = ((ArrayInstanceImpl) (MiniJavaFactory.eINSTANCE.createArrayInstance()));
		IntegerValueImpl sizeArray = ((IntegerValueImpl) (((IntegerValueImpl) (((ExpressionImpl) (this.getSize())).evaluateExpression((StateImpl) (state))))));
		res.setSize(sizeArray.getValue());
		state.getArraysHeap().add(res);
		ValueImpl defaultValue = ((ValueImpl) (null));
		if (this.getType() instanceof IntegerTypeRefImpl) {
			IntegerValueImpl idv = ((IntegerValueImpl) (MiniJavaFactory.eINSTANCE.createIntegerValue()));
			idv.setValue(0);
			defaultValue = idv;
		}
		else {
			if (this.getType() instanceof BooleanTypeRefImpl) {
				BooleanValueImpl idv = ((BooleanValueImpl) (MiniJavaFactory.eINSTANCE.createBooleanValue()));
				idv.setValue(false);
				defaultValue = idv;
			}
			else {
				if (this.getType() instanceof StringTypeRefImpl) {
					NullValueImpl idv = ((NullValueImpl) (MiniJavaFactory.eINSTANCE.createNullValue()));
					defaultValue = idv;
				}
				else {
					if (this.getType() instanceof ClassRefImpl) {
						NullValueImpl idv = ((NullValueImpl) (MiniJavaFactory.eINSTANCE.createNullValue()));
						defaultValue = idv;
					}
				}
			}
		}
		int i = ((int) (0));
		int sz = ((int) (res.getSize()));
		while ((i) < (sz)) {
			ValueImpl dv = ((ValueImpl) (defaultValue));
			ValueImpl v = ((ValueImpl) (dv.copyj()));
			res.getValue().add(v);
			i = (i) + (1);
		}
		ArrayRefValueImpl ret = ((ArrayRefValueImpl) (MiniJavaFactory.eINSTANCE.createArrayRefValue()));
		ret.setInstance(res);
		result = (ValueImpl) (ret) ;
		return result;
	}
}
