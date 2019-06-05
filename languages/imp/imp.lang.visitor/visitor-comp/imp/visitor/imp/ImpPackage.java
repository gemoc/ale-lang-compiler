package imp.visitor.imp;

import imp.visitor.imp.impl.ImpPackageImpl;
import java.lang.String;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

public interface ImpPackage extends EPackage {
	String eNAME = "imp";

	String eNS_URI = "http://imp.imp.imp/";

	String eNS_PREFIX = "imp";

	ImpPackage eINSTANCE = ImpPackageImpl.init();

	int STMT = 0;

	int STMT_FEATURE_COUNT = 0;

	int STMT_OPERATION_COUNT = 0;

	int SKIP = 1;

	int SKIP_FEATURE_COUNT = STMT_FEATURE_COUNT + 0;

	int SKIP_OPERATION_COUNT = STMT_OPERATION_COUNT + 0;

	int ASSIGN = 2;

	int ASSIGN__NAME = 0;

	int ASSIGN__EXP = 1;

	int ASSIGN_FEATURE_COUNT = STMT_FEATURE_COUNT + 2;

	int ASSIGN_OPERATION_COUNT = STMT_OPERATION_COUNT + 0;

	int EXPR = 3;

	int EXPR_FEATURE_COUNT = 0;

	int EXPR_OPERATION_COUNT = 0;

	int BLOCK = 4;

	int BLOCK__STMTS = 0;

	int BLOCK_FEATURE_COUNT = STMT_FEATURE_COUNT + 1;

	int BLOCK_OPERATION_COUNT = STMT_OPERATION_COUNT + 0;

	int IF = 5;

	int IF__COND = 0;

	int IF__LHS = 1;

	int IF__RHS = 2;

	int IF_FEATURE_COUNT = STMT_FEATURE_COUNT + 3;

	int IF_OPERATION_COUNT = STMT_OPERATION_COUNT + 0;

	int WHILE = 6;

	int WHILE__COND = 0;

	int WHILE__BODY = 1;

	int WHILE_FEATURE_COUNT = STMT_FEATURE_COUNT + 2;

	int WHILE_OPERATION_COUNT = STMT_OPERATION_COUNT + 0;

	int INT_CONST = 7;

	int INT_CONST__VALUE = 0;

	int INT_CONST_FEATURE_COUNT = EXPR_FEATURE_COUNT + 1;

	int INT_CONST_OPERATION_COUNT = EXPR_OPERATION_COUNT + 0;

	int VAR = 8;

	int VAR__NAME = 0;

	int VAR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 1;

	int VAR_OPERATION_COUNT = EXPR_OPERATION_COUNT + 0;

	int UNARY = 9;

	int UNARY__OP = 0;

	int UNARY__EXPR = 1;

	int UNARY_FEATURE_COUNT = EXPR_FEATURE_COUNT + 2;

	int UNARY_OPERATION_COUNT = EXPR_OPERATION_COUNT + 0;

	int BINARY = 10;

	int BINARY__LHS = 0;

	int BINARY__RHS = 1;

	int BINARY__OP = 2;

	int BINARY_FEATURE_COUNT = EXPR_FEATURE_COUNT + 3;

	int BINARY_OPERATION_COUNT = EXPR_OPERATION_COUNT + 0;

	int STORE = 11;

	int STORE__VALUES = 0;

	int STORE_FEATURE_COUNT = 1;

	int STORE_OPERATION_COUNT = 0;

	int STRING_TO_VALUE_MAP = 12;

	int STRING_TO_VALUE_MAP__KEY = 0;

	int STRING_TO_VALUE_MAP__VALUE = 1;

	int STRING_TO_VALUE_MAP_FEATURE_COUNT = 2;

	int STRING_TO_VALUE_MAP_OPERATION_COUNT = 0;

	int VALUE = 13;

	int VALUE_FEATURE_COUNT = 0;

	int VALUE_OPERATION_COUNT = 0;

	int INT_VALUE = 14;

	int INT_VALUE__VALUE = 0;

	int INT_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 1;

	int INT_VALUE_OPERATION_COUNT = VALUE_OPERATION_COUNT + 0;

	int BOOL_VALUE = 15;

	int BOOL_VALUE__VALUE = 0;

	int BOOL_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 1;

