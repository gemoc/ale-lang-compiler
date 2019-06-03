package boa.visitor.boa;

import boa.visitor.boa.impl.BoaPackageImpl;
import java.lang.String;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

public interface BoaPackage extends EPackage {
	String eNAME = "boa";

	String eNS_URI = "http://boa.boa.boa/";

	String eNS_PREFIX = "boa";

	BoaPackage eINSTANCE = BoaPackageImpl.init();

	int FILE = 0;

	int FILE__COMMANDS = 0;

	int FILE_FEATURE_COUNT = 1;

	int FILE_OPERATION_COUNT = 0;

	int TOP_LEVEL_CMD = 1;

	int TOP_LEVEL_CMD_FEATURE_COUNT = 0;

	int TOP_LEVEL_CMD_OPERATION_COUNT = 0;

	int EXPR = 2;

	int EXPR_FEATURE_COUNT = TOP_LEVEL_CMD_FEATURE_COUNT + 0;

	int EXPR_OPERATION_COUNT = TOP_LEVEL_CMD_OPERATION_COUNT + 0;

	int DEF = 3;

	int DEF__NAME = 0;

	int DEF__EXPR = 1;

	int DEF_FEATURE_COUNT = TOP_LEVEL_CMD_FEATURE_COUNT + 2;

	int DEF_OPERATION_COUNT = TOP_LEVEL_CMD_OPERATION_COUNT + 0;

	int APP = 4;

	int APP__LHS = 0;

	int APP__RHS = 1;

	int APP_FEATURE_COUNT = EXPR_FEATURE_COUNT + 2;

	int APP_OPERATION_COUNT = EXPR_OPERATION_COUNT + 0;

	int VAR = 5;

	int VAR__NAME = 0;

	int VAR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 1;

	int VAR_OPERATION_COUNT = EXPR_OPERATION_COUNT + 0;

	int THIS = 6;

	int THIS_FEATURE_COUNT = EXPR_FEATURE_COUNT + 0;

	int THIS_OPERATION_COUNT = EXPR_OPERATION_COUNT + 0;

	int BOOL = 7;

	int BOOL__VALUE = 0;

	int BOOL_FEATURE_COUNT = EXPR_FEATURE_COUNT + 1;

	int BOOL_OPERATION_COUNT = EXPR_OPERATION_COUNT + 0;

	int INT = 8;

	int INT__VALUE = 0;

	int INT_FEATURE_COUNT = EXPR_FEATURE_COUNT + 1;

	int INT_OPERATION_COUNT = EXPR_OPERATION_COUNT + 0;

	int SKIP = 9;

	int SKIP_FEATURE_COUNT = EXPR_FEATURE_COUNT + 0;

	int SKIP_OPERATION_COUNT = EXPR_OPERATION_COUNT + 0;

	int PROJECT = 10;

	int PROJECT__EXP = 0;

	int PROJECT__NAME = 1;

	int PROJECT_FEATURE_COUNT = EXPR_FEATURE_COUNT + 2;

	int PROJECT_OPERATION_COUNT = EXPR_OPERATION_COUNT + 0;

	int BOBJECT = 11;

	int BOBJECT__FIELDS = 0;

	int BOBJECT_FEATURE_COUNT = EXPR_FEATURE_COUNT + 1;

	int BOBJECT_OPERATION_COUNT = EXPR_OPERATION_COUNT + 0;

	int FIELD = 12;

	int FIELD__NAME = 0;

	int FIELD__VALUE = 1;

	int FIELD_FEATURE_COUNT = 2;

	int FIELD_OPERATION_COUNT = 0;

	int COPY = 13;

	int COPY__COPY = 0;

	int COPY_FEATURE_COUNT = EXPR_FEATURE_COUNT + 1;

	int COPY_OPERATION_COUNT = EXPR_OPERATION_COUNT + 0;

	int WITH = 14;

	int WITH__LHS = 0;

	int WITH__RHS = 1;

	int WITH_FEATURE_COUNT = EXPR_FEATURE_COUNT + 2;

	int WITH_OPERATION_COUNT = EXPR_OPERATION_COUNT + 0;

