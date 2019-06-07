package interpreter.boa.interpreter.boa.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import interpreter.boa.interpreter.boa.App;
import interpreter.boa.interpreter.boa.ArithOpDivide;
import interpreter.boa.interpreter.boa.ArithOpMinus;
import interpreter.boa.interpreter.boa.ArithOpPlus;
import interpreter.boa.interpreter.boa.ArithOpRemainder;
import interpreter.boa.interpreter.boa.ArithOpTimes;
import interpreter.boa.interpreter.boa.Assign;
import interpreter.boa.interpreter.boa.BObject;
import interpreter.boa.interpreter.boa.BoaFactory;
import interpreter.boa.interpreter.boa.BoaPackage;
import interpreter.boa.interpreter.boa.Bool;
import interpreter.boa.interpreter.boa.BoolOpAnd;
import interpreter.boa.interpreter.boa.BoolOpOr;
import interpreter.boa.interpreter.boa.CmpOpEqual;
import interpreter.boa.interpreter.boa.CmpOpLess;
import interpreter.boa.interpreter.boa.CmpOpUnequal;
import interpreter.boa.interpreter.boa.Copy;
import interpreter.boa.interpreter.boa.Ctx;
import interpreter.boa.interpreter.boa.Def;
import interpreter.boa.interpreter.boa.EvalBoolRes;
import interpreter.boa.interpreter.boa.EvalBoundFunRes;
import interpreter.boa.interpreter.boa.EvalFunRes;
import interpreter.boa.interpreter.boa.EvalIntRes;
import interpreter.boa.interpreter.boa.EvalMapRes;
import interpreter.boa.interpreter.boa.EvalRes;
import interpreter.boa.interpreter.boa.Field;
import interpreter.boa.interpreter.boa.File;
import interpreter.boa.interpreter.boa.Fun;
import interpreter.boa.interpreter.boa.If;
import interpreter.boa.interpreter.boa.Int;
import interpreter.boa.interpreter.boa.Let;
import interpreter.boa.interpreter.boa.Not;
import interpreter.boa.interpreter.boa.Project;
import interpreter.boa.interpreter.boa.Seq;
import interpreter.boa.interpreter.boa.Skip;
import interpreter.boa.interpreter.boa.This;
import interpreter.boa.interpreter.boa.Var;
import interpreter.boa.interpreter.boa.With;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Override;
import java.lang.String;
import java.util.Map;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

