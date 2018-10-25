package boa_dynamic.interpreter.boa_dynamic.impl;

import boa_dynamic.interpreter.boa_dynamic.Boa_dynamicFactory;
import boa_dynamic.interpreter.boa_dynamic.Boa_dynamicPackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

public class Boa_dynamicPackageImpl extends EPackageImpl implements Boa_dynamicPackage {
  private static boolean isInited = false;

  private boolean isCreated = false;

  private boolean isInitialized = false;

  private EClass ctxEClass = null;

  private EClass stringToEvalResMapEClass = null;

  private EClass evalResEClass = null;

  private EClass evalMapResEClass = null;

  private EClass evalFunResEClass = null;

  private EClass evalBoundFunResEClass = null;

  private EClass evalIntResEClass = null;

  private EClass evalBoolResEClass = null;

  private Boa_dynamicPackageImpl() {
    super(eNS_URI, Boa_dynamicFactory.eINSTANCE);
  }

  public static Boa_dynamicPackage init() {
    if (isInited)
    	return (Boa_dynamicPackage) EPackage.Registry.INSTANCE.getEPackage(Boa_dynamicPackage.eNS_URI);

    // Obtain or create and register package
    Object registeredBoa_dynamicPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
    boa_dynamic.interpreter.boa_dynamic.impl.Boa_dynamicPackageImpl theBoa_dynamicPackage;
    if(registeredBoa_dynamicPackage instanceof boa_dynamic.interpreter.boa_dynamic.impl.Boa_dynamicPackageImpl) {
    	 theBoa_dynamicPackage =  (boa_dynamic.interpreter.boa_dynamic.impl.Boa_dynamicPackageImpl) registeredBoa_dynamicPackage;
    } else {
     	theBoa_dynamicPackage = new boa_dynamic.interpreter.boa_dynamic.impl.Boa_dynamicPackageImpl();
    }
    isInited = true;
    				
    // Create package meta-data objects
    theBoa_dynamicPackage.createPackageContents();

    // Initialize created meta-data
    theBoa_dynamicPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theBoa_dynamicPackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(Boa_dynamicPackage.eNS_URI, theBoa_dynamicPackage);
    return theBoa_dynamicPackage;
  }

  public void createPackageContents() {
    if(isCreated)
    	return;
    isCreated = true;

    ctxEClass = createEClass(CTX);
    createEReference(ctxEClass, CTX__ENV);
    createEReference(ctxEClass, CTX__TH);
    stringToEvalResMapEClass = createEClass(STRING_TO_EVAL_RES_MAP);
    createEAttribute(stringToEvalResMapEClass, STRING_TO_EVAL_RES_MAP__KEY);						
    createEReference(stringToEvalResMapEClass, STRING_TO_EVAL_RES_MAP__VALUE);
    evalResEClass = createEClass(EVAL_RES);
    evalMapResEClass = createEClass(EVAL_MAP_RES);
    createEReference(evalMapResEClass, EVAL_MAP_RES__VALUES);
    evalFunResEClass = createEClass(EVAL_FUN_RES);
    createEReference(evalFunResEClass, EVAL_FUN_RES__EXP);
    createEReference(evalFunResEClass, EVAL_FUN_RES__CTX);
    createEAttribute(evalFunResEClass, EVAL_FUN_RES__NAME);						
    evalBoundFunResEClass = createEClass(EVAL_BOUND_FUN_RES);
    createEReference(evalBoundFunResEClass, EVAL_BOUND_FUN_RES__TH);
    evalIntResEClass = createEClass(EVAL_INT_RES);
    createEAttribute(evalIntResEClass, EVAL_INT_RES__VALUE);						
    evalBoolResEClass = createEClass(EVAL_BOOL_RES);
    createEAttribute(evalBoolResEClass, EVAL_BOOL_RES__VALUE);						
  }

