package boa.interpreter.boa.impl;

import boa.interpreter.boa.BoaPackage;
import boa.interpreter.boa.Ctx;
import boa.interpreter.boa.EvalRes;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import java.lang.Object;
import java.lang.String;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EcoreEMap;

public class CtxImpl extends MinimalEObjectImpl.Container implements Ctx {
  protected EMap<String, EvalRes> env;

  protected EMap<String, EvalRes> th;

  protected CtxImpl() {
    super();
  }

  @TruffleBoundary
  public EMap<String, EvalRes> getEnv() {
    if (env == null) {
    	env = new EcoreEMap<String, EvalRes>(BoaPackage.Literals.STRING_TO_EVAL_RES_MAP, StringToEvalResMapImpl.class, this, BoaPackage.CTX__ENV);
    }
    return env;
  }

  @TruffleBoundary
  public EMap<String, EvalRes> getTh() {
    if (th == null) {
    	th = new EcoreEMap<String, EvalRes>(BoaPackage.Literals.STRING_TO_EVAL_RES_MAP, StringToEvalResMapImpl.class, this, BoaPackage.CTX__TH);
    }
    return th;
  }

  @TruffleBoundary
  protected EClass eStaticClass() {
    return BoaPackage.Literals.CTX;}

  @TruffleBoundary
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case BoaPackage.CTX__ENV:
    	((org.eclipse.emf.ecore.EStructuralFeature.Setting)getEnv()).set(newValue);
    return;
    case BoaPackage.CTX__TH:
    	((org.eclipse.emf.ecore.EStructuralFeature.Setting)getTh()).set(newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  @TruffleBoundary
  public void eUnset(int featureID) {
    switch (featureID) {
    case BoaPackage.CTX__ENV:
    	getEnv().clear();
    return;
    case BoaPackage.CTX__TH:
    	getTh().clear();
    return;
    }
    super.eUnset(featureID);
  }

  @TruffleBoundary
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case BoaPackage.CTX__ENV:
    if (coreType)
    	return getEnv();
    else
    	return getEnv().map();
    case BoaPackage.CTX__TH:
    if (coreType)
    	return getTh();
    else
    	return getTh().map();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  @TruffleBoundary
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case BoaPackage.CTX__ENV:
    	return env != null && !env.isEmpty();
    case BoaPackage.CTX__TH:
    	return th != null && !th.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  @TruffleBoundary
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case boa.interpreter.boa.BoaPackage.CTX__ENV:
    	return ((org.eclipse.emf.ecore.util.InternalEList<?>) getEnv()).basicRemove(otherEnd, msgs);
    case boa.interpreter.boa.BoaPackage.CTX__TH:
    	return ((org.eclipse.emf.ecore.util.InternalEList<?>) getTh()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }
}
