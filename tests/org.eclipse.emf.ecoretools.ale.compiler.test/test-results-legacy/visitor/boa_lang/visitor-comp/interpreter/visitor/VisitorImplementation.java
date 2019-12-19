package interpreter.visitor;

import interpreter.boa.visitor.boa.App;
import interpreter.boa.visitor.boa.ArithOpDivide;
import interpreter.boa.visitor.boa.ArithOpMinus;
import interpreter.boa.visitor.boa.ArithOpPlus;
import interpreter.boa.visitor.boa.ArithOpRemainder;
import interpreter.boa.visitor.boa.ArithOpTimes;
import interpreter.boa.visitor.boa.Assign;
import interpreter.boa.visitor.boa.BObject;
import interpreter.boa.visitor.boa.Bool;
import interpreter.boa.visitor.boa.BoolOpAnd;
import interpreter.boa.visitor.boa.BoolOpOr;
import interpreter.boa.visitor.boa.CmpOpEqual;
import interpreter.boa.visitor.boa.CmpOpLess;
import interpreter.boa.visitor.boa.CmpOpUnequal;
import interpreter.boa.visitor.boa.Copy;
import interpreter.boa.visitor.boa.Ctx;
import interpreter.boa.visitor.boa.Def;
import interpreter.boa.visitor.boa.EvalBoolRes;
import interpreter.boa.visitor.boa.EvalBoundFunRes;
import interpreter.boa.visitor.boa.EvalFunRes;
import interpreter.boa.visitor.boa.EvalIntRes;
import interpreter.boa.visitor.boa.EvalMapRes;
import interpreter.boa.visitor.boa.Field;
import interpreter.boa.visitor.boa.File;
import interpreter.boa.visitor.boa.Fun;
import interpreter.boa.visitor.boa.If;
import interpreter.boa.visitor.boa.Int;
import interpreter.boa.visitor.boa.Let;
import interpreter.boa.visitor.boa.Not;
import interpreter.boa.visitor.boa.Project;
import interpreter.boa.visitor.boa.Seq;
import interpreter.boa.visitor.boa.Skip;
import interpreter.boa.visitor.boa.StringToEvalResMap;
import interpreter.boa.visitor.boa.This;
import interpreter.boa.visitor.boa.Var;
import interpreter.boa.visitor.boa.With;
import interpreter.visitor.operation.boa.AppOperation;
import interpreter.visitor.operation.boa.ArithOpDivideOperation;
import interpreter.visitor.operation.boa.ArithOpMinusOperation;
import interpreter.visitor.operation.boa.ArithOpPlusOperation;
import interpreter.visitor.operation.boa.ArithOpRemainderOperation;
import interpreter.visitor.operation.boa.ArithOpTimesOperation;
import interpreter.visitor.operation.boa.AssignOperation;
import interpreter.visitor.operation.boa.BObjectOperation;
import interpreter.visitor.operation.boa.BoolOpAndOperation;
import interpreter.visitor.operation.boa.BoolOpOrOperation;
import interpreter.visitor.operation.boa.BoolOperation;
import interpreter.visitor.operation.boa.CmpOpEqualOperation;
import interpreter.visitor.operation.boa.CmpOpLessOperation;
import interpreter.visitor.operation.boa.CmpOpUnequalOperation;
import interpreter.visitor.operation.boa.CopyOperation;
import interpreter.visitor.operation.boa.CtxOperation;
import interpreter.visitor.operation.boa.DefOperation;
import interpreter.visitor.operation.boa.EvalBoolResOperation;
import interpreter.visitor.operation.boa.EvalBoundFunResOperation;
import interpreter.visitor.operation.boa.EvalFunResOperation;
import interpreter.visitor.operation.boa.EvalIntResOperation;
import interpreter.visitor.operation.boa.EvalMapResOperation;
import interpreter.visitor.operation.boa.FieldOperation;
import interpreter.visitor.operation.boa.FileOperation;
import interpreter.visitor.operation.boa.FunOperation;
import interpreter.visitor.operation.boa.IfOperation;
import interpreter.visitor.operation.boa.IntOperation;
import interpreter.visitor.operation.boa.LetOperation;
import interpreter.visitor.operation.boa.NotOperation;
import interpreter.visitor.operation.boa.ProjectOperation;
import interpreter.visitor.operation.boa.SeqOperation;
import interpreter.visitor.operation.boa.SkipOperation;
import interpreter.visitor.operation.boa.StringToEvalResMapOperation;
import interpreter.visitor.operation.boa.ThisOperation;
import interpreter.visitor.operation.boa.VarOperation;
import interpreter.visitor.operation.boa.WithOperation;
import interpreter.visitor.operation.boa.impl.AppOperationImpl;
import interpreter.visitor.operation.boa.impl.ArithOpDivideOperationImpl;
import interpreter.visitor.operation.boa.impl.ArithOpMinusOperationImpl;
import interpreter.visitor.operation.boa.impl.ArithOpPlusOperationImpl;
import interpreter.visitor.operation.boa.impl.ArithOpRemainderOperationImpl;
import interpreter.visitor.operation.boa.impl.ArithOpTimesOperationImpl;
import interpreter.visitor.operation.boa.impl.AssignOperationImpl;
import interpreter.visitor.operation.boa.impl.BObjectOperationImpl;
import interpreter.visitor.operation.boa.impl.BoolOpAndOperationImpl;
import interpreter.visitor.operation.boa.impl.BoolOpOrOperationImpl;
import interpreter.visitor.operation.boa.impl.BoolOperationImpl;
import interpreter.visitor.operation.boa.impl.CmpOpEqualOperationImpl;
import interpreter.visitor.operation.boa.impl.CmpOpLessOperationImpl;
import interpreter.visitor.operation.boa.impl.CmpOpUnequalOperationImpl;
import interpreter.visitor.operation.boa.impl.CopyOperationImpl;
import interpreter.visitor.operation.boa.impl.CtxOperationImpl;
import interpreter.visitor.operation.boa.impl.DefOperationImpl;
import interpreter.visitor.operation.boa.impl.EvalBoolResOperationImpl;
import interpreter.visitor.operation.boa.impl.EvalBoundFunResOperationImpl;
import interpreter.visitor.operation.boa.impl.EvalFunResOperationImpl;
import interpreter.visitor.operation.boa.impl.EvalIntResOperationImpl;
import interpreter.visitor.operation.boa.impl.EvalMapResOperationImpl;
import interpreter.visitor.operation.boa.impl.FieldOperationImpl;
import interpreter.visitor.operation.boa.impl.FileOperationImpl;
import interpreter.visitor.operation.boa.impl.FunOperationImpl;
import interpreter.visitor.operation.boa.impl.IfOperationImpl;
import interpreter.visitor.operation.boa.impl.IntOperationImpl;
import interpreter.visitor.operation.boa.impl.LetOperationImpl;
import interpreter.visitor.operation.boa.impl.NotOperationImpl;
import interpreter.visitor.operation.boa.impl.ProjectOperationImpl;
import interpreter.visitor.operation.boa.impl.SeqOperationImpl;
import interpreter.visitor.operation.boa.impl.SkipOperationImpl;
import interpreter.visitor.operation.boa.impl.StringToEvalResMapOperationImpl;
import interpreter.visitor.operation.boa.impl.ThisOperationImpl;
import interpreter.visitor.operation.boa.impl.VarOperationImpl;
import interpreter.visitor.operation.boa.impl.WithOperationImpl;

