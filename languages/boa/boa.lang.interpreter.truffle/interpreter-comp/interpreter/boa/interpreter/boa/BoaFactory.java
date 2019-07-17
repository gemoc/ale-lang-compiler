package interpreter.boa.interpreter.boa;

import interpreter.boa.interpreter.boa.impl.AppImpl;
import interpreter.boa.interpreter.boa.impl.ArithOpDivideImpl;
import interpreter.boa.interpreter.boa.impl.ArithOpMinusImpl;
import interpreter.boa.interpreter.boa.impl.ArithOpPlusImpl;
import interpreter.boa.interpreter.boa.impl.ArithOpRemainderImpl;
import interpreter.boa.interpreter.boa.impl.ArithOpTimesImpl;
import interpreter.boa.interpreter.boa.impl.AssignImpl;
import interpreter.boa.interpreter.boa.impl.BObjectImpl;
import interpreter.boa.interpreter.boa.impl.BoaFactoryImpl;
import interpreter.boa.interpreter.boa.impl.BoolImpl;
import interpreter.boa.interpreter.boa.impl.BoolOpAndImpl;
import interpreter.boa.interpreter.boa.impl.BoolOpOrImpl;
import interpreter.boa.interpreter.boa.impl.CmpOpEqualImpl;
import interpreter.boa.interpreter.boa.impl.CmpOpLessImpl;
import interpreter.boa.interpreter.boa.impl.CmpOpUnequalImpl;
import interpreter.boa.interpreter.boa.impl.CopyImpl;
import interpreter.boa.interpreter.boa.impl.CtxImpl;
import interpreter.boa.interpreter.boa.impl.DefImpl;
import interpreter.boa.interpreter.boa.impl.EvalBoolResImpl;
import interpreter.boa.interpreter.boa.impl.EvalBoundFunResImpl;
import interpreter.boa.interpreter.boa.impl.EvalFunResImpl;
import interpreter.boa.interpreter.boa.impl.EvalIntResImpl;
import interpreter.boa.interpreter.boa.impl.EvalMapResImpl;
import interpreter.boa.interpreter.boa.impl.FieldImpl;
import interpreter.boa.interpreter.boa.impl.FileImpl;
import interpreter.boa.interpreter.boa.impl.FunImpl;
import interpreter.boa.interpreter.boa.impl.IfImpl;
import interpreter.boa.interpreter.boa.impl.IntImpl;
import interpreter.boa.interpreter.boa.impl.LetImpl;
import interpreter.boa.interpreter.boa.impl.NotImpl;
import interpreter.boa.interpreter.boa.impl.ProjectImpl;
import interpreter.boa.interpreter.boa.impl.SeqImpl;
import interpreter.boa.interpreter.boa.impl.SkipImpl;
import interpreter.boa.interpreter.boa.impl.ThisImpl;
import interpreter.boa.interpreter.boa.impl.VarImpl;
import interpreter.boa.interpreter.boa.impl.WithImpl;
import org.eclipse.emf.ecore.EFactory;

public interface BoaFactory extends EFactory {
	BoaFactory eINSTANCE = BoaFactoryImpl.init();

	FileImpl createFile();

	DefImpl createDef();

	AppImpl createApp();

	VarImpl createVar();

	ThisImpl createThis();

	BoolImpl createBool();

	IntImpl createInt();

	SkipImpl createSkip();

	ProjectImpl createProject();

	BObjectImpl createBObject();

	FieldImpl createField();

	CopyImpl createCopy();

	WithImpl createWith();

	NotImpl createNot();

	IfImpl createIf();

	LetImpl createLet();

	FunImpl createFun();

	AssignImpl createAssign();

	ArithOpPlusImpl createArithOpPlus();

	ArithOpMinusImpl createArithOpMinus();

	ArithOpTimesImpl createArithOpTimes();

	ArithOpDivideImpl createArithOpDivide();

	ArithOpRemainderImpl createArithOpRemainder();

	BoolOpAndImpl createBoolOpAnd();

	BoolOpOrImpl createBoolOpOr();

	SeqImpl createSeq();

	CmpOpEqualImpl createCmpOpEqual();

	CmpOpUnequalImpl createCmpOpUnequal();

	CmpOpLessImpl createCmpOpLess();

	CtxImpl createCtx();

	EvalMapResImpl createEvalMapRes();

	EvalFunResImpl createEvalFunRes();

	EvalBoundFunResImpl createEvalBoundFunRes();

	EvalIntResImpl createEvalIntRes();

	EvalBoolResImpl createEvalBoolRes();

	BoaPackage getBoaPackage();
}
