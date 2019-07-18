package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Object;
import java.lang.Override;
import miniJava.interpreter.miniJava.AccessLevel;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

@NodeInfo(
		description = "Member"
)
public class MemberImpl extends TypedDeclarationImpl {
	protected static final AccessLevel ACCESS_EDEFAULT = AccessLevel.PRIVATE;

	protected AccessLevel access = ACCESS_EDEFAULT;

	protected MemberImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.MEMBER;
	}

	@TruffleBoundary
	public AccessLevel getAccess() {
		return access;
	}

	@TruffleBoundary
	public void setAccess(AccessLevel newAccess) {
		AccessLevel oldAccess = access;
		access = newAccess == null ? ACCESS_EDEFAULT : newAccess;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.MEMBER__ACCESS, oldAccess, access));
	}

	@Override
	@TruffleBoundary
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MiniJavaPackage.MEMBER__ACCESS :
				return getAccess();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	@TruffleBoundary
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MiniJavaPackage.MEMBER__ACCESS :
				setAccess((AccessLevel) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	@TruffleBoundary
	public void eUnset(int featureID) {
		switch (featureID) {
			case MiniJavaPackage.MEMBER__ACCESS :
				setAccess(ACCESS_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	@TruffleBoundary
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MiniJavaPackage.MEMBER__ACCESS :
				return access != ACCESS_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}
}