  public void initializePackageContents() {
    if (isInitialized)
    	return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    evalMapResEClass.getESuperTypes().add(this.getEvalRes());
    evalFunResEClass.getESuperTypes().add(this.getEvalRes());
    evalBoundFunResEClass.getESuperTypes().add(this.getEvalFunRes());
    evalIntResEClass.getESuperTypes().add(this.getEvalRes());
    evalBoolResEClass.getESuperTypes().add(this.getEvalRes());

    // Initialize classes, features, and operations; add parameters
    initEClass(ctxEClass, boa_dynamic.interpreter.boa_dynamic.Ctx.class, "Ctx", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCtx_Env(), this.getStringToEvalResMap(),  
    	null, "env", null, 0, -1,  boa_dynamic.interpreter.boa_dynamic.Ctx.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCtx_Th(), this.getStringToEvalResMap(),  
    	null, "th", null, 0, -1,  boa_dynamic.interpreter.boa_dynamic.Ctx.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEClass(stringToEvalResMapEClass, boa_dynamic.interpreter.boa_dynamic.StringToEvalResMap.class, "StringToEvalResMap", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getString_to_eval_res_map_Key(), ecorePackage.getEString(), "key", null, 0, 1,  boa_dynamic.interpreter.boa_dynamic.StringToEvalResMap.class, !IS_TRANSIENT,!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);				
    initEReference(getString_to_eval_res_map_Value(), this.getEvalRes(),  
    	null, "value", null, 1, 1,  boa_dynamic.interpreter.boa_dynamic.StringToEvalResMap.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEClass(evalResEClass, boa_dynamic.interpreter.boa_dynamic.EvalRes.class, "EvalRes", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEClass(evalMapResEClass, boa_dynamic.interpreter.boa_dynamic.EvalMapRes.class, "EvalMapRes", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEval_map_res_Values(), this.getStringToEvalResMap(),  
    	null, "values", null, 0, -1,  boa_dynamic.interpreter.boa_dynamic.EvalMapRes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEClass(evalFunResEClass, boa_dynamic.interpreter.boa_dynamic.EvalFunRes.class, "EvalFunRes", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEval_fun_res_Exp(), 
    ((boa.interpreter.boa.BoaPackage)org.eclipse.emf.ecore.EPackage.Registry.INSTANCE.getEPackage(boa.interpreter.boa.BoaPackage.eNS_URI)).getExpr(), 
    	null, "exp", null, 1, 1,  boa_dynamic.interpreter.boa_dynamic.EvalFunRes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEval_fun_res_Ctx(), this.getCtx(),  
    	null, "ctx", null, 1, 1,  boa_dynamic.interpreter.boa_dynamic.EvalFunRes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getEval_fun_res_Name(), ecorePackage.getEString(), "name", null, 0, 1,  boa_dynamic.interpreter.boa_dynamic.EvalFunRes.class, !IS_TRANSIENT,!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);				
    initEClass(evalBoundFunResEClass, boa_dynamic.interpreter.boa_dynamic.EvalBoundFunRes.class, "EvalBoundFunRes", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEval_bound_fun_res_Th(), this.getStringToEvalResMap(),  
    	null, "th", null, 0, -1,  boa_dynamic.interpreter.boa_dynamic.EvalBoundFunRes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEClass(evalIntResEClass, boa_dynamic.interpreter.boa_dynamic.EvalIntRes.class, "EvalIntRes", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getEval_int_res_Value(), ecorePackage.getEInt(), "value", null, 0, 1,  boa_dynamic.interpreter.boa_dynamic.EvalIntRes.class, !IS_TRANSIENT,!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);				
    initEClass(evalBoolResEClass, boa_dynamic.interpreter.boa_dynamic.EvalBoolRes.class, "EvalBoolRes", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getEval_bool_res_Value(), ecorePackage.getEBoolean(), "value", null, 0, 1,  boa_dynamic.interpreter.boa_dynamic.EvalBoolRes.class, !IS_TRANSIENT,!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);				
    // Create resource
    createResource(eNS_URI);
  }

  public Boa_dynamicFactory getBoa_dynamicFactory() {
    return (Boa_dynamicFactory) getEFactoryInstance();
  }

  public EClass getCtx() {
    return ctxEClass;
  }

  public EClass getStringToEvalResMap() {
    return stringToEvalResMapEClass;
  }

  public EClass getEvalRes() {
    return evalResEClass;
  }

  public EClass getEvalMapRes() {
    return evalMapResEClass;
  }

  public EClass getEvalFunRes() {
    return evalFunResEClass;
  }

  public EClass getEvalBoundFunRes() {
    return evalBoundFunResEClass;
  }

  public EClass getEvalIntRes() {
    return evalIntResEClass;
  }

  public EClass getEvalBoolRes() {
    return evalBoolResEClass;
  }

  public EReference getCtx_Env() {
    return (EReference) ctxEClass.getEStructuralFeatures().get(0);
  }

  public EReference getCtx_Th() {
    return (EReference) ctxEClass.getEStructuralFeatures().get(1);
  }

  public EAttribute getString_to_eval_res_map_Key() {
    return (EAttribute) stringToEvalResMapEClass.getEStructuralFeatures().get(0);
  }

  public EReference getString_to_eval_res_map_Value() {
    return (EReference) stringToEvalResMapEClass.getEStructuralFeatures().get(1);
  }

  public EReference getEval_map_res_Values() {
    return (EReference) evalMapResEClass.getEStructuralFeatures().get(0);
  }

  public EReference getEval_fun_res_Exp() {
    return (EReference) evalFunResEClass.getEStructuralFeatures().get(0);
  }

  public EReference getEval_fun_res_Ctx() {
    return (EReference) evalFunResEClass.getEStructuralFeatures().get(1);
  }

  public EAttribute getEval_fun_res_Name() {
    return (EAttribute) evalFunResEClass.getEStructuralFeatures().get(2);
  }

  public EReference getEval_bound_fun_res_Th() {
    return (EReference) evalBoundFunResEClass.getEStructuralFeatures().get(0);
  }

  public EAttribute getEval_int_res_Value() {
    return (EAttribute) evalIntResEClass.getEStructuralFeatures().get(0);
  }

  public EAttribute getEval_bool_res_Value() {
    return (EAttribute) evalBoolResEClass.getEStructuralFeatures().get(0);
  }
}