	int ARITH_OP = 15;

	int ARITH_OP__LHS = 0;

	int ARITH_OP__RHS = 1;

	int ARITH_OP_FEATURE_COUNT = EXPR_FEATURE_COUNT + 2;

	int ARITH_OP_OPERATION_COUNT = EXPR_OPERATION_COUNT + 0;

	int NOT = 16;

	int NOT__VALUE = 0;

	int NOT_FEATURE_COUNT = EXPR_FEATURE_COUNT + 1;

	int NOT_OPERATION_COUNT = EXPR_OPERATION_COUNT + 0;

	int CMP_OP = 17;

	int CMP_OP__LHS = 0;

	int CMP_OP__RHS = 1;

	int CMP_OP_FEATURE_COUNT = EXPR_FEATURE_COUNT + 2;

	int CMP_OP_OPERATION_COUNT = EXPR_OPERATION_COUNT + 0;

	int BOOL_OP = 18;

	int BOOL_OP_FEATURE_COUNT = EXPR_FEATURE_COUNT + 0;

	int BOOL_OP_OPERATION_COUNT = EXPR_OPERATION_COUNT + 0;

	int IF = 19;

	int IF__COND = 0;

	int IF__THN = 1;

	int IF__ELS = 2;

	int IF_FEATURE_COUNT = EXPR_FEATURE_COUNT + 3;

	int IF_OPERATION_COUNT = EXPR_OPERATION_COUNT + 0;

	int LET = 20;

	int LET__NAME = 0;

	int LET__LHS = 1;

	int LET__RHS = 2;

	int LET_FEATURE_COUNT = EXPR_FEATURE_COUNT + 3;

	int LET_OPERATION_COUNT = EXPR_OPERATION_COUNT + 0;

	int FUN = 21;

	int FUN__NAME = 0;

	int FUN__BODY = 1;

	int FUN_FEATURE_COUNT = EXPR_FEATURE_COUNT + 2;

	int FUN_OPERATION_COUNT = EXPR_OPERATION_COUNT + 0;

	int ASSIGN = 22;

	int ASSIGN__LHS = 0;

	int ASSIGN__RHS = 1;

	int ASSIGN__NAME = 2;

	int ASSIGN_FEATURE_COUNT = EXPR_FEATURE_COUNT + 3;

	int ASSIGN_OPERATION_COUNT = EXPR_OPERATION_COUNT + 0;

	int ARITH_OP_PLUS = 23;

	int ARITH_OP_PLUS__LHS = ARITH_OP__LHS;

	int ARITH_OP_PLUS__RHS = ARITH_OP__RHS;

	int ARITH_OP_PLUS_FEATURE_COUNT = ARITH_OP_FEATURE_COUNT + 0;

	int ARITH_OP_PLUS_OPERATION_COUNT = ARITH_OP_OPERATION_COUNT + 0;

	int ARITH_OP_MINUS = 24;

	int ARITH_OP_MINUS__LHS = ARITH_OP__LHS;

	int ARITH_OP_MINUS__RHS = ARITH_OP__RHS;

	int ARITH_OP_MINUS_FEATURE_COUNT = ARITH_OP_FEATURE_COUNT + 0;

	int ARITH_OP_MINUS_OPERATION_COUNT = ARITH_OP_OPERATION_COUNT + 0;

	int ARITH_OP_TIMES = 25;

	int ARITH_OP_TIMES__LHS = ARITH_OP__LHS;

	int ARITH_OP_TIMES__RHS = ARITH_OP__RHS;

	int ARITH_OP_TIMES_FEATURE_COUNT = ARITH_OP_FEATURE_COUNT + 0;

	int ARITH_OP_TIMES_OPERATION_COUNT = ARITH_OP_OPERATION_COUNT + 0;

	int ARITH_OP_DIVIDE = 26;

	int ARITH_OP_DIVIDE__LHS = ARITH_OP__LHS;

	int ARITH_OP_DIVIDE__RHS = ARITH_OP__RHS;

	int ARITH_OP_DIVIDE_FEATURE_COUNT = ARITH_OP_FEATURE_COUNT + 0;

