package visitor;

import boa.visitor.boa.App;
import boa.visitor.boa.ArithOpDivide;
import boa.visitor.boa.ArithOpMinus;
import boa.visitor.boa.ArithOpPlus;
import boa.visitor.boa.ArithOpRemainder;
import boa.visitor.boa.ArithOpTimes;
import boa.visitor.boa.Assign;
import boa.visitor.boa.BObject;
import boa.visitor.boa.Bool;
import boa.visitor.boa.BoolOpAnd;
import boa.visitor.boa.BoolOpOr;
import boa.visitor.boa.CmpOpEqual;
import boa.visitor.boa.CmpOpLess;
import boa.visitor.boa.CmpOpUnequal;
import boa.visitor.boa.Copy;
import boa.visitor.boa.Ctx;
import boa.visitor.boa.Def;
import boa.visitor.boa.EvalBoolRes;
import boa.visitor.boa.EvalBoundFunRes;
import boa.visitor.boa.EvalFunRes;
import boa.visitor.boa.EvalIntRes;
import boa.visitor.boa.EvalMapRes;
import boa.visitor.boa.Field;
import boa.visitor.boa.File;
import boa.visitor.boa.Fun;
import boa.visitor.boa.If;
import boa.visitor.boa.Int;
import boa.visitor.boa.Let;
import boa.visitor.boa.Not;
import boa.visitor.boa.Project;
import boa.visitor.boa.Seq;
import boa.visitor.boa.Skip;
import boa.visitor.boa.StringToEvalResMap;
import boa.visitor.boa.This;
import boa.visitor.boa.Var;
import boa.visitor.boa.With;
import visitor.operation.boa.AppOperation;
import visitor.operation.boa.ArithOpDivideOperation;
import visitor.operation.boa.ArithOpMinusOperation;
import visitor.operation.boa.ArithOpPlusOperation;
import visitor.operation.boa.ArithOpRemainderOperation;
import visitor.operation.boa.ArithOpTimesOperation;
import visitor.operation.boa.AssignOperation;
import visitor.operation.boa.BObjectOperation;
import visitor.operation.boa.BoolOpAndOperation;
import visitor.operation.boa.BoolOpOrOperation;
import visitor.operation.boa.BoolOperation;
import visitor.operation.boa.CmpOpEqualOperation;
import visitor.operation.boa.CmpOpLessOperation;
import visitor.operation.boa.CmpOpUnequalOperation;
import visitor.operation.boa.CopyOperation;
import visitor.operation.boa.CtxOperation;
import visitor.operation.boa.DefOperation;
import visitor.operation.boa.EvalBoolResOperation;
import visitor.operation.boa.EvalBoundFunResOperation;
import visitor.operation.boa.EvalFunResOperation;
import visitor.operation.boa.EvalIntResOperation;
import visitor.operation.boa.EvalMapResOperation;
import visitor.operation.boa.FieldOperation;
import visitor.operation.boa.FileOperation;
import visitor.operation.boa.FunOperation;
import visitor.operation.boa.IfOperation;
import visitor.operation.boa.IntOperation;
import visitor.operation.boa.LetOperation;
import visitor.operation.boa.NotOperation;
import visitor.operation.boa.ProjectOperation;
import visitor.operation.boa.SeqOperation;
import visitor.operation.boa.SkipOperation;
import visitor.operation.boa.StringToEvalResMapOperation;
import visitor.operation.boa.ThisOperation;
import visitor.operation.boa.VarOperation;
import visitor.operation.boa.WithOperation;
import visitor.operation.boa.impl.AppOperationImpl;
import visitor.operation.boa.impl.ArithOpDivideOperationImpl;
import visitor.operation.boa.impl.ArithOpMinusOperationImpl;
import visitor.operation.boa.impl.ArithOpPlusOperationImpl;
import visitor.operation.boa.impl.ArithOpRemainderOperationImpl;
import visitor.operation.boa.impl.ArithOpTimesOperationImpl;
import visitor.operation.boa.impl.AssignOperationImpl;
import visitor.operation.boa.impl.BObjectOperationImpl;
import visitor.operation.boa.impl.BoolOpAndOperationImpl;
import visitor.operation.boa.impl.BoolOpOrOperationImpl;
import visitor.operation.boa.impl.BoolOperationImpl;
import visitor.operation.boa.impl.CmpOpEqualOperationImpl;
import visitor.operation.boa.impl.CmpOpLessOperationImpl;
import visitor.operation.boa.impl.CmpOpUnequalOperationImpl;
import visitor.operation.boa.impl.CopyOperationImpl;
import visitor.operation.boa.impl.CtxOperationImpl;
import visitor.operation.boa.impl.DefOperationImpl;
import visitor.operation.boa.impl.EvalBoolResOperationImpl;
import visitor.operation.boa.impl.EvalBoundFunResOperationImpl;
import visitor.operation.boa.impl.EvalFunResOperationImpl;
import visitor.operation.boa.impl.EvalIntResOperationImpl;
import visitor.operation.boa.impl.EvalMapResOperationImpl;
import visitor.operation.boa.impl.FieldOperationImpl;
import visitor.operation.boa.impl.FileOperationImpl;
import visitor.operation.boa.impl.FunOperationImpl;
import visitor.operation.boa.impl.IfOperationImpl;
import visitor.operation.boa.impl.IntOperationImpl;
import visitor.operation.boa.impl.LetOperationImpl;
import visitor.operation.boa.impl.NotOperationImpl;
import visitor.operation.boa.impl.ProjectOperationImpl;
import visitor.operation.boa.impl.SeqOperationImpl;
import visitor.operation.boa.impl.SkipOperationImpl;
import visitor.operation.boa.impl.StringToEvalResMapOperationImpl;
import visitor.operation.boa.impl.ThisOperationImpl;
import visitor.operation.boa.impl.VarOperationImpl;
import visitor.operation.boa.impl.WithOperationImpl;

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
