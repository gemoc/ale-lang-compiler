package interpreter.imp.interpreter.imp;

import interpreter.imp.interpreter.imp.impl.ImpPackageImpl;
import java.lang.String;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

public interface ImpPackage extends EPackage {
  ImpPackage eINSTANCE = ImpPackageImpl.init();

  String eNS_URI = "http://imp.imp.imp/";

  String eNAME = "imp";

  String eNS_PREFIX = "imp";

  int STMT = 0;

  int SKIP = 1;

  int ASSIGN = 2;

  int EXPR = 3;

  int BLOCK = 4;

  int IF = 5;

  int WHILE = 6;

  int INT_CONST = 7;

  int VAR = 8;

  int UNARY = 9;

  int BINARY = 10;

  int STORE = 11;

  int STRING_TO_VALUE_MAP = 12;

  int VALUE = 13;

  int INT_VALUE = 14;

  int BOOL_VALUE = 15;

  int ARRAY_VALUE = 16;

  int ARRAY_DECL = 17;

  int BOOL_CONST = 18;

  int UNARY_OP = 19;

  int BINARY_OP = 20;

  int ASSIGN__NAME = 0;

  int ASSIGN__EXP = 1;

  int ASSIGN__INDEX = 2;

  int BLOCK__STMTS = 0;

  int IF__COND = 0;

  int IF__LHS = 1;

  int IF__RHS = 2;

  int WHILE__COND = 0;

  int WHILE__BODY = 1;

  int INT_CONST__VALUE = 0;

  int VAR__NAME = 0;

  int VAR__INDEX = 1;

  int UNARY__OP = 0;

  int UNARY__EXPR = 1;

  int BINARY__LHS = 0;

  int BINARY__RHS = 1;

  int BINARY__OP = 2;

  int STORE__VALUES = 0;

  int STRING_TO_VALUE_MAP__KEY = 0;

  int STRING_TO_VALUE_MAP__VALUE = 1;

  int INT_VALUE__VALUE = 0;

  int BOOL_VALUE__VALUE = 0;

  int ARRAY_VALUE__VALUES = 0;

  int ARRAY_DECL__VALUES = 0;

  int BOOL_CONST__VALUE = 0;

  EClass getStmt();

  EClass getSkip();

  EClass getAssign();

  EClass getExpr();

  EClass getBlock();

  EClass getIf();

  EClass getWhile();

  EClass getIntConst();

  EClass getVar();

  EClass getUnary();

  EClass getBinary();

  EClass getStore();

  EClass getStringToValueMap();

  EClass getValue();

  EClass getIntValue();

  EClass getBoolValue();

  EClass getArrayValue();

  EClass getArrayDecl();

  EClass getBoolConst();

  EEnum getUnaryOp();

  EEnum getBinaryOp();

  EReference getAssign_Exp();

  EReference getAssign_Index();

  EReference getBlock_Stmts();

  EReference getIf_Cond();

  EReference getIf_Lhs();

  EReference getIf_Rhs();

  EReference getWhile_Cond();

  EReference getWhile_Body();

  EReference getVar_Index();

  EReference getUnary_Expr();

  EReference getBinary_Lhs();

  EReference getBinary_Rhs();

  EReference getStore_Values();

  EReference getString_to_value_map_Value();

  EReference getArray_value_Values();

  EReference getArray_decl_Values();

  EAttribute getAssign_Name();

  EAttribute getInt_const_Value();

  EAttribute getVar_Name();

  EAttribute getUnary_Op();

  EAttribute getBinary_Op();

  EAttribute getString_to_value_map_Key();

  EAttribute getInt_value_Value();

  EAttribute getBool_value_Value();

  EAttribute getBool_const_Value();

  ImpFactory getImpFactory();

  interface Literals {
    EClass STMT = eINSTANCE.getStmt();

    EClass SKIP = eINSTANCE.getSkip();

    EClass ASSIGN = eINSTANCE.getAssign();

    EClass EXPR = eINSTANCE.getExpr();

    EClass BLOCK = eINSTANCE.getBlock();

    EClass IF = eINSTANCE.getIf();

    EClass WHILE = eINSTANCE.getWhile();

    EClass INT_CONST = eINSTANCE.getIntConst();

    EClass VAR = eINSTANCE.getVar();

    EClass UNARY = eINSTANCE.getUnary();

    EClass BINARY = eINSTANCE.getBinary();

    EClass STORE = eINSTANCE.getStore();

    EClass STRING_TO_VALUE_MAP = eINSTANCE.getStringToValueMap();

    EClass VALUE = eINSTANCE.getValue();

    EClass INT_VALUE = eINSTANCE.getIntValue();

    EClass BOOL_VALUE = eINSTANCE.getBoolValue();

    EClass ARRAY_VALUE = eINSTANCE.getArrayValue();

    EClass ARRAY_DECL = eINSTANCE.getArrayDecl();

    EClass BOOL_CONST = eINSTANCE.getBoolConst();

    EReference ASSIGN__EXP = eINSTANCE.getAssign_Exp();

    EReference ASSIGN__INDEX = eINSTANCE.getAssign_Index();

    EReference BLOCK__STMTS = eINSTANCE.getBlock_Stmts();

    EReference IF__COND = eINSTANCE.getIf_Cond();

    EReference IF__LHS = eINSTANCE.getIf_Lhs();

    EReference IF__RHS = eINSTANCE.getIf_Rhs();

    EReference WHILE__COND = eINSTANCE.getWhile_Cond();

    EReference WHILE__BODY = eINSTANCE.getWhile_Body();

    EReference VAR__INDEX = eINSTANCE.getVar_Index();

    EReference UNARY__EXPR = eINSTANCE.getUnary_Expr();

    EReference BINARY__LHS = eINSTANCE.getBinary_Lhs();

    EReference BINARY__RHS = eINSTANCE.getBinary_Rhs();

    EReference STORE__VALUES = eINSTANCE.getStore_Values();

    EReference STRING_TO_VALUE_MAP__VALUE = eINSTANCE.getString_to_value_map_Value();

    EReference ARRAY_VALUE__VALUES = eINSTANCE.getArray_value_Values();

    EReference ARRAY_DECL__VALUES = eINSTANCE.getArray_decl_Values();

    EAttribute ASSIGN__NAME = eINSTANCE.getAssign_Name();

    EAttribute INT_CONST__VALUE = eINSTANCE.getInt_const_Value();

    EAttribute VAR__NAME = eINSTANCE.getVar_Name();

    EAttribute UNARY__OP = eINSTANCE.getUnary_Op();

    EAttribute BINARY__OP = eINSTANCE.getBinary_Op();

    EAttribute STRING_TO_VALUE_MAP__KEY = eINSTANCE.getString_to_value_map_Key();

    EAttribute INT_VALUE__VALUE = eINSTANCE.getInt_value_Value();

    EAttribute BOOL_VALUE__VALUE = eINSTANCE.getBool_value_Value();

    EAttribute BOOL_CONST__VALUE = eINSTANCE.getBool_const_Value();
  }
}