	int BOOL_VALUE_OPERATION_COUNT = VALUE_OPERATION_COUNT + 0;

	int UNARY_OP = 16;

	int BINARY_OP = 17;

	EClass getStmt();

	EClass getSkip();

	EClass getAssign();

	EAttribute getAssign_Name();

	EReference getAssign_Exp();

	EClass getExpr();

	EClass getBlock();

	EReference getBlock_Stmts();

	EClass getIf();

	EReference getIf_Cond();

	EReference getIf_Lhs();

	EReference getIf_Rhs();

	EClass getWhile();

	EReference getWhile_Cond();

	EReference getWhile_Body();

	EClass getIntConst();

	EAttribute getIntConst_Value();

	EClass getVar();

	EAttribute getVar_Name();

	EClass getUnary();

	EAttribute getUnary_Op();

	EReference getUnary_Expr();

	EClass getBinary();

	EReference getBinary_Lhs();

	EReference getBinary_Rhs();

	EAttribute getBinary_Op();

	EEnum getUnaryOp();

	EEnum getBinaryOp();

	EClass getStore();

	EReference getStore_Values();

	EClass getStringToValueMap();

	EAttribute getStringToValueMap_Key();

	EReference getStringToValueMap_Value();

	EClass getValue();

	EClass getIntValue();

	EAttribute getIntValue_Value();

	EClass getBoolValue();

	EAttribute getBoolValue_Value();

	ImpFactory getImpFactory();

	interface Literals {
		EClass STMT = eINSTANCE.getStmt();

		EClass SKIP = eINSTANCE.getSkip();

		EClass ASSIGN = eINSTANCE.getAssign();

		EAttribute ASSIGN__NAME = eINSTANCE.getAssign_Name();

		EReference ASSIGN__EXP = eINSTANCE.getAssign_Exp();

		EClass EXPR = eINSTANCE.getExpr();

		EClass BLOCK = eINSTANCE.getBlock();

		EReference BLOCK__STMTS = eINSTANCE.getBlock_Stmts();

		EClass IF = eINSTANCE.getIf();

		EReference IF__COND = eINSTANCE.getIf_Cond();

		EReference IF__LHS = eINSTANCE.getIf_Lhs();

		EReference IF__RHS = eINSTANCE.getIf_Rhs();

		EClass WHILE = eINSTANCE.getWhile();

		EReference WHILE__COND = eINSTANCE.getWhile_Cond();

		EReference WHILE__BODY = eINSTANCE.getWhile_Body();

		EClass INT_CONST = eINSTANCE.getIntConst();

		EAttribute INT_CONST__VALUE = eINSTANCE.getIntConst_Value();

		EClass VAR = eINSTANCE.getVar();

		EAttribute VAR__NAME = eINSTANCE.getVar_Name();

		EClass UNARY = eINSTANCE.getUnary();

		EAttribute UNARY__OP = eINSTANCE.getUnary_Op();

		EReference UNARY__EXPR = eINSTANCE.getUnary_Expr();

		EClass BINARY = eINSTANCE.getBinary();

		EReference BINARY__LHS = eINSTANCE.getBinary_Lhs();

		EReference BINARY__RHS = eINSTANCE.getBinary_Rhs();

		EAttribute BINARY__OP = eINSTANCE.getBinary_Op();

		EClass STORE = eINSTANCE.getStore();

		EReference STORE__VALUES = eINSTANCE.getStore_Values();

		EClass STRING_TO_VALUE_MAP = eINSTANCE.getStringToValueMap();

		EAttribute STRING_TO_VALUE_MAP__KEY = eINSTANCE.getStringToValueMap_Key();

		EReference STRING_TO_VALUE_MAP__VALUE = eINSTANCE.getStringToValueMap_Value();

		EClass VALUE = eINSTANCE.getValue();

		EClass INT_VALUE = eINSTANCE.getIntValue();

		EAttribute INT_VALUE__VALUE = eINSTANCE.getIntValue_Value();

		EClass BOOL_VALUE = eINSTANCE.getBoolValue();

		EAttribute BOOL_VALUE__VALUE = eINSTANCE.getBoolValue_Value();

		EEnum UNARYOP = eINSTANCE.getUnaryOp();

		EEnum BINARYOP = eINSTANCE.getBinaryOp();
	}
}
