package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import java.lang.Object;
import java.lang.Override;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

public class NewCallImpl extends CallImpl {
	protected NewObjectImpl newz;

	protected NewCallImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.NEW_CALL;
	}

	@TruffleBoundary
	public NewObjectImpl getNewz() {
		if (newz != null && newz.eIsProxy()) {
			InternalEObject oldNewz = (InternalEObject) newz;
			newz = (NewObjectImpl) eResolveProxy(oldNewz);
			if (newz != oldNewz) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MiniJavaPackage.NEW_CALL__NEWZ, oldNewz, newz));
			}
		}
		return newz;
	}

	public NewObjectImpl basicGetNewz() {
		return newz;
	}

	@TruffleBoundary
	public void setNewz(NewObjectImpl newNewz) {
		NewObjectImpl oldNewz = newz;
		newz = newNewz;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.NEW_CALL__NEWZ, oldNewz, newz));
	}

	@Override
	@TruffleBoundary
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MiniJavaPackage.NEW_CALL__NEWZ :
				if (resolve)
					return getNewz();
				return basicGetNewz();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	@TruffleBoundary
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MiniJavaPackage.NEW_CALL__NEWZ :
				setNewz((NewObjectImpl) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	@TruffleBoundary
	public void eUnset(int featureID) {
		switch (featureID) {
			case MiniJavaPackage.NEW_CALL__NEWZ :
				setNewz((NewObjectImpl) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	@TruffleBoundary
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MiniJavaPackage.NEW_CALL__NEWZ :
				return newz != null;
		}
		return super.eIsSet(featureID);
	}
}
