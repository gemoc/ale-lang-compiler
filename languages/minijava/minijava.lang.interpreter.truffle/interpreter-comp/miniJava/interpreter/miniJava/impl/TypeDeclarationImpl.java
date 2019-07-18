package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Object;
import java.lang.Override;
import java.util.Collection;
import miniJava.interpreter.miniJava.AccessLevel;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

@NodeInfo(
		description = "TypeDeclaration"
)
public class TypeDeclarationImpl extends NamedElementImpl {
	protected static final AccessLevel ACCESSLEVEL_EDEFAULT = AccessLevel.PRIVATE;

	protected AccessLevel accessLevel = ACCESSLEVEL_EDEFAULT;

	protected EList<InterfaceImpl> implementz;

	protected EList<MemberImpl> members;

	protected TypeDeclarationImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.TYPE_DECLARATION;
	}

	@TruffleBoundary
	public AccessLevel getAccessLevel() {
		return accessLevel;
	}

	@TruffleBoundary
	public void setAccessLevel(AccessLevel newAccessLevel) {
		AccessLevel oldAccessLevel = accessLevel;
		accessLevel = newAccessLevel == null ? ACCESSLEVEL_EDEFAULT : newAccessLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.TYPE_DECLARATION__ACCESS_LEVEL, oldAccessLevel, accessLevel));
	}

	@TruffleBoundary
	public EList<InterfaceImpl> getImplementz() {
		if (implementz == null) {
			implementz = new EObjectResolvingEList<InterfaceImpl>(InterfaceImpl.class, this, MiniJavaPackage.TYPE_DECLARATION__IMPLEMENTZ);
		}
		return implementz;
	}

	@TruffleBoundary
	public EList<MemberImpl> getMembers() {
		if (members == null) {
			members = new EObjectContainmentEList<MemberImpl>(MemberImpl.class, this, MiniJavaPackage.TYPE_DECLARATION__MEMBERS);
		}
		return members;
	}

	@Override
	@TruffleBoundary
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case MiniJavaPackage.TYPE_DECLARATION__MEMBERS :
				return ((InternalEList<?>) getMembers()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	@TruffleBoundary
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MiniJavaPackage.TYPE_DECLARATION__ACCESS_LEVEL :
				return getAccessLevel();
			case MiniJavaPackage.TYPE_DECLARATION__IMPLEMENTZ :
				return getImplementz();
			case MiniJavaPackage.TYPE_DECLARATION__MEMBERS :
				return getMembers();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	@TruffleBoundary
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MiniJavaPackage.TYPE_DECLARATION__ACCESS_LEVEL :
				setAccessLevel((AccessLevel) newValue);
				return;
			case MiniJavaPackage.TYPE_DECLARATION__IMPLEMENTZ :
				getImplementz().clear();
				getImplementz().addAll((Collection<? extends InterfaceImpl>) newValue);
				return;
			case MiniJavaPackage.TYPE_DECLARATION__MEMBERS :
				getMembers().clear();
				getMembers().addAll((Collection<? extends MemberImpl>) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	@TruffleBoundary
	public void eUnset(int featureID) {
		switch (featureID) {
			case MiniJavaPackage.TYPE_DECLARATION__ACCESS_LEVEL :
				setAccessLevel(ACCESSLEVEL_EDEFAULT);
				return;
			case MiniJavaPackage.TYPE_DECLARATION__IMPLEMENTZ :
				getImplementz().clear();
				return;
			case MiniJavaPackage.TYPE_DECLARATION__MEMBERS :
				getMembers().clear();
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	@TruffleBoundary
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MiniJavaPackage.TYPE_DECLARATION__ACCESS_LEVEL :
				return accessLevel != ACCESSLEVEL_EDEFAULT;
			case MiniJavaPackage.TYPE_DECLARATION__IMPLEMENTZ :
				return implementz != null && !implementz.isEmpty();
			case MiniJavaPackage.TYPE_DECLARATION__MEMBERS :
				return members != null && !members.isEmpty();
		}
		return super.eIsSet(featureID);
	}
}
