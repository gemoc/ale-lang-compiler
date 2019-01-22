package miniJava.interpreter.miniJava.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;

import miniJava.interpreter.miniJava.Import;
import miniJava.interpreter.miniJava.MiniJavaPackage;

@NodeInfo(
    description = "Import"
)
public class ImportImpl extends MinimalEObjectImpl.Container implements Import {
  protected static final String IMPORTEDNAMESPACE_EDEFAULT = null;

  protected String importedNamespace = IMPORTEDNAMESPACE_EDEFAULT;

  protected ImportImpl() {
    super();
  }

  public String getImportedNamespace() {
    return importedNamespace;}

  public void setImportedNamespace(String importedNamespace) {
    this.importedNamespace = importedNamespace;}

  @TruffleBoundary
  protected EClass eStaticClass() {
    return MiniJavaPackage.Literals.IMPORT;}

  @TruffleBoundary
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case MiniJavaPackage.IMPORT__IMPORTED_NAMESPACE:
    	setImportedNamespace((java.lang.String) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  @TruffleBoundary
  public void eUnset(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.IMPORT__IMPORTED_NAMESPACE:
    	setImportedNamespace(IMPORTEDNAMESPACE_EDEFAULT);
    return;
    }
    super.eUnset(featureID);
  }

  @TruffleBoundary
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case MiniJavaPackage.IMPORT__IMPORTED_NAMESPACE:
    return getImportedNamespace();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  @TruffleBoundary
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.IMPORT__IMPORTED_NAMESPACE:
    	return importedNamespace != IMPORTEDNAMESPACE_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  @TruffleBoundary
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }
}
