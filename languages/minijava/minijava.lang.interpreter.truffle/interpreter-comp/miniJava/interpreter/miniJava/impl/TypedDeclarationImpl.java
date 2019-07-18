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
		description = "TypedDeclaration"
)
public class TypedDeclarationImpl extends NamedElementImpl {
	@Child
	protected TypeRefImpl typeRef;

	protected TypedDeclarationImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.TYPED_DECLARATION;
	}

	@TruffleBoundary
	public TypeRefImpl getTypeRef() {
		return typeRef;
	}

	@TruffleBoundary
	public NotificationChain basicSetTypeRef(TypeRefImpl newTypeRef, NotificationChain msgs) {
		TypeRefImpl oldTypeRef = typeRef;
		typeRef = newTypeRef;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MiniJavaPackage.TYPED_DECLARATION__TYPE_REF, oldTypeRef, newTypeRef);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	@TruffleBoundary
	public void setTypeRef(TypeRefImpl newTypeRef) {
		if (newTypeRef != typeRef) {
			NotificationChain msgs = null;
			if (typeRef != null)
				msgs = ((InternalEObject) typeRef).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.TYPED_DECLARATION__TYPE_REF, null, msgs);
			if (newTypeRef != null)
				msgs = ((InternalEObject) newTypeRef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.TYPED_DECLARATION__TYPE_REF, null, msgs);
			msgs = basicSetTypeRef(newTypeRef, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.TYPED_DECLARATION__TYPE_REF, newTypeRef, newTypeRef));
	}

	@Override
	@TruffleBoundary
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case MiniJavaPackage.TYPED_DECLARATION__TYPE_REF :
				return basicSetTypeRef(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	@TruffleBoundary
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MiniJavaPackage.TYPED_DECLARATION__TYPE_REF :
				return getTypeRef();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	@TruffleBoundary
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MiniJavaPackage.TYPED_DECLARATION__TYPE_REF :
				setTypeRef((TypeRefImpl) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	@TruffleBoundary
	public void eUnset(int featureID) {
		switch (featureID) {
			case MiniJavaPackage.TYPED_DECLARATION__TYPE_REF :
				setTypeRef((TypeRefImpl) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	@TruffleBoundary
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MiniJavaPackage.TYPED_DECLARATION__TYPE_REF :
				return typeRef != null;
		}
		return super.eIsSet(featureID);
	}
}
