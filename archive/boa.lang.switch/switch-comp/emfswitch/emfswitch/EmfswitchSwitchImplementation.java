package emfswitch.emfswitch;

import boa.App;
import boa.ArithOp;
import boa.ArithOpDivide;
import boa.ArithOpMinus;
import boa.ArithOpPlus;
import boa.ArithOpRemainder;
import boa.ArithOpTimes;
import boa.Assign;
import boa.BObject;
import boa.Bool;
import boa.BoolOp;
import boa.BoolOpAnd;
import boa.BoolOpOr;
import boa.CmpOp;
import boa.CmpOpEqual;
import boa.CmpOpLess;
import boa.CmpOpUnequal;
import boa.Copy;
import boa.Ctx;
import boa.Def;
import boa.EvalBoolRes;
import boa.EvalBoundFunRes;
import boa.EvalFunRes;
import boa.EvalIntRes;
import boa.EvalMapRes;
import boa.EvalRes;
import boa.Expr;
import boa.Field;
import boa.File;
import boa.Fun;
import boa.If;
import boa.Int;
import boa.Let;
import boa.Not;
import boa.Project;
import boa.Seq;
import boa.Skip;
import boa.This;
import boa.TopLevelCmd;
import boa.Var;
import boa.With;
import boa.util.BoaSwitch;
import emfswitch.emfswitch.operation.AppOperation;
import emfswitch.emfswitch.operation.ArithOpDivideOperation;
import emfswitch.emfswitch.operation.ArithOpMinusOperation;
import emfswitch.emfswitch.operation.ArithOpOperation;
import emfswitch.emfswitch.operation.ArithOpPlusOperation;
import emfswitch.emfswitch.operation.ArithOpRemainderOperation;
import emfswitch.emfswitch.operation.ArithOpTimesOperation;
import emfswitch.emfswitch.operation.AssignOperation;
import emfswitch.emfswitch.operation.BObjectOperation;
import emfswitch.emfswitch.operation.BoolOpAndOperation;
import emfswitch.emfswitch.operation.BoolOpOperation;
import emfswitch.emfswitch.operation.BoolOpOrOperation;
import emfswitch.emfswitch.operation.BoolOperation;
import emfswitch.emfswitch.operation.CmpOpEqualOperation;
import emfswitch.emfswitch.operation.CmpOpLessOperation;
import emfswitch.emfswitch.operation.CmpOpOperation;
import emfswitch.emfswitch.operation.CmpOpUnequalOperation;
import emfswitch.emfswitch.operation.CopyOperation;
import emfswitch.emfswitch.operation.CtxOperation;
import emfswitch.emfswitch.operation.DefOperation;
import emfswitch.emfswitch.operation.EvalBoolResOperation;
import emfswitch.emfswitch.operation.EvalBoundFunResOperation;
import emfswitch.emfswitch.operation.EvalFunResOperation;
import emfswitch.emfswitch.operation.EvalIntResOperation;
import emfswitch.emfswitch.operation.EvalMapResOperation;
import emfswitch.emfswitch.operation.EvalResOperation;
import emfswitch.emfswitch.operation.ExprOperation;
import emfswitch.emfswitch.operation.FieldOperation;
import emfswitch.emfswitch.operation.FileOperation;
import emfswitch.emfswitch.operation.FunOperation;
import emfswitch.emfswitch.operation.IfOperation;
import emfswitch.emfswitch.operation.IntOperation;
import emfswitch.emfswitch.operation.LetOperation;
import emfswitch.emfswitch.operation.NotOperation;
import emfswitch.emfswitch.operation.ProjectOperation;
import emfswitch.emfswitch.operation.SeqOperation;
import emfswitch.emfswitch.operation.SkipOperation;
import emfswitch.emfswitch.operation.ThisOperation;
import emfswitch.emfswitch.operation.TopLevelCmdOperation;
import emfswitch.emfswitch.operation.VarOperation;
import emfswitch.emfswitch.operation.WithOperation;
import java.lang.Object;
import java.lang.Override;

public class EmfswitchSwitchImplementation extends BoaSwitch<Object> {
  @Override
  public Object caseFile(File it) {
    return new FileOperation(it, this);
  }

  @Override
  public Object caseTopLevelCmd(TopLevelCmd it) {
    return new TopLevelCmdOperation(it, this);
  }

  @Override
  public Object caseExpr(Expr it) {
    return new ExprOperation(it, this);
  }

