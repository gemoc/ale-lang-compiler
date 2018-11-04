package visitor.visitor;

import visitor.boa.visitor.boa.App;
import visitor.boa.visitor.boa.ArithOpDivide;
import visitor.boa.visitor.boa.ArithOpMinus;
import visitor.boa.visitor.boa.ArithOpPlus;
import visitor.boa.visitor.boa.ArithOpRemainder;
import visitor.boa.visitor.boa.ArithOpTimes;
import visitor.boa.visitor.boa.Assign;
import visitor.boa.visitor.boa.BObject;
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
import visitor.boa.visitor.boa.StringToEvalResMap;
import visitor.boa.visitor.boa.This;
import visitor.boa.visitor.boa.Var;
import visitor.boa.visitor.boa.With;
import visitor.visitor.operation.boa.AppOperation;
import visitor.visitor.operation.boa.ArithOpDivideOperation;
import visitor.visitor.operation.boa.ArithOpMinusOperation;
import visitor.visitor.operation.boa.ArithOpPlusOperation;
import visitor.visitor.operation.boa.ArithOpRemainderOperation;
import visitor.visitor.operation.boa.ArithOpTimesOperation;
import visitor.visitor.operation.boa.AssignOperation;
import visitor.visitor.operation.boa.BObjectOperation;
import visitor.visitor.operation.boa.BoolOpAndOperation;
import visitor.visitor.operation.boa.BoolOpOrOperation;
import visitor.visitor.operation.boa.BoolOperation;
import visitor.visitor.operation.boa.CmpOpEqualOperation;
import visitor.visitor.operation.boa.CmpOpLessOperation;
import visitor.visitor.operation.boa.CmpOpUnequalOperation;
import visitor.visitor.operation.boa.CopyOperation;
import visitor.visitor.operation.boa.CtxOperation;
import visitor.visitor.operation.boa.DefOperation;
import visitor.visitor.operation.boa.EvalBoolResOperation;
import visitor.visitor.operation.boa.EvalBoundFunResOperation;
import visitor.visitor.operation.boa.EvalFunResOperation;
import visitor.visitor.operation.boa.EvalIntResOperation;
import visitor.visitor.operation.boa.EvalMapResOperation;
import visitor.visitor.operation.boa.FieldOperation;
import visitor.visitor.operation.boa.FileOperation;
import visitor.visitor.operation.boa.FunOperation;
import visitor.visitor.operation.boa.IfOperation;
import visitor.visitor.operation.boa.IntOperation;
import visitor.visitor.operation.boa.LetOperation;
import visitor.visitor.operation.boa.NotOperation;
import visitor.visitor.operation.boa.ProjectOperation;
import visitor.visitor.operation.boa.SeqOperation;
import visitor.visitor.operation.boa.SkipOperation;
import visitor.visitor.operation.boa.StringToEvalResMapOperation;
import visitor.visitor.operation.boa.ThisOperation;
import visitor.visitor.operation.boa.VarOperation;
import visitor.visitor.operation.boa.WithOperation;
import visitor.visitor.operation.boa.impl.AppOperationImpl;
import visitor.visitor.operation.boa.impl.ArithOpDivideOperationImpl;
import visitor.visitor.operation.boa.impl.ArithOpMinusOperationImpl;
import visitor.visitor.operation.boa.impl.ArithOpPlusOperationImpl;
import visitor.visitor.operation.boa.impl.ArithOpRemainderOperationImpl;
import visitor.visitor.operation.boa.impl.ArithOpTimesOperationImpl;
import visitor.visitor.operation.boa.impl.AssignOperationImpl;
import visitor.visitor.operation.boa.impl.BObjectOperationImpl;
import visitor.visitor.operation.boa.impl.BoolOpAndOperationImpl;
import visitor.visitor.operation.boa.impl.BoolOpOrOperationImpl;
import visitor.visitor.operation.boa.impl.BoolOperationImpl;
import visitor.visitor.operation.boa.impl.CmpOpEqualOperationImpl;
import visitor.visitor.operation.boa.impl.CmpOpLessOperationImpl;
import visitor.visitor.operation.boa.impl.CmpOpUnequalOperationImpl;
import visitor.visitor.operation.boa.impl.CopyOperationImpl;
import visitor.visitor.operation.boa.impl.CtxOperationImpl;
import visitor.visitor.operation.boa.impl.DefOperationImpl;
import visitor.visitor.operation.boa.impl.EvalBoolResOperationImpl;
import visitor.visitor.operation.boa.impl.EvalBoundFunResOperationImpl;
import visitor.visitor.operation.boa.impl.EvalFunResOperationImpl;
import visitor.visitor.operation.boa.impl.EvalIntResOperationImpl;
import visitor.visitor.operation.boa.impl.EvalMapResOperationImpl;
import visitor.visitor.operation.boa.impl.FieldOperationImpl;
import visitor.visitor.operation.boa.impl.FileOperationImpl;
import visitor.visitor.operation.boa.impl.FunOperationImpl;
import visitor.visitor.operation.boa.impl.IfOperationImpl;
import visitor.visitor.operation.boa.impl.IntOperationImpl;
import visitor.visitor.operation.boa.impl.LetOperationImpl;
import visitor.visitor.operation.boa.impl.NotOperationImpl;
import visitor.visitor.operation.boa.impl.ProjectOperationImpl;
import visitor.visitor.operation.boa.impl.SeqOperationImpl;
import visitor.visitor.operation.boa.impl.SkipOperationImpl;
import visitor.visitor.operation.boa.impl.StringToEvalResMapOperationImpl;
import visitor.visitor.operation.boa.impl.ThisOperationImpl;
import visitor.visitor.operation.boa.impl.VarOperationImpl;
import visitor.visitor.operation.boa.impl.WithOperationImpl;

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
