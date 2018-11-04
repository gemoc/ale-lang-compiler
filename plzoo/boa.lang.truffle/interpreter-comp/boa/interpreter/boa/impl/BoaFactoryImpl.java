package boa.interpreter.boa.impl;

import boa.interpreter.boa.App;
import boa.interpreter.boa.ArithOpDivide;
import boa.interpreter.boa.ArithOpMinus;
import boa.interpreter.boa.ArithOpPlus;
import boa.interpreter.boa.ArithOpRemainder;
import boa.interpreter.boa.ArithOpTimes;
import boa.interpreter.boa.Assign;
import boa.interpreter.boa.BObject;
import boa.interpreter.boa.BoaFactory;
import boa.interpreter.boa.BoaPackage;
import boa.interpreter.boa.Bool;
import boa.interpreter.boa.BoolOpAnd;
import boa.interpreter.boa.BoolOpOr;
import boa.interpreter.boa.CmpOpEqual;
import boa.interpreter.boa.CmpOpLess;
import boa.interpreter.boa.CmpOpUnequal;
import boa.interpreter.boa.Copy;
import boa.interpreter.boa.Ctx;
import boa.interpreter.boa.Def;
import boa.interpreter.boa.EvalBoolRes;
import boa.interpreter.boa.EvalBoundFunRes;
import boa.interpreter.boa.EvalFunRes;
import boa.interpreter.boa.EvalIntRes;
import boa.interpreter.boa.EvalMapRes;
import boa.interpreter.boa.EvalRes;
import boa.interpreter.boa.Field;
import boa.interpreter.boa.File;
import boa.interpreter.boa.Fun;
import boa.interpreter.boa.If;
import boa.interpreter.boa.Int;
import boa.interpreter.boa.Let;
import boa.interpreter.boa.Not;
import boa.interpreter.boa.Project;
import boa.interpreter.boa.Seq;
import boa.interpreter.boa.Skip;
import boa.interpreter.boa.This;
import boa.interpreter.boa.Var;
import boa.interpreter.boa.With;
import java.lang.IllegalArgumentException;
import java.lang.String;
import java.util.Map;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

public class BoaFactoryImpl extends EFactoryImpl implements BoaFactory {
  public BoaFactoryImpl() {
  }

  public static BoaFactory init() {
    try {
    	BoaFactory theBoaFactory = (BoaFactory) EPackage.Registry.INSTANCE.getEFactory(BoaPackage.eNS_URI);
    	if (theBoaFactory != null) {
    		return theBoaFactory;
    	}
    } catch (Exception exception) {
    	EcorePlugin.INSTANCE.log(exception);
    }
    return new BoaFactoryImpl();
  }