	int ARITH_OP_DIVIDE_OPERATION_COUNT = ARITH_OP_OPERATION_COUNT + 0;

	int ARITH_OP_REMAINDER = 27;

	int ARITH_OP_REMAINDER__LHS = ARITH_OP__LHS;

	int ARITH_OP_REMAINDER__RHS = ARITH_OP__RHS;

	int ARITH_OP_REMAINDER_FEATURE_COUNT = ARITH_OP_FEATURE_COUNT + 0;

	int ARITH_OP_REMAINDER_OPERATION_COUNT = ARITH_OP_OPERATION_COUNT + 0;

	int BOOL_OP_AND = 28;

	int BOOL_OP_AND__LHS = 0;

	int BOOL_OP_AND__RHS = 1;

	int BOOL_OP_AND_FEATURE_COUNT = BOOL_OP_FEATURE_COUNT + 2;

	int BOOL_OP_AND_OPERATION_COUNT = BOOL_OP_OPERATION_COUNT + 0;

	int BOOL_OP_OR = 29;

	int BOOL_OP_OR__LHS = 0;

	int BOOL_OP_OR__RHS = 1;

	int BOOL_OP_OR_FEATURE_COUNT = BOOL_OP_FEATURE_COUNT + 2;

	int BOOL_OP_OR_OPERATION_COUNT = BOOL_OP_OPERATION_COUNT + 0;

	int SEQ = 30;

	int SEQ__LHS = 0;

	int SEQ__RHS = 1;

	int SEQ_FEATURE_COUNT = EXPR_FEATURE_COUNT + 2;

	int SEQ_OPERATION_COUNT = EXPR_OPERATION_COUNT + 0;

	int CMP_OP_EQUAL = 31;

	int CMP_OP_EQUAL__LHS = CMP_OP__LHS;

	int CMP_OP_EQUAL__RHS = CMP_OP__RHS;

	int CMP_OP_EQUAL_FEATURE_COUNT = CMP_OP_FEATURE_COUNT + 0;

	int CMP_OP_EQUAL_OPERATION_COUNT = CMP_OP_OPERATION_COUNT + 0;

	int CMP_OP_UNEQUAL = 32;

	int CMP_OP_UNEQUAL__LHS = CMP_OP__LHS;

	int CMP_OP_UNEQUAL__RHS = CMP_OP__RHS;

	int CMP_OP_UNEQUAL_FEATURE_COUNT = CMP_OP_FEATURE_COUNT + 0;

	int CMP_OP_UNEQUAL_OPERATION_COUNT = CMP_OP_OPERATION_COUNT + 0;

	int CMP_OP_LESS = 33;

	int CMP_OP_LESS__LHS = CMP_OP__LHS;

	int CMP_OP_LESS__RHS = CMP_OP__RHS;

	int CMP_OP_LESS_FEATURE_COUNT = CMP_OP_FEATURE_COUNT + 0;

	int CMP_OP_LESS_OPERATION_COUNT = CMP_OP_OPERATION_COUNT + 0;

	int CTX = 34;

	int CTX__ENV = 0;

	int CTX__TH = 1;

	int CTX_FEATURE_COUNT = 2;

	int CTX_OPERATION_COUNT = 0;

	int STRING_TO_EVAL_RES_MAP = 35;

	int STRING_TO_EVAL_RES_MAP__KEY = 0;

	int STRING_TO_EVAL_RES_MAP__VALUE = 1;

	int STRING_TO_EVAL_RES_MAP_FEATURE_COUNT = 2;

	int STRING_TO_EVAL_RES_MAP_OPERATION_COUNT = 0;

	int EVAL_RES = 36;

	int EVAL_RES_FEATURE_COUNT = 0;

	int EVAL_RES_OPERATION_COUNT = 0;

	int EVAL_MAP_RES = 37;

	int EVAL_MAP_RES__VALUES = 0;

	int EVAL_MAP_RES_FEATURE_COUNT = EVAL_RES_FEATURE_COUNT + 1;

	int EVAL_MAP_RES_OPERATION_COUNT = EVAL_RES_OPERATION_COUNT + 0;

