package interpreter.boa.interpreter.boa.impl;

import interpreter.boa.interpreter.boa.BoaPackage;
import interpreter.boa.interpreter.boa.EvalRes;
import java.lang.Object;
import java.lang.String;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

public class StringToEvalResMapImpl extends MinimalEObjectImpl.Container implements BasicEMap.Entry<String, EvalRes> {
  protected static final String KEY_EDEFAULT = null;

  protected String key = KEY_EDEFAULT;

  protected EvalRes value;

  protected int hash = -1;

  protected StringToEvalResMapImpl() {
    super();
  }

  public String getKey() {
    return key;}

  public void setKey(String key) {
    this.key = key;}

  public EvalRes setValue(EvalRes newValue) {
    EvalRes oldValue = this.value;
    this.value = newValue;
    return oldValue;
  }

  public EvalRes getValue() {
    return value;}

  protected EClass eStaticClass() {
    return BoaPackage.Literals.STRING_TO_EVAL_RES_MAP;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case BoaPackage.STRING_TO_EVAL_RES_MAP__KEY:
    	setKey((java.lang.String) newValue);
    return;
    case BoaPackage.STRING_TO_EVAL_RES_MAP__VALUE:
    	setValue((interpreter.boa.interpreter.boa.EvalRes) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case BoaPackage.STRING_TO_EVAL_RES_MAP__KEY:
    	setKey(KEY_EDEFAULT);
    return;
    case BoaPackage.STRING_TO_EVAL_RES_MAP__VALUE:
    	setValue((interpreter.boa.interpreter.boa.EvalRes) null);
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case BoaPackage.STRING_TO_EVAL_RES_MAP__KEY:
    return getKey();
    case BoaPackage.STRING_TO_EVAL_RES_MAP__VALUE:
    return getValue();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case BoaPackage.STRING_TO_EVAL_RES_MAP__KEY:
    	return key != KEY_EDEFAULT;
    case BoaPackage.STRING_TO_EVAL_RES_MAP__VALUE:
    	return value != null;
    }
    return super.eIsSet(featureID);
  }

  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  public void setHash(int hash) {
    this.hash = hash;
  }

  public int getHash() {
    if (hash == -1) {
    	Object theKey = getKey();
    	hash = (theKey == null ? 0 : theKey.hashCode());
    }
    return hash;
  }
}
