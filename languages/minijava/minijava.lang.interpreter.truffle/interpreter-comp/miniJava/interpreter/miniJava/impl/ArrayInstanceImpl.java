package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import java.lang.Integer;
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

public class ArrayInstanceImpl extends MinimalEObjectImpl.Container {
	protected static final int SIZE_EDEFAULT = 0;

	protected int size = SIZE_EDEFAULT;

	protected EList<ValueImpl> value;

	protected ArrayInstanceImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.ARRAY_INSTANCE;
	}

	@TruffleBoundary
	public EList<ValueImpl> getValue() {
		if (value == null) {
			value = new EObjectContainmentEList<ValueImpl>(ValueImpl.class, this, MiniJavaPackage.ARRAY_INSTANCE__VALUE);
		}
		return value;
	}

	@TruffleBoundary
	public int getSize() {
		return size;
	}

	@TruffleBoundary
	public void setSize(int newSize) {
		int oldSize = size;
		size = newSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.ARRAY_INSTANCE__SIZE, oldSize, size));
	}

	@Override
	@TruffleBoundary
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case MiniJavaPackage.ARRAY_INSTANCE__VALUE :
				return ((InternalEList<?>) getValue()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	@TruffleBoundary
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MiniJavaPackage.ARRAY_INSTANCE__VALUE :
				return getValue();
			case MiniJavaPackage.ARRAY_INSTANCE__SIZE :
				return getSize();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	@TruffleBoundary
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MiniJavaPackage.ARRAY_INSTANCE__VALUE :
				getValue().clear();
				getValue().addAll((Collection<? extends ValueImpl>) newValue);
				return;
			case MiniJavaPackage.ARRAY_INSTANCE__SIZE :
				setSize((Integer) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	@TruffleBoundary
	public void eUnset(int featureID) {
		switch (featureID) {
			case MiniJavaPackage.ARRAY_INSTANCE__VALUE :
				getValue().clear();
				return;
			case MiniJavaPackage.ARRAY_INSTANCE__SIZE :
				setSize(SIZE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	@TruffleBoundary
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MiniJavaPackage.ARRAY_INSTANCE__VALUE :
				return value != null && !value.isEmpty();
			case MiniJavaPackage.ARRAY_INSTANCE__SIZE :
				return size != SIZE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}
}