	int EVAL_FUN_RES = 38;

	int EVAL_FUN_RES__EXP = 0;

	int EVAL_FUN_RES__CTX = 1;

	int EVAL_FUN_RES__NAME = 2;

	int EVAL_FUN_RES_FEATURE_COUNT = EVAL_RES_FEATURE_COUNT + 3;

	int EVAL_FUN_RES_OPERATION_COUNT = EVAL_RES_OPERATION_COUNT + 0;

	int EVAL_BOUND_FUN_RES = 39;

	int EVAL_BOUND_FUN_RES__EXP = EVAL_FUN_RES__EXP;

	int EVAL_BOUND_FUN_RES__CTX = EVAL_FUN_RES__CTX;

	int EVAL_BOUND_FUN_RES__NAME = EVAL_FUN_RES__NAME;

	int EVAL_BOUND_FUN_RES__TH = 3;

	int EVAL_BOUND_FUN_RES_FEATURE_COUNT = EVAL_FUN_RES_FEATURE_COUNT + 1;

	int EVAL_BOUND_FUN_RES_OPERATION_COUNT = EVAL_FUN_RES_OPERATION_COUNT + 0;

	int EVAL_INT_RES = 40;

	int EVAL_INT_RES__VALUE = 0;

	int EVAL_INT_RES_FEATURE_COUNT = EVAL_RES_FEATURE_COUNT + 1;

	int EVAL_INT_RES_OPERATION_COUNT = EVAL_RES_OPERATION_COUNT + 0;

	int EVAL_BOOL_RES = 41;

	int EVAL_BOOL_RES__VALUE = 0;

	int EVAL_BOOL_RES_FEATURE_COUNT = EVAL_RES_FEATURE_COUNT + 1;

	int EVAL_BOOL_RES_OPERATION_COUNT = EVAL_RES_OPERATION_COUNT + 0;

	EClass getFile();

	EReference getFile_Commands();

	EClass getTopLevelCmd();

	EClass getExpr();

	EClass getDef();

	EAttribute getDef_Name();

	EReference getDef_Expr();

	EClass getApp();

	EReference getApp_Lhs();

	EReference getApp_Rhs();

	EClass getVar();

	EAttribute getVar_Name();

	EClass getThis();

	EClass getBool();

	EAttribute getBool_Value();

	EClass getInt();

	EAttribute getInt_Value();

	EClass getSkip();

	EClass getProject();

	EReference getProject_Exp();

	EAttribute getProject_Name();

	EClass getBObject();

	EReference getBObject_Fields();

	EClass getField();

	EAttribute getField_Name();

	EReference getField_Value();

	EClass getCopy();

	EReference getCopy_Copy();

	EClass getWith();

	EReference getWith_Lhs();

	EReference getWith_Rhs();

	EClass getArithOp();

	EReference getArithOp_Lhs();

	EReference getArithOp_Rhs();

	EClass getNot();

	EReference getNot_Value();

	EClass getCmpOp();

	EReference getCmpOp_Lhs();

	EReference getCmpOp_Rhs();

	EClass getBoolOp();

	EClass getIf();

	EReference getIf_Cond();

	EReference getIf_Thn();

	EReference getIf_Els();

	EClass getLet();

	EAttribute getLet_Name();

	EReference getLet_Lhs();

	EReference getLet_Rhs();

	EClass getFun();

	EAttribute getFun_Name();

	EReference getFun_Body();

	EClass getAssign();

	EReference getAssign_Lhs();

	EReference getAssign_Rhs();

	EAttribute getAssign_Name();

	EClass getArithOpPlus();

	EClass getArithOpMinus();

	EClass getArithOpTimes();

	EClass getArithOpDivide();

	EClass getArithOpRemainder();

	EClass getBoolOpAnd();

	EReference getBoolOpAnd_Lhs();

	EReference getBoolOpAnd_Rhs();

	EClass getBoolOpOr();

	EReference getBoolOpOr_Lhs();

	EReference getBoolOpOr_Rhs();

	EClass getSeq();

	EReference getSeq_Lhs();

	EReference getSeq_Rhs();

