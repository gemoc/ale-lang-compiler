package boa_dynamic.interpreter.boa_dynamic.impl;

import boa_dynamic.interpreter.boa_dynamic.Boa_dynamicFactory;
import boa_dynamic.interpreter.boa_dynamic.Boa_dynamicPackage;
import boa_dynamic.interpreter.boa_dynamic.Ctx;
import boa_dynamic.interpreter.boa_dynamic.EvalBoolRes;
import boa_dynamic.interpreter.boa_dynamic.EvalBoundFunRes;
import boa_dynamic.interpreter.boa_dynamic.EvalFunRes;
import boa_dynamic.interpreter.boa_dynamic.EvalIntRes;
import boa_dynamic.interpreter.boa_dynamic.EvalMapRes;
import boa_dynamic.interpreter.boa_dynamic.EvalRes;
import java.lang.IllegalArgumentException;
import java.lang.String;
import java.util.Map;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

public class Boa_dynamicFactoryImpl extends EFactoryImpl implements Boa_dynamicFactory {
  public Boa_dynamicFactoryImpl() {
  }

  public static Boa_dynamicFactory init() {
    try {
    	Boa_dynamicFactory theBoa_dynamicFactory = (Boa_dynamicFactory) EPackage.Registry.INSTANCE.getEFactory(Boa_dynamicPackage.eNS_URI);
    	if (theBoa_dynamicFactory != null) {
    		return theBoa_dynamicFactory;
    	}
    } catch (Exception exception) {
    	EcorePlugin.INSTANCE.log(exception);
    }
    return new Boa_dynamicFactoryImpl();
  }

  public EObject create(EClass eClass) {
    switch (eClass.getClassifierID()) {
    case Boa_dynamicPackage.CTX:
    	return createCtx();
    case Boa_dynamicPackage.STRING_TO_EVAL_RES_MAP:
    	return (org.eclipse.emf.ecore.EObject) createStringToEvalResMap();
    case Boa_dynamicPackage.EVAL_MAP_RES:
    	return createEvalMapRes();
    case Boa_dynamicPackage.EVAL_FUN_RES:
    	return createEvalFunRes();
    case Boa_dynamicPackage.EVAL_BOUND_FUN_RES:
    	return createEvalBoundFunRes();
    case Boa_dynamicPackage.EVAL_INT_RES:
    	return createEvalIntRes();
    case Boa_dynamicPackage.EVAL_BOOL_RES:
    	return createEvalBoolRes();
    default:
    	throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  public Boa_dynamicPackage getBoa_dynamicPackage() {
    return (Boa_dynamicPackage)getEPackage();}

  public Ctx createCtx() {
    CtxImpl ret = new CtxImpl();
    return ret;
  }

  public Map.Entry<String, EvalRes> createStringToEvalResMap() {
    StringToEvalResMapImpl ret = new StringToEvalResMapImpl();
    return ret;
  }

  public EvalMapRes createEvalMapRes() {
    EvalMapResImpl ret = new EvalMapResImpl();
    return ret;
  }

  public EvalFunRes createEvalFunRes() {
    EvalFunResImpl ret = new EvalFunResImpl();
    return ret;
  }

  public EvalBoundFunRes createEvalBoundFunRes() {
    EvalBoundFunResImpl ret = new EvalBoundFunResImpl();
    return ret;
  }

  public EvalIntRes createEvalIntRes() {
    EvalIntResImpl ret = new EvalIntResImpl();
    return ret;
  }

  public EvalBoolRes createEvalBoolRes() {
    EvalBoolResImpl ret = new EvalBoolResImpl();
    return ret;
  }
}
