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

@NodeInfo(
		description = "ArrayAccess"
)
public class ArrayAccessImpl extends ExpressionImpl {
	@Child
	protected ExpressionImpl object;

	@Child
	protected ExpressionImpl index;

	protected ArrayAccessImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.ARRAY_ACCESS;
	}

	@TruffleBoundary
	public ExpressionImpl getObject() {
		return object;
	}

	@TruffleBoundary
	public NotificationChain basicSetObject(ExpressionImpl newObject, NotificationChain msgs) {
		ExpressionImpl oldObject = object;
		object = newObject;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MiniJavaPackage.ARRAY_ACCESS__OBJECT, oldObject, newObject);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	@TruffleBoundary
	public void setObject(ExpressionImpl newObject) {
		if (newObject != object) {
			NotificationChain msgs = null;
			if (object != null)
				msgs = ((InternalEObject) object).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.ARRAY_ACCESS__OBJECT, null, msgs);
			if (newObject != null)
				msgs = ((InternalEObject) newObject).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.ARRAY_ACCESS__OBJECT, null, msgs);
			msgs = basicSetObject(newObject, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.ARRAY_ACCESS__OBJECT, newObject, newObject));
	}

	@TruffleBoundary
	public ExpressionImpl getIndex() {
		return index;
	}

	@TruffleBoundary
	public NotificationChain basicSetIndex(ExpressionImpl newIndex, NotificationChain msgs) {
		ExpressionImpl oldIndex = index;
		index = newIndex;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MiniJavaPackage.ARRAY_ACCESS__INDEX, oldIndex, newIndex);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	@TruffleBoundary
	public void setIndex(ExpressionImpl newIndex) {
		if (newIndex != index) {
			NotificationChain msgs = null;
			if (index != null)
				msgs = ((InternalEObject) index).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.ARRAY_ACCESS__INDEX, null, msgs);
			if (newIndex != null)
				msgs = ((InternalEObject) newIndex).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.ARRAY_ACCESS__INDEX, null, msgs);
			msgs = basicSetIndex(newIndex, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.ARRAY_ACCESS__INDEX, newIndex, newIndex));
	}

	@Override
	@TruffleBoundary
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case MiniJavaPackage.ARRAY_ACCESS__OBJECT :
				return basicSetObject(null, msgs);
			case MiniJavaPackage.ARRAY_ACCESS__INDEX :
				return basicSetIndex(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	@TruffleBoundary
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MiniJavaPackage.ARRAY_ACCESS__OBJECT :
				return getObject();
			case MiniJavaPackage.ARRAY_ACCESS__INDEX :
				return getIndex();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	@TruffleBoundary
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MiniJavaPackage.ARRAY_ACCESS__OBJECT :
				setObject((ExpressionImpl) newValue);
				return;
			case MiniJavaPackage.ARRAY_ACCESS__INDEX :
				setIndex((ExpressionImpl) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	@TruffleBoundary
	public void eUnset(int featureID) {
		switch (featureID) {
			case MiniJavaPackage.ARRAY_ACCESS__OBJECT :
				setObject((ExpressionImpl) null);
				return;
			case MiniJavaPackage.ARRAY_ACCESS__INDEX :
				setIndex((ExpressionImpl) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	@TruffleBoundary
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MiniJavaPackage.ARRAY_ACCESS__OBJECT :
				return object != null;
			case MiniJavaPackage.ARRAY_ACCESS__INDEX :
				return index != null;
		}
		return super.eIsSet(featureID);
	}

	public ValueImpl evaluateExpression(StateImpl state) {
		ValueImpl result;
		ArrayRefValueImpl arrayVal = ((ArrayRefValueImpl) (((ArrayRefValueImpl) (((ExpressionImpl) (this.getObject())).evaluateExpression((StateImpl) (state))))));
		IntegerValueImpl indexVal = ((IntegerValueImpl) (((IntegerValueImpl) (((ExpressionImpl) (this.getIndex())).evaluateExpression((StateImpl) (state))))));
		int v = ((int) (indexVal.getValue()));
		ValueImpl vtmp = ((ValueImpl) (CollectionService.get(arrayVal.getInstance().getValue(), v)));
		result = (ValueImpl) (((ValueImpl) (vtmp)).copyj()) ;
		return result;
	}
}