	EClass getCmpOpEqual();

	EClass getCmpOpUnequal();

	EClass getCmpOpLess();

	EClass getCtx();

	EReference getCtx_Env();

	EReference getCtx_Th();

	EClass getStringToEvalResMap();

	EAttribute getStringToEvalResMap_Key();

	EReference getStringToEvalResMap_Value();

	EClass getEvalRes();

	EClass getEvalMapRes();

	EReference getEvalMapRes_Values();

	EClass getEvalFunRes();

	EReference getEvalFunRes_Exp();

	EReference getEvalFunRes_Ctx();

	EAttribute getEvalFunRes_Name();

	EClass getEvalBoundFunRes();

	EReference getEvalBoundFunRes_Th();

	EClass getEvalIntRes();

	EAttribute getEvalIntRes_Value();

	EClass getEvalBoolRes();

	EAttribute getEvalBoolRes_Value();

	BoaFactory getBoaFactory();

	interface Literals {
		EClass FILE = eINSTANCE.getFile();

		EReference FILE__COMMANDS = eINSTANCE.getFile_Commands();

		EClass TOP_LEVEL_CMD = eINSTANCE.getTopLevelCmd();

		EClass EXPR = eINSTANCE.getExpr();

		EClass DEF = eINSTANCE.getDef();

		EAttribute DEF__NAME = eINSTANCE.getDef_Name();

		EReference DEF__EXPR = eINSTANCE.getDef_Expr();

		EClass APP = eINSTANCE.getApp();

		EReference APP__LHS = eINSTANCE.getApp_Lhs();

		EReference APP__RHS = eINSTANCE.getApp_Rhs();

		EClass VAR = eINSTANCE.getVar();

		EAttribute VAR__NAME = eINSTANCE.getVar_Name();

		EClass THIS = eINSTANCE.getThis();

		EClass BOOL = eINSTANCE.getBool();

		EAttribute BOOL__VALUE = eINSTANCE.getBool_Value();

		EClass INT = eINSTANCE.getInt();

		EAttribute INT__VALUE = eINSTANCE.getInt_Value();

		EClass SKIP = eINSTANCE.getSkip();

		EClass PROJECT = eINSTANCE.getProject();

		EReference PROJECT__EXP = eINSTANCE.getProject_Exp();

		EAttribute PROJECT__NAME = eINSTANCE.getProject_Name();

		EClass BOBJECT = eINSTANCE.getBObject();

		EReference BOBJECT__FIELDS = eINSTANCE.getBObject_Fields();

		EClass FIELD = eINSTANCE.getField();

		EAttribute FIELD__NAME = eINSTANCE.getField_Name();

		EReference FIELD__VALUE = eINSTANCE.getField_Value();

		EClass COPY = eINSTANCE.getCopy();

		EReference COPY__COPY = eINSTANCE.getCopy_Copy();

		EClass WITH = eINSTANCE.getWith();

		EReference WITH__LHS = eINSTANCE.getWith_Lhs();

		EReference WITH__RHS = eINSTANCE.getWith_Rhs();

		EClass ARITH_OP = eINSTANCE.getArithOp();

		EReference ARITH_OP__LHS = eINSTANCE.getArithOp_Lhs();

		EReference ARITH_OP__RHS = eINSTANCE.getArithOp_Rhs();

		EClass NOT = eINSTANCE.getNot();

		EReference NOT__VALUE = eINSTANCE.getNot_Value();

		EClass CMP_OP = eINSTANCE.getCmpOp();

		EReference CMP_OP__LHS = eINSTANCE.getCmpOp_Lhs();

		EReference CMP_OP__RHS = eINSTANCE.getCmpOp_Rhs();

		EClass BOOL_OP = eINSTANCE.getBoolOp();

		EClass IF = eINSTANCE.getIf();

		EReference IF__COND = eINSTANCE.getIf_Cond();

		EReference IF__THN = eINSTANCE.getIf_Thn();

		EReference IF__ELS = eINSTANCE.getIf_Els();

		EClass LET = eINSTANCE.getLet();

		EAttribute LET__NAME = eINSTANCE.getLet_Name();

