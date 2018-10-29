package boa.interpreter.boa;

import boa.interpreter.boa.impl.BoaPackageImpl;
import java.lang.String;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

public interface BoaPackage extends EPackage {
  BoaPackage eINSTANCE = BoaPackageImpl.init();

  String eNS_URI = "http://boa.boa.boa/";

  String eNAME = "boa";

  String eNS_PREFIX = "boa";

  int FILE = 0;

  int TOP_LEVEL_CMD = 1;

  int EXPR = 2;

  int DEF = 3;

  int APP = 4;

  int VAR = 5;

  int THIS = 6;

  int BOOL = 7;

  int INT = 8;

  int SKIP = 9;

  int PROJECT = 10;

  int BOBJECT = 11;

  int FIELD = 12;

  int COPY = 13;

  int WITH = 14;

  int ARITH_OP = 15;

  int NOT = 16;

  int CMP_OP = 17;

  int BOOL_OP = 18;

  int IF = 19;

  int LET = 20;

  int FUN = 21;

  int ASSIGN = 22;

  int ARITH_OP_PLUS = 23;

  int ARITH_OP_MINUS = 24;

  int ARITH_OP_TIMES = 25;

  int ARITH_OP_DIVIDE = 26;

  int ARITH_OP_REMAINDER = 27;

  int BOOL_OP_AND = 28;

  int BOOL_OP_OR = 29;

  int SEQ = 30;

  int CMP_OP_EQUAL = 31;

  int CMP_OP_UNEQUAL = 32;

  int CMP_OP_LESS = 33;

  int FILE__COMMANDS = 0;

  int DEF__NAME = 0;

  int DEF__EXPR = 1;

  int APP__LHS = 0;

  int APP__RHS = 1;

  int VAR__NAME = 0;

  int BOOL__VALUE = 0;

  int INT__VALUE = 0;

  int PROJECT__EXP = 0;

  int PROJECT__NAME = 1;

  int BOBJECT__FIELDS = 0;

  int FIELD__NAME = 0;

  int FIELD__VALUE = 1;

  int COPY__COPY = 0;

  int WITH__LHS = 0;

  int WITH__RHS = 1;

  int ARITH_OP__LHS = 0;

  int ARITH_OP__RHS = 1;

  int NOT__VALUE = 0;

  int CMP_OP__LHS = 0;

  int CMP_OP__RHS = 1;

  int IF__COND = 0;

  int IF__THN = 1;

  int IF__ELS = 2;

  int LET__NAME = 0;

  int LET__LHS = 1;

  int LET__RHS = 2;

  int FUN__NAME = 0;

  int FUN__BODY = 1;

  int ASSIGN__LHS = 0;

  int ASSIGN__RHS = 1;

  int ASSIGN__NAME = 2;

  int BOOL_OP_AND__LHS = 0;

  int BOOL_OP_AND__RHS = 1;

  int BOOL_OP_OR__LHS = 0;

  int BOOL_OP_OR__RHS = 1;

  int SEQ__LHS = 0;

  int SEQ__RHS = 1;

  EClass getFile();

  EClass getTopLevelCmd();

  EClass getExpr();

  EClass getDef();

  EClass getApp();

  EClass getVar();

  EClass getThis();

  EClass getBool();

  EClass getInt();

  EClass getSkip();

  EClass getProject();

  EClass getBObject();

  EClass getField();

  EClass getCopy();

  EClass getWith();

  EClass getArithOp();

  EClass getNot();

  EClass getCmpOp();

  EClass getBoolOp();

  EClass getIf();

  EClass getLet();

  EClass getFun();

  EClass getAssign();

  EClass getArithOpPlus();

  EClass getArithOpMinus();

  EClass getArithOpTimes();

  EClass getArithOpDivide();

  EClass getArithOpRemainder();

  EClass getBoolOpAnd();

  EClass getBoolOpOr();

  EClass getSeq();

  EClass getCmpOpEqual();

  EClass getCmpOpUnequal();

  EClass getCmpOpLess();

  EReference getFile_Commands();

  EReference getDef_Expr();

  EReference getApp_Lhs();

  EReference getApp_Rhs();

  EReference getProject_Exp();

  EReference getBobject_Fields();

  EReference getField_Value();

  EReference getCopy_Copy();

  EReference getWith_Lhs();

  EReference getWith_Rhs();

  EReference getArith_op_Lhs();

  EReference getArith_op_Rhs();

  EReference getNot_Value();

  EReference getCmp_op_Lhs();

  EReference getCmp_op_Rhs();

  EReference getIf_Cond();

  EReference getIf_Thn();

  EReference getIf_Els();

  EReference getLet_Lhs();

  EReference getLet_Rhs();

  EReference getFun_Body();

  EReference getAssign_Lhs();

  EReference getAssign_Rhs();

  EReference getBool_op_and_Lhs();

  EReference getBool_op_and_Rhs();

  EReference getBool_op_or_Lhs();

  EReference getBool_op_or_Rhs();

  EReference getSeq_Lhs();

  EReference getSeq_Rhs();

  EAttribute getDef_Name();

  EAttribute getVar_Name();

  EAttribute getBool_Value();

  EAttribute getInt_Value();

  EAttribute getProject_Name();

  EAttribute getField_Name();

  EAttribute getLet_Name();

  EAttribute getFun_Name();

  EAttribute getAssign_Name();

  BoaFactory getBoaFactory();

