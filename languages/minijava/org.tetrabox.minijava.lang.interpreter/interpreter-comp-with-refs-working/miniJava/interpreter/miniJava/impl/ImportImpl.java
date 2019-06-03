package miniJava.interpreter.miniJava.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import miniJava.interpreter.miniJava.Import;
import miniJava.interpreter.miniJava.MiniJavaPackage;

public class ImportImpl extends MinimalEObjectImpl.Container implements Import {
	protected static final String IMPORTEDNAMESPACE_EDEFAULT = null;

	protected String importedNamespace = IMPORTEDNAMESPACE_EDEFAULT;

	protected ImportImpl() {
		super();
	}

	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case MiniJavaPackage.IMPORT__IMPORTED_NAMESPACE:
			return getImportedNamespace();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case MiniJavaPackage.IMPORT__IMPORTED_NAMESPACE:
			return importedNamespace != IMPORTEDNAMESPACE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case MiniJavaPackage.IMPORT__IMPORTED_NAMESPACE:
			setImportedNamespace((java.lang.String) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.IMPORT;
	}

	public void eUnset(int featureID) {
		switch (featureID) {
		case MiniJavaPackage.IMPORT__IMPORTED_NAMESPACE:
			setImportedNamespace(IMPORTEDNAMESPACE_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	public String getImportedNamespace() {
		return importedNamespace;
	}

	public void setImportedNamespace(String importedNamespace) {
		this.importedNamespace = importedNamespace;
	}
}
