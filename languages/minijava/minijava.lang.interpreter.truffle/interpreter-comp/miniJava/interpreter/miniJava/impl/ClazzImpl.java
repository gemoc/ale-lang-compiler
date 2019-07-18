package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Boolean;
import java.lang.Object;
import java.lang.Override;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

@NodeInfo(
		description = "Clazz"
)
public class ClazzImpl extends TypeDeclarationImpl {
	protected static final boolean ISABSTRACT_EDEFAULT = false;

	protected boolean isabstract = ISABSTRACT_EDEFAULT;

	protected ClazzImpl superClass;

	protected ClazzImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.CLAZZ;
	}

	@TruffleBoundary
	public boolean isIsabstract() {
		return isabstract;
	}

	@TruffleBoundary
	public void setIsabstract(boolean newIsabstract) {
		boolean oldIsabstract = isabstract;
		isabstract = newIsabstract;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.CLAZZ__ISABSTRACT, oldIsabstract, isabstract));
	}

	@TruffleBoundary
	public ClazzImpl getSuperClass() {
		if (superClass != null && superClass.eIsProxy()) {
			InternalEObject oldSuperClass = (InternalEObject) superClass;
			superClass = (ClazzImpl) eResolveProxy(oldSuperClass);
			if (superClass != oldSuperClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MiniJavaPackage.CLAZZ__SUPER_CLASS, oldSuperClass, superClass));
			}
		}
		return superClass;
	}

	public ClazzImpl basicGetSuperClass() {
		return superClass;
	}

	@TruffleBoundary
	public void setSuperClass(ClazzImpl newSuperClass) {
		ClazzImpl oldSuperClass = superClass;
		superClass = newSuperClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.CLAZZ__SUPER_CLASS, oldSuperClass, superClass));
	}

	@Override
	@TruffleBoundary
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MiniJavaPackage.CLAZZ__ISABSTRACT :
				return isIsabstract();
			case MiniJavaPackage.CLAZZ__SUPER_CLASS :
				if (resolve)
					return getSuperClass();
				return basicGetSuperClass();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	@TruffleBoundary
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MiniJavaPackage.CLAZZ__ISABSTRACT :
				setIsabstract((Boolean) newValue);
				return;
			case MiniJavaPackage.CLAZZ__SUPER_CLASS :
				setSuperClass((ClazzImpl) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	@TruffleBoundary
	public void eUnset(int featureID) {
		switch (featureID) {
			case MiniJavaPackage.CLAZZ__ISABSTRACT :
				setIsabstract(ISABSTRACT_EDEFAULT);
				return;
			case MiniJavaPackage.CLAZZ__SUPER_CLASS :
				setSuperClass((ClazzImpl) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	@TruffleBoundary
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MiniJavaPackage.CLAZZ__ISABSTRACT :
				return isabstract != ISABSTRACT_EDEFAULT;
			case MiniJavaPackage.CLAZZ__SUPER_CLASS :
				return superClass != null;
		}
		return super.eIsSet(featureID);
	}
}