public class VisitorImplementation implements VisitorInterface {
	public FileOperation visitboa__File(File it) {
		return new FileOperationImpl(it, this);
	}

	public DefOperation visitboa__Def(Def it) {
		return new DefOperationImpl(it, this);
	}

	public AppOperation visitboa__App(App it) {
		return new AppOperationImpl(it, this);
	}

	public VarOperation visitboa__Var(Var it) {
		return new VarOperationImpl(it, this);
	}

	public ThisOperation visitboa__This(This it) {
		return new ThisOperationImpl(it, this);
	}

	public BoolOperation visitboa__Bool(Bool it) {
		return new BoolOperationImpl(it, this);
	}

	public IntOperation visitboa__Int(Int it) {
		return new IntOperationImpl(it, this);
	}

	public SkipOperation visitboa__Skip(Skip it) {
		return new SkipOperationImpl(it, this);
	}

	public ProjectOperation visitboa__Project(Project it) {
		return new ProjectOperationImpl(it, this);
	}

	public BObjectOperation visitboa__BObject(BObject it) {
		return new BObjectOperationImpl(it, this);
	}

	public FieldOperation visitboa__Field(Field it) {
		return new FieldOperationImpl(it, this);
	}

	public CopyOperation visitboa__Copy(Copy it) {
		return new CopyOperationImpl(it, this);
	}

