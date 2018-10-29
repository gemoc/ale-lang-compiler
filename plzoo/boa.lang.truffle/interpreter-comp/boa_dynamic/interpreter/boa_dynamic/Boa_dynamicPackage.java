package boa_dynamic.interpreter.boa_dynamic;

import boa_dynamic.interpreter.boa_dynamic.impl.Boa_dynamicPackageImpl;
import java.lang.String;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

public interface Boa_dynamicPackage extends EPackage {
  Boa_dynamicPackage eINSTANCE = Boa_dynamicPackageImpl.init();

  String eNS_URI = "http://boa_dynamic.boa_dynamic.boa_dynamic/";

  String eNAME = "boa_dynamic";

  String eNS_PREFIX = "boa_dynamic";

  int CTX = 0;

  int STRING_TO_EVAL_RES_MAP = 1;

  int EVAL_RES = 2;

  int EVAL_MAP_RES = 3;

  int EVAL_FUN_RES = 4;

  int EVAL_BOUND_FUN_RES = 5;

  int EVAL_INT_RES = 6;

  int EVAL_BOOL_RES = 7;

  int CTX__ENV = 0;

  int CTX__TH = 1;

  int STRING_TO_EVAL_RES_MAP__KEY = 0;

  int STRING_TO_EVAL_RES_MAP__VALUE = 1;

  int EVAL_MAP_RES__VALUES = 0;

  int EVAL_FUN_RES__EXP = 0;

  int EVAL_FUN_RES__CTX = 1;

  int EVAL_FUN_RES__NAME = 2;

  int EVAL_BOUND_FUN_RES__TH = 3;

  int EVAL_INT_RES__VALUE = 0;

  int EVAL_BOOL_RES__VALUE = 0;

  EClass getCtx();

  EClass getStringToEvalResMap();

  EClass getEvalRes();

  EClass getEvalMapRes();

  EClass getEvalFunRes();

  EClass getEvalBoundFunRes();

  EClass getEvalIntRes();

  EClass getEvalBoolRes();

  EReference getCtx_Env();

  EReference getCtx_Th();

  EReference getString_to_eval_res_map_Value();

  EReference getEval_map_res_Values();

  EReference getEval_fun_res_Exp();

  EReference getEval_fun_res_Ctx();

  EReference getEval_bound_fun_res_Th();

  EAttribute getString_to_eval_res_map_Key();

  EAttribute getEval_fun_res_Name();

  EAttribute getEval_int_res_Value();

  EAttribute getEval_bool_res_Value();

  Boa_dynamicFactory getBoa_dynamicFactory();

  interface Literals {
    EClass CTX = eINSTANCE.getCtx();

    EClass STRING_TO_EVAL_RES_MAP = eINSTANCE.getStringToEvalResMap();

    EClass EVAL_RES = eINSTANCE.getEvalRes();

    EClass EVAL_MAP_RES = eINSTANCE.getEvalMapRes();

    EClass EVAL_FUN_RES = eINSTANCE.getEvalFunRes();

    EClass EVAL_BOUND_FUN_RES = eINSTANCE.getEvalBoundFunRes();

    EClass EVAL_INT_RES = eINSTANCE.getEvalIntRes();

    EClass EVAL_BOOL_RES = eINSTANCE.getEvalBoolRes();

    EReference CTX__ENV = eINSTANCE.getCtx_Env();

    EReference CTX__TH = eINSTANCE.getCtx_Th();

    EReference STRING_TO_EVAL_RES_MAP__VALUE = eINSTANCE.getString_to_eval_res_map_Value();

    EReference EVAL_MAP_RES__VALUES = eINSTANCE.getEval_map_res_Values();

    EReference EVAL_FUN_RES__EXP = eINSTANCE.getEval_fun_res_Exp();

    EReference EVAL_FUN_RES__CTX = eINSTANCE.getEval_fun_res_Ctx();

    EReference EVAL_BOUND_FUN_RES__TH = eINSTANCE.getEval_bound_fun_res_Th();

    EAttribute STRING_TO_EVAL_RES_MAP__KEY = eINSTANCE.getString_to_eval_res_map_Key();

    EAttribute EVAL_FUN_RES__NAME = eINSTANCE.getEval_fun_res_Name();

    EAttribute EVAL_INT_RES__VALUE = eINSTANCE.getEval_int_res_Value();

    EAttribute EVAL_BOOL_RES__VALUE = eINSTANCE.getEval_bool_res_Value();
  }
}