  public EObject create(EClass eClass) {
    switch (eClass.getClassifierID()) {
    case BoaPackage.FILE:
    	return createFile();
    case BoaPackage.DEF:
    	return createDef();
    case BoaPackage.APP:
    	return createApp();
    case BoaPackage.VAR:
    	return createVar();
    case BoaPackage.THIS:
    	return createThis();
    case BoaPackage.BOOL:
    	return createBool();
    case BoaPackage.INT:
    	return createInt();
    case BoaPackage.SKIP:
    	return createSkip();
    case BoaPackage.PROJECT:
    	return createProject();
    case BoaPackage.BOBJECT:
    	return createBObject();
    case BoaPackage.FIELD:
    	return createField();
    case BoaPackage.COPY:
    	return createCopy();
    case BoaPackage.WITH:
    	return createWith();
    case BoaPackage.NOT:
    	return createNot();
    case BoaPackage.IF:
    	return createIf();
    case BoaPackage.LET:
    	return createLet();
    case BoaPackage.FUN:
    	return createFun();
    case BoaPackage.ASSIGN:
    	return createAssign();
    case BoaPackage.ARITH_OP_PLUS:
    	return createArithOpPlus();
    case BoaPackage.ARITH_OP_MINUS:
    	return createArithOpMinus();
    case BoaPackage.ARITH_OP_TIMES:
    	return createArithOpTimes();
    case BoaPackage.ARITH_OP_DIVIDE:
    	return createArithOpDivide();
    case BoaPackage.ARITH_OP_REMAINDER:
    	return createArithOpRemainder();
    case BoaPackage.BOOL_OP_AND:
    	return createBoolOpAnd();
    case BoaPackage.BOOL_OP_OR:
    	return createBoolOpOr();
    case BoaPackage.SEQ:
    	return createSeq();
    case BoaPackage.CMP_OP_EQUAL:
    	return createCmpOpEqual();
    case BoaPackage.CMP_OP_UNEQUAL:
    	return createCmpOpUnequal();
    case BoaPackage.CMP_OP_LESS:
    	return createCmpOpLess();
    case BoaPackage.CTX:
    	return createCtx();
    case BoaPackage.STRING_TO_EVAL_RES_MAP:
    	return (org.eclipse.emf.ecore.EObject) createStringToEvalResMap();
    case BoaPackage.EVAL_MAP_RES:
    	return createEvalMapRes();
    case BoaPackage.EVAL_FUN_RES:
    	return createEvalFunRes();
    case BoaPackage.EVAL_BOUND_FUN_RES:
    	return createEvalBoundFunRes();
    case BoaPackage.EVAL_INT_RES:
    	return createEvalIntRes();
    case BoaPackage.EVAL_BOOL_RES:
    	return createEvalBoolRes();
    default:
    	throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  public BoaPackage getBoaPackage() {
    return (BoaPackage)getEPackage();}

  public File createFile() {
    FileImpl ret = new FileImpl();
    return ret;
  }

  public Def createDef() {
    DefImpl ret = new DefImpl();
    return ret;
  }

  public App createApp() {
    AppImpl ret = new AppImpl();
    return ret;
  }

  public Var createVar() {
    VarImpl ret = new VarImpl();
    return ret;
  }

  public This createThis() {
    ThisImpl ret = new ThisImpl();
    return ret;
  }

  public Bool createBool() {
    BoolImpl ret = new BoolImpl();
    return ret;
  }

  public Int createInt() {
    IntImpl ret = new IntImpl();
    return ret;
  }

  public Skip createSkip() {
    SkipImpl ret = new SkipImpl();
    return ret;
  }

  public Project createProject() {
    ProjectImpl ret = new ProjectImpl();
    return ret;
  }

  public BObject createBObject() {
    BObjectImpl ret = new BObjectImpl();
    return ret;
  }

  public Field createField() {
    FieldImpl ret = new FieldImpl();
    return ret;
  }

  public Copy createCopy() {
    CopyImpl ret = new CopyImpl();
    return ret;
  }

  public With createWith() {
    WithImpl ret = new WithImpl();
    return ret;
  }

  public Not createNot() {
    NotImpl ret = new NotImpl();
    return ret;
  }

  public If createIf() {
    IfImpl ret = new IfImpl();
    return ret;
  }

  public Let createLet() {
    LetImpl ret = new LetImpl();
    return ret;
  }

  public Fun createFun() {
    FunImpl ret = new FunImpl();
    return ret;
  }

  public Assign createAssign() {
    AssignImpl ret = new AssignImpl();
    return ret;
  }

  public ArithOpPlus createArithOpPlus() {
    ArithOpPlusImpl ret = new ArithOpPlusImpl();
    return ret;
  }

  public ArithOpMinus createArithOpMinus() {
    ArithOpMinusImpl ret = new ArithOpMinusImpl();
    return ret;
  }

  public ArithOpTimes createArithOpTimes() {
    ArithOpTimesImpl ret = new ArithOpTimesImpl();
    return ret;
  }

  public ArithOpDivide createArithOpDivide() {
    ArithOpDivideImpl ret = new ArithOpDivideImpl();
    return ret;
  }

  public ArithOpRemainder createArithOpRemainder() {
    ArithOpRemainderImpl ret = new ArithOpRemainderImpl();
    return ret;
  }

  public BoolOpAnd createBoolOpAnd() {
    BoolOpAndImpl ret = new BoolOpAndImpl();
    return ret;
  }

  public BoolOpOr createBoolOpOr() {
    BoolOpOrImpl ret = new BoolOpOrImpl();
    return ret;
  }

  public Seq createSeq() {
    SeqImpl ret = new SeqImpl();
    return ret;
  }

  public CmpOpEqual createCmpOpEqual() {
    CmpOpEqualImpl ret = new CmpOpEqualImpl();
    return ret;
  }

  public CmpOpUnequal createCmpOpUnequal() {
    CmpOpUnequalImpl ret = new CmpOpUnequalImpl();
    return ret;
  }

  public CmpOpLess createCmpOpLess() {
    CmpOpLessImpl ret = new CmpOpLessImpl();
    return ret;
  }

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