		EReference LET__LHS = eINSTANCE.getLet_Lhs();

		EReference LET__RHS = eINSTANCE.getLet_Rhs();

		EClass FUN = eINSTANCE.getFun();

		EAttribute FUN__NAME = eINSTANCE.getFun_Name();

		EReference FUN__BODY = eINSTANCE.getFun_Body();

		EClass ASSIGN = eINSTANCE.getAssign();

		EReference ASSIGN__LHS = eINSTANCE.getAssign_Lhs();

		EReference ASSIGN__RHS = eINSTANCE.getAssign_Rhs();

		EAttribute ASSIGN__NAME = eINSTANCE.getAssign_Name();

		EClass ARITH_OP_PLUS = eINSTANCE.getArithOpPlus();

		EClass ARITH_OP_MINUS = eINSTANCE.getArithOpMinus();

		EClass ARITH_OP_TIMES = eINSTANCE.getArithOpTimes();

		EClass ARITH_OP_DIVIDE = eINSTANCE.getArithOpDivide();

		EClass ARITH_OP_REMAINDER = eINSTANCE.getArithOpRemainder();

		EClass BOOL_OP_AND = eINSTANCE.getBoolOpAnd();

		EReference BOOL_OP_AND__LHS = eINSTANCE.getBoolOpAnd_Lhs();

		EReference BOOL_OP_AND__RHS = eINSTANCE.getBoolOpAnd_Rhs();

		EClass BOOL_OP_OR = eINSTANCE.getBoolOpOr();

		EReference BOOL_OP_OR__LHS = eINSTANCE.getBoolOpOr_Lhs();

		EReference BOOL_OP_OR__RHS = eINSTANCE.getBoolOpOr_Rhs();

		EClass SEQ = eINSTANCE.getSeq();

		EReference SEQ__LHS = eINSTANCE.getSeq_Lhs();

		EReference SEQ__RHS = eINSTANCE.getSeq_Rhs();

		EClass CMP_OP_EQUAL = eINSTANCE.getCmpOpEqual();

		EClass CMP_OP_UNEQUAL = eINSTANCE.getCmpOpUnequal();

		EClass CMP_OP_LESS = eINSTANCE.getCmpOpLess();

		EClass CTX = eINSTANCE.getCtx();

		EReference CTX__ENV = eINSTANCE.getCtx_Env();

		EReference CTX__TH = eINSTANCE.getCtx_Th();

		EClass STRING_TO_EVAL_RES_MAP = eINSTANCE.getStringToEvalResMap();

		EAttribute STRING_TO_EVAL_RES_MAP__KEY = eINSTANCE.getStringToEvalResMap_Key();

		EReference STRING_TO_EVAL_RES_MAP__VALUE = eINSTANCE.getStringToEvalResMap_Value();

		EClass EVAL_RES = eINSTANCE.getEvalRes();

		EClass EVAL_MAP_RES = eINSTANCE.getEvalMapRes();

		EReference EVAL_MAP_RES__VALUES = eINSTANCE.getEvalMapRes_Values();

		EClass EVAL_FUN_RES = eINSTANCE.getEvalFunRes();

		EReference EVAL_FUN_RES__EXP = eINSTANCE.getEvalFunRes_Exp();

		EReference EVAL_FUN_RES__CTX = eINSTANCE.getEvalFunRes_Ctx();

		EAttribute EVAL_FUN_RES__NAME = eINSTANCE.getEvalFunRes_Name();

		EClass EVAL_BOUND_FUN_RES = eINSTANCE.getEvalBoundFunRes();

		EReference EVAL_BOUND_FUN_RES__TH = eINSTANCE.getEvalBoundFunRes_Th();

		EClass EVAL_INT_RES = eINSTANCE.getEvalIntRes();

		EAttribute EVAL_INT_RES__VALUE = eINSTANCE.getEvalIntRes_Value();

		EClass EVAL_BOOL_RES = eINSTANCE.getEvalBoolRes();

		EAttribute EVAL_BOOL_RES__VALUE = eINSTANCE.getEvalBoolRes_Value();
	}
}
