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

@NodeInfo(
		description = "ArrayTypeRef"
)
public class ArrayTypeRefImpl extends TypeRefImpl {
	@Child
	protected SingleTypeRefImpl typeRef;

	protected ArrayTypeRefImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.ARRAY_TYPE_REF;
	}

	@TruffleBoundary
	public SingleTypeRefImpl getTypeRef() {
		return typeRef;
	}

	@TruffleBoundary
	public NotificationChain basicSetTypeRef(SingleTypeRefImpl newTypeRef, NotificationChain msgs) {
		SingleTypeRefImpl oldTypeRef = typeRef;
		typeRef = newTypeRef;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MiniJavaPackage.ARRAY_TYPE_REF__TYPE_REF, oldTypeRef, newTypeRef);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	@TruffleBoundary
	public void setTypeRef(SingleTypeRefImpl newTypeRef) {
		if (newTypeRef != typeRef) {
			NotificationChain msgs = null;
			if (typeRef != null)
				msgs = ((InternalEObject) typeRef).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.ARRAY_TYPE_REF__TYPE_REF, null, msgs);
			if (newTypeRef != null)
				msgs = ((InternalEObject) newTypeRef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.ARRAY_TYPE_REF__TYPE_REF, null, msgs);
			msgs = basicSetTypeRef(newTypeRef, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.ARRAY_TYPE_REF__TYPE_REF, newTypeRef, newTypeRef));
	}

	@Override
	@TruffleBoundary
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case MiniJavaPackage.ARRAY_TYPE_REF__TYPE_REF :
				return basicSetTypeRef(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	@TruffleBoundary
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MiniJavaPackage.ARRAY_TYPE_REF__TYPE_REF :
				return getTypeRef();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	@TruffleBoundary
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MiniJavaPackage.ARRAY_TYPE_REF__TYPE_REF :
				setTypeRef((SingleTypeRefImpl) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	@TruffleBoundary
	public void eUnset(int featureID) {
		switch (featureID) {
			case MiniJavaPackage.ARRAY_TYPE_REF__TYPE_REF :
				setTypeRef((SingleTypeRefImpl) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	@TruffleBoundary
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MiniJavaPackage.ARRAY_TYPE_REF__TYPE_REF :
				return typeRef != null;
		}
		return super.eIsSet(featureID);
	}
}
