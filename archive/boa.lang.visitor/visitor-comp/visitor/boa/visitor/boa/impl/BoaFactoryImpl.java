package visitor.boa.visitor.boa.impl;

import java.lang.IllegalArgumentException;
import java.lang.String;
import java.util.Map;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import visitor.boa.visitor.boa.App;
import visitor.boa.visitor.boa.ArithOpDivide;
import visitor.boa.visitor.boa.ArithOpMinus;
import visitor.boa.visitor.boa.ArithOpPlus;
import visitor.boa.visitor.boa.ArithOpRemainder;
import visitor.boa.visitor.boa.ArithOpTimes;
import visitor.boa.visitor.boa.Assign;
import visitor.boa.visitor.boa.BObject;
import visitor.boa.visitor.boa.BoaFactory;
import visitor.boa.visitor.boa.BoaPackage;
import visitor.boa.visitor.boa.Bool;
import visitor.boa.visitor.boa.BoolOpAnd;
import visitor.boa.visitor.boa.BoolOpOr;
import visitor.boa.visitor.boa.CmpOpEqual;
import visitor.boa.visitor.boa.CmpOpLess;
import visitor.boa.visitor.boa.CmpOpUnequal;
import visitor.boa.visitor.boa.Copy;
import visitor.boa.visitor.boa.Ctx;
import visitor.boa.visitor.boa.Def;
import visitor.boa.visitor.boa.EvalBoolRes;
import visitor.boa.visitor.boa.EvalBoundFunRes;
import visitor.boa.visitor.boa.EvalFunRes;
import visitor.boa.visitor.boa.EvalIntRes;
import visitor.boa.visitor.boa.EvalMapRes;
import visitor.boa.visitor.boa.EvalRes;
import visitor.boa.visitor.boa.Field;
import visitor.boa.visitor.boa.File;
import visitor.boa.visitor.boa.Fun;
import visitor.boa.visitor.boa.If;
import visitor.boa.visitor.boa.Int;
import visitor.boa.visitor.boa.Let;
import visitor.boa.visitor.boa.Not;
import visitor.boa.visitor.boa.Project;
import visitor.boa.visitor.boa.Seq;
import visitor.boa.visitor.boa.Skip;
import visitor.boa.visitor.boa.This;
import visitor.boa.visitor.boa.Var;
import visitor.boa.visitor.boa.With;

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