public class BoaFactoryImpl extends EFactoryImpl implements BoaFactory {
	public BoaFactoryImpl() {
		super();
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

	@Override
	@TruffleBoundary
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case BoaPackage.FILE :
				return createFile();
			case BoaPackage.DEF :
				return createDef();
			case BoaPackage.APP :
				return createApp();
			case BoaPackage.VAR :
				return createVar();
			case BoaPackage.THIS :
				return createThis();
			case BoaPackage.BOOL :
				return createBool();
			case BoaPackage.INT :
				return createInt();
			case BoaPackage.SKIP :
				return createSkip();
			case BoaPackage.PROJECT :
				return createProject();
			case BoaPackage.BOBJECT :
				return createBObject();
			case BoaPackage.FIELD :
				return createField();
			case BoaPackage.COPY :
				return createCopy();
			case BoaPackage.WITH :
				return createWith();
			case BoaPackage.NOT :
				return createNot();
			case BoaPackage.IF :
				return createIf();
			case BoaPackage.LET :
				return createLet();
			case BoaPackage.FUN :
				return createFun();
			case BoaPackage.ASSIGN :
				return createAssign();
			case BoaPackage.ARITH_OP_PLUS :
				return createArithOpPlus();
			case BoaPackage.ARITH_OP_MINUS :
				return createArithOpMinus();
			case BoaPackage.ARITH_OP_TIMES :
				return createArithOpTimes();
			case BoaPackage.ARITH_OP_DIVIDE :
				return createArithOpDivide();
			case BoaPackage.ARITH_OP_REMAINDER :
				return createArithOpRemainder();
			case BoaPackage.BOOL_OP_AND :
				return createBoolOpAnd();
			case BoaPackage.BOOL_OP_OR :
				return createBoolOpOr();
			case BoaPackage.SEQ :
				return createSeq();
			case BoaPackage.CMP_OP_EQUAL :
				return createCmpOpEqual();
			case BoaPackage.CMP_OP_UNEQUAL :
				return createCmpOpUnequal();
			case BoaPackage.CMP_OP_LESS :
				return createCmpOpLess();
			case BoaPackage.CTX :
				return createCtx();
			case BoaPackage.STRING_TO_EVAL_RES_MAP :
				return (EObject) createStringToEvalResMap();
			case BoaPackage.EVAL_MAP_RES :
				return createEvalMapRes();
			case BoaPackage.EVAL_FUN_RES :
				return createEvalFunRes();
			case BoaPackage.EVAL_BOUND_FUN_RES :
				return createEvalBoundFunRes();
			case BoaPackage.EVAL_INT_RES :
				return createEvalIntRes();
			case BoaPackage.EVAL_BOOL_RES :
				return createEvalBoolRes();
			default :
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	@TruffleBoundary
	public File createFile() {
		FileImpl file = new FileImpl();
		return file;
	}

	@TruffleBoundary
	public Def createDef() {
		DefImpl def = new DefImpl();
		return def;
	}

	@TruffleBoundary
	public App createApp() {
		AppImpl app = new AppImpl();
		return app;
	}

	@TruffleBoundary
	public Var createVar() {
		VarImpl var = new VarImpl();
		return var;
	}

	@TruffleBoundary
	public This createThis() {
		ThisImpl this_ = new ThisImpl();
		return this_;
	}

	@TruffleBoundary
	public Bool createBool() {
		BoolImpl bool = new BoolImpl();
		return bool;
	}

	@TruffleBoundary
	public Int createInt() {
		IntImpl int_ = new IntImpl();
		return int_;
	}

	@TruffleBoundary
	public Skip createSkip() {
		SkipImpl skip = new SkipImpl();
		return skip;
	}

	@TruffleBoundary
	public Project createProject() {
		ProjectImpl project = new ProjectImpl();
		return project;
	}

	@TruffleBoundary
	public BObject createBObject() {
		BObjectImpl bObject = new BObjectImpl();
		return bObject;
	}

	@TruffleBoundary
	public Field createField() {
		FieldImpl field = new FieldImpl();
		return field;
	}

	@TruffleBoundary
	public Copy createCopy() {
		CopyImpl copy = new CopyImpl();
		return copy;
	}

	@TruffleBoundary
	public With createWith() {
		WithImpl with = new WithImpl();
		return with;
	}

	@TruffleBoundary
	public Not createNot() {
		NotImpl not = new NotImpl();
		return not;
	}

	@TruffleBoundary
	public If createIf() {
		IfImpl if_ = new IfImpl();
		return if_;
	}

	@TruffleBoundary
	public Let createLet() {
		LetImpl let = new LetImpl();
		return let;
	}

	@TruffleBoundary
	public Fun createFun() {
		FunImpl fun = new FunImpl();
		return fun;
	}

	@TruffleBoundary
	public Assign createAssign() {
		AssignImpl assign = new AssignImpl();
		return assign;
	}

	@TruffleBoundary
	public ArithOpPlus createArithOpPlus() {
		ArithOpPlusImpl arithOpPlus = new ArithOpPlusImpl();
		return arithOpPlus;
	}

	@TruffleBoundary
	public ArithOpMinus createArithOpMinus() {
		ArithOpMinusImpl arithOpMinus = new ArithOpMinusImpl();
		return arithOpMinus;
	}

	@TruffleBoundary
	public ArithOpTimes createArithOpTimes() {
		ArithOpTimesImpl arithOpTimes = new ArithOpTimesImpl();
		return arithOpTimes;
	}

	@TruffleBoundary
	public ArithOpDivide createArithOpDivide() {
		ArithOpDivideImpl arithOpDivide = new ArithOpDivideImpl();
		return arithOpDivide;
	}

	@TruffleBoundary
	public ArithOpRemainder createArithOpRemainder() {
		ArithOpRemainderImpl arithOpRemainder = new ArithOpRemainderImpl();
		return arithOpRemainder;
	}

	@TruffleBoundary
	public BoolOpAnd createBoolOpAnd() {
		BoolOpAndImpl boolOpAnd = new BoolOpAndImpl();
		return boolOpAnd;
	}

	@TruffleBoundary
	public BoolOpOr createBoolOpOr() {
		BoolOpOrImpl boolOpOr = new BoolOpOrImpl();
		return boolOpOr;
	}

	@TruffleBoundary
	public Seq createSeq() {
		SeqImpl seq = new SeqImpl();
		return seq;
	}

	@TruffleBoundary
	public CmpOpEqual createCmpOpEqual() {
		CmpOpEqualImpl cmpOpEqual = new CmpOpEqualImpl();
		return cmpOpEqual;
	}

	@TruffleBoundary
	public CmpOpUnequal createCmpOpUnequal() {
		CmpOpUnequalImpl cmpOpUnequal = new CmpOpUnequalImpl();
		return cmpOpUnequal;
	}

	@TruffleBoundary
	public CmpOpLess createCmpOpLess() {
		CmpOpLessImpl cmpOpLess = new CmpOpLessImpl();
		return cmpOpLess;
	}

	@TruffleBoundary
	public Ctx createCtx() {
		CtxImpl ctx = new CtxImpl();
		return ctx;
	}

	@TruffleBoundary
	public Map.Entry<String, EvalRes> createStringToEvalResMap() {
		StringToEvalResMapImpl stringToEvalResMap = new StringToEvalResMapImpl();
		return stringToEvalResMap;
	}

	@TruffleBoundary
	public EvalMapRes createEvalMapRes() {
		EvalMapResImpl evalMapRes = new EvalMapResImpl();
		return evalMapRes;
	}

	@TruffleBoundary
	public EvalFunRes createEvalFunRes() {
		EvalFunResImpl evalFunRes = new EvalFunResImpl();
		return evalFunRes;
	}

	@TruffleBoundary
	public EvalBoundFunRes createEvalBoundFunRes() {
		EvalBoundFunResImpl evalBoundFunRes = new EvalBoundFunResImpl();
		return evalBoundFunRes;
	}

	@TruffleBoundary
	public EvalIntRes createEvalIntRes() {
		EvalIntResImpl evalIntRes = new EvalIntResImpl();
		return evalIntRes;
	}

	@TruffleBoundary
	public EvalBoolRes createEvalBoolRes() {
		EvalBoolResImpl evalBoolRes = new EvalBoolResImpl();
		return evalBoolRes;
	}

	public BoaPackage getBoaPackage() {
		return (BoaPackage) getEPackage();
	}

	@Deprecated
	public static BoaPackage getPackage() {
		return BoaPackage.eINSTANCE;
	}
}