  @Override
  public Object caseDef(Def it) {
    return new DefOperation(it, this);
  }

  @Override
  public Object caseApp(App it) {
    return new AppOperation(it, this);
  }

  @Override
  public Object caseVar(Var it) {
    return new VarOperation(it, this);
  }

  @Override
  public Object caseThis(This it) {
    return new ThisOperation(it, this);
  }

  @Override
  public Object caseBool(Bool it) {
    return new BoolOperation(it, this);
  }

  @Override
  public Object caseInt(Int it) {
    return new IntOperation(it, this);
  }

  @Override
  public Object caseSkip(Skip it) {
    return new SkipOperation(it, this);
  }

  @Override
  public Object caseProject(Project it) {
    return new ProjectOperation(it, this);
  }

  @Override
  public Object caseBObject(BObject it) {
    return new BObjectOperation(it, this);
  }

  @Override
  public Object caseField(Field it) {
    return new FieldOperation(it, this);
  }

  @Override
  public Object caseCopy(Copy it) {
    return new CopyOperation(it, this);
  }

  @Override
  public Object caseWith(With it) {
    return new WithOperation(it, this);
  }

  @Override
  public Object caseArithOp(ArithOp it) {
    return new ArithOpOperation(it, this);
  }

  @Override
  public Object caseNot(Not it) {
    return new NotOperation(it, this);
  }

  @Override
  public Object caseCmpOp(CmpOp it) {
    return new CmpOpOperation(it, this);
  }

  @Override
  public Object caseBoolOp(BoolOp it) {
    return new BoolOpOperation(it, this);
  }

  @Override
  public Object caseIf(If it) {
    return new IfOperation(it, this);
  }

  @Override
  public Object caseLet(Let it) {
    return new LetOperation(it, this);
  }

  @Override
  public Object caseFun(Fun it) {
    return new FunOperation(it, this);
  }

  @Override
  public Object caseAssign(Assign it) {
    return new AssignOperation(it, this);
  }

  @Override
  public Object caseArithOpPlus(ArithOpPlus it) {
    return new ArithOpPlusOperation(it, this);
  }

  @Override
  public Object caseArithOpMinus(ArithOpMinus it) {
    return new ArithOpMinusOperation(it, this);
  }

  @Override
  public Object caseArithOpTimes(ArithOpTimes it) {
    return new ArithOpTimesOperation(it, this);
  }

  @Override
  public Object caseArithOpDivide(ArithOpDivide it) {
    return new ArithOpDivideOperation(it, this);
  }

  @Override
  public Object caseArithOpRemainder(ArithOpRemainder it) {
    return new ArithOpRemainderOperation(it, this);
  }

  @Override
  public Object caseBoolOpAnd(BoolOpAnd it) {
    return new BoolOpAndOperation(it, this);
  }

  @Override
  public Object caseBoolOpOr(BoolOpOr it) {
    return new BoolOpOrOperation(it, this);
  }

  @Override
  public Object caseSeq(Seq it) {
    return new SeqOperation(it, this);
  }

  @Override
  public Object caseCmpOpEqual(CmpOpEqual it) {
    return new CmpOpEqualOperation(it, this);
  }

  @Override
  public Object caseCmpOpUnequal(CmpOpUnequal it) {
    return new CmpOpUnequalOperation(it, this);
  }

  @Override
  public Object caseCmpOpLess(CmpOpLess it) {
    return new CmpOpLessOperation(it, this);
  }

  @Override
  public Object caseCtx(Ctx it) {
    return new CtxOperation(it, this);
  }

  @Override
  public Object caseEvalRes(EvalRes it) {
    return new EvalResOperation(it, this);
  }

  @Override
  public Object caseEvalMapRes(EvalMapRes it) {
    return new EvalMapResOperation(it, this);
  }

  @Override
  public Object caseEvalFunRes(EvalFunRes it) {
    return new EvalFunResOperation(it, this);
  }

  @Override
  public Object caseEvalBoundFunRes(EvalBoundFunRes it) {
    return new EvalBoundFunResOperation(it, this);
  }

  @Override
  public Object caseEvalIntRes(EvalIntRes it) {
    return new EvalIntResOperation(it, this);
  }

  @Override
  public Object caseEvalBoolRes(EvalBoolRes it) {
    return new EvalBoolResOperation(it, this);
  }
}