	public WithOperation visitboa__With(With it) {
		return new WithOperationImpl(it, this);
	}

	public NotOperation visitboa__Not(Not it) {
		return new NotOperationImpl(it, this);
	}

	public IfOperation visitboa__If(If it) {
		return new IfOperationImpl(it, this);
	}

	public LetOperation visitboa__Let(Let it) {
		return new LetOperationImpl(it, this);
	}

	public FunOperation visitboa__Fun(Fun it) {
		return new FunOperationImpl(it, this);
	}

	public AssignOperation visitboa__Assign(Assign it) {
		return new AssignOperationImpl(it, this);
	}

	public ArithOpPlusOperation visitboa__ArithOpPlus(ArithOpPlus it) {
		return new ArithOpPlusOperationImpl(it, this);
	}

	public ArithOpMinusOperation visitboa__ArithOpMinus(ArithOpMinus it) {
		return new ArithOpMinusOperationImpl(it, this);
	}

	public ArithOpTimesOperation visitboa__ArithOpTimes(ArithOpTimes it) {
		return new ArithOpTimesOperationImpl(it, this);
	}

	public ArithOpDivideOperation visitboa__ArithOpDivide(ArithOpDivide it) {
		return new ArithOpDivideOperationImpl(it, this);
	}

	public ArithOpRemainderOperation visitboa__ArithOpRemainder(ArithOpRemainder it) {
		return new ArithOpRemainderOperationImpl(it, this);
	}

	public BoolOpAndOperation visitboa__BoolOpAnd(BoolOpAnd it) {
		return new BoolOpAndOperationImpl(it, this);
	}

	public BoolOpOrOperation visitboa__BoolOpOr(BoolOpOr it) {
		return new BoolOpOrOperationImpl(it, this);
	}

	public SeqOperation visitboa__Seq(Seq it) {
		return new SeqOperationImpl(it, this);
	}

	public CmpOpEqualOperation visitboa__CmpOpEqual(CmpOpEqual it) {
		return new CmpOpEqualOperationImpl(it, this);
	}

	public CmpOpUnequalOperation visitboa__CmpOpUnequal(CmpOpUnequal it) {
		return new CmpOpUnequalOperationImpl(it, this);
	}

	public CmpOpLessOperation visitboa__CmpOpLess(CmpOpLess it) {
		return new CmpOpLessOperationImpl(it, this);
	}

	public CtxOperation visitboa__Ctx(Ctx it) {
		return new CtxOperationImpl(it, this);
	}

	public StringToEvalResMapOperation visitboa__StringToEvalResMap(StringToEvalResMap it) {
		return new StringToEvalResMapOperationImpl(it, this);
	}

	public EvalMapResOperation visitboa__EvalMapRes(EvalMapRes it) {
		return new EvalMapResOperationImpl(it, this);
	}

	public EvalFunResOperation visitboa__EvalFunRes(EvalFunRes it) {
		return new EvalFunResOperationImpl(it, this);
	}

	public EvalBoundFunResOperation visitboa__EvalBoundFunRes(EvalBoundFunRes it) {
		return new EvalBoundFunResOperationImpl(it, this);
	}

	public EvalIntResOperation visitboa__EvalIntRes(EvalIntRes it) {
		return new EvalIntResOperationImpl(it, this);
	}

	public EvalBoolResOperation visitboa__EvalBoolRes(EvalBoolRes it) {
		return new EvalBoolResOperationImpl(it, this);
	}
}