  interface Literals {
    EClass FILE = eINSTANCE.getFile();

    EClass TOP_LEVEL_CMD = eINSTANCE.getTopLevelCmd();

    EClass EXPR = eINSTANCE.getExpr();

    EClass DEF = eINSTANCE.getDef();

    EClass APP = eINSTANCE.getApp();

    EClass VAR = eINSTANCE.getVar();

    EClass THIS = eINSTANCE.getThis();

    EClass BOOL = eINSTANCE.getBool();

    EClass INT = eINSTANCE.getInt();

    EClass SKIP = eINSTANCE.getSkip();

    EClass PROJECT = eINSTANCE.getProject();

    EClass BOBJECT = eINSTANCE.getBObject();

    EClass FIELD = eINSTANCE.getField();

    EClass COPY = eINSTANCE.getCopy();

    EClass WITH = eINSTANCE.getWith();

    EClass ARITH_OP = eINSTANCE.getArithOp();

    EClass NOT = eINSTANCE.getNot();

    EClass CMP_OP = eINSTANCE.getCmpOp();

    EClass BOOL_OP = eINSTANCE.getBoolOp();

    EClass IF = eINSTANCE.getIf();

    EClass LET = eINSTANCE.getLet();

    EClass FUN = eINSTANCE.getFun();

    EClass ASSIGN = eINSTANCE.getAssign();

    EClass ARITH_OP_PLUS = eINSTANCE.getArithOpPlus();

    EClass ARITH_OP_MINUS = eINSTANCE.getArithOpMinus();

    EClass ARITH_OP_TIMES = eINSTANCE.getArithOpTimes();

    EClass ARITH_OP_DIVIDE = eINSTANCE.getArithOpDivide();

    EClass ARITH_OP_REMAINDER = eINSTANCE.getArithOpRemainder();

    EClass BOOL_OP_AND = eINSTANCE.getBoolOpAnd();

    EClass BOOL_OP_OR = eINSTANCE.getBoolOpOr();

    EClass SEQ = eINSTANCE.getSeq();

    EClass CMP_OP_EQUAL = eINSTANCE.getCmpOpEqual();

    EClass CMP_OP_UNEQUAL = eINSTANCE.getCmpOpUnequal();

    EClass CMP_OP_LESS = eINSTANCE.getCmpOpLess();

    EReference FILE__COMMANDS = eINSTANCE.getFile_Commands();

    EReference DEF__EXPR = eINSTANCE.getDef_Expr();

    EReference APP__LHS = eINSTANCE.getApp_Lhs();

    EReference APP__RHS = eINSTANCE.getApp_Rhs();

    EReference PROJECT__EXP = eINSTANCE.getProject_Exp();

    EReference BOBJECT__FIELDS = eINSTANCE.getBobject_Fields();

    EReference FIELD__VALUE = eINSTANCE.getField_Value();

    EReference COPY__COPY = eINSTANCE.getCopy_Copy();

    EReference WITH__LHS = eINSTANCE.getWith_Lhs();

    EReference WITH__RHS = eINSTANCE.getWith_Rhs();

    EReference ARITH_OP__LHS = eINSTANCE.getArith_op_Lhs();

    EReference ARITH_OP__RHS = eINSTANCE.getArith_op_Rhs();

    EReference NOT__VALUE = eINSTANCE.getNot_Value();

    EReference CMP_OP__LHS = eINSTANCE.getCmp_op_Lhs();

    EReference CMP_OP__RHS = eINSTANCE.getCmp_op_Rhs();

    EReference IF__COND = eINSTANCE.getIf_Cond();

    EReference IF__THN = eINSTANCE.getIf_Thn();

    EReference IF__ELS = eINSTANCE.getIf_Els();

    EReference LET__LHS = eINSTANCE.getLet_Lhs();

    EReference LET__RHS = eINSTANCE.getLet_Rhs();

    EReference FUN__BODY = eINSTANCE.getFun_Body();

    EReference ASSIGN__LHS = eINSTANCE.getAssign_Lhs();

    EReference ASSIGN__RHS = eINSTANCE.getAssign_Rhs();

    EReference BOOL_OP_AND__LHS = eINSTANCE.getBool_op_and_Lhs();

    EReference BOOL_OP_AND__RHS = eINSTANCE.getBool_op_and_Rhs();

    EReference BOOL_OP_OR__LHS = eINSTANCE.getBool_op_or_Lhs();

    EReference BOOL_OP_OR__RHS = eINSTANCE.getBool_op_or_Rhs();

    EReference SEQ__LHS = eINSTANCE.getSeq_Lhs();

    EReference SEQ__RHS = eINSTANCE.getSeq_Rhs();

    EAttribute DEF__NAME = eINSTANCE.getDef_Name();

    EAttribute VAR__NAME = eINSTANCE.getVar_Name();

    EAttribute BOOL__VALUE = eINSTANCE.getBool_Value();

    EAttribute INT__VALUE = eINSTANCE.getInt_Value();

    EAttribute PROJECT__NAME = eINSTANCE.getProject_Name();

    EAttribute FIELD__NAME = eINSTANCE.getField_Name();

    EAttribute LET__NAME = eINSTANCE.getLet_Name();

    EAttribute FUN__NAME = eINSTANCE.getFun_Name();

    EAttribute ASSIGN__NAME = eINSTANCE.getAssign_Name();
  }
}
