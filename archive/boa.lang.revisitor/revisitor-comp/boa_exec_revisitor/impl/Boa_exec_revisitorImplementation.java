package boa_exec_revisitor.impl;

import boa.revisitor.BoaRevisitor;
import boa_exec_revisitor.impl.operation.App;
import boa_exec_revisitor.impl.operation.ArithOp;
import boa_exec_revisitor.impl.operation.ArithOpDivide;
import boa_exec_revisitor.impl.operation.ArithOpMinus;
import boa_exec_revisitor.impl.operation.ArithOpPlus;
import boa_exec_revisitor.impl.operation.ArithOpRemainder;
import boa_exec_revisitor.impl.operation.ArithOpTimes;
import boa_exec_revisitor.impl.operation.Assign;
import boa_exec_revisitor.impl.operation.BObject;
import boa_exec_revisitor.impl.operation.Bool;
import boa_exec_revisitor.impl.operation.BoolOp;
import boa_exec_revisitor.impl.operation.BoolOpAnd;
import boa_exec_revisitor.impl.operation.BoolOpOr;
import boa_exec_revisitor.impl.operation.CmpOp;
import boa_exec_revisitor.impl.operation.CmpOpEqual;
import boa_exec_revisitor.impl.operation.CmpOpLess;
import boa_exec_revisitor.impl.operation.CmpOpUnequal;
import boa_exec_revisitor.impl.operation.Copy;
import boa_exec_revisitor.impl.operation.Ctx;
import boa_exec_revisitor.impl.operation.Def;
import boa_exec_revisitor.impl.operation.EvalBoolRes;
import boa_exec_revisitor.impl.operation.EvalBoundFunRes;
import boa_exec_revisitor.impl.operation.EvalFunRes;
import boa_exec_revisitor.impl.operation.EvalIntRes;
import boa_exec_revisitor.impl.operation.EvalMapRes;
import boa_exec_revisitor.impl.operation.EvalRes;
import boa_exec_revisitor.impl.operation.Expr;
import boa_exec_revisitor.impl.operation.Field;
import boa_exec_revisitor.impl.operation.File;
import boa_exec_revisitor.impl.operation.Fun;
import boa_exec_revisitor.impl.operation.If;
import boa_exec_revisitor.impl.operation.Int;
import boa_exec_revisitor.impl.operation.Let;
import boa_exec_revisitor.impl.operation.Not;
import boa_exec_revisitor.impl.operation.Project;
import boa_exec_revisitor.impl.operation.Seq;
import boa_exec_revisitor.impl.operation.Skip;
import boa_exec_revisitor.impl.operation.This;
import boa_exec_revisitor.impl.operation.TopLevelCmd;
import boa_exec_revisitor.impl.operation.Var;
import boa_exec_revisitor.impl.operation.With;
import boa_exec_revisitor.impl.operation.impl.AppImpl;
import boa_exec_revisitor.impl.operation.impl.ArithOpDivideImpl;
import boa_exec_revisitor.impl.operation.impl.ArithOpImpl;
import boa_exec_revisitor.impl.operation.impl.ArithOpMinusImpl;
import boa_exec_revisitor.impl.operation.impl.ArithOpPlusImpl;
import boa_exec_revisitor.impl.operation.impl.ArithOpRemainderImpl;
import boa_exec_revisitor.impl.operation.impl.ArithOpTimesImpl;
import boa_exec_revisitor.impl.operation.impl.AssignImpl;
import boa_exec_revisitor.impl.operation.impl.BObjectImpl;
import boa_exec_revisitor.impl.operation.impl.BoolImpl;
import boa_exec_revisitor.impl.operation.impl.BoolOpAndImpl;
import boa_exec_revisitor.impl.operation.impl.BoolOpImpl;
import boa_exec_revisitor.impl.operation.impl.BoolOpOrImpl;
import boa_exec_revisitor.impl.operation.impl.CmpOpEqualImpl;
import boa_exec_revisitor.impl.operation.impl.CmpOpImpl;
import boa_exec_revisitor.impl.operation.impl.CmpOpLessImpl;
import boa_exec_revisitor.impl.operation.impl.CmpOpUnequalImpl;
import boa_exec_revisitor.impl.operation.impl.CopyImpl;
import boa_exec_revisitor.impl.operation.impl.CtxImpl;
import boa_exec_revisitor.impl.operation.impl.DefImpl;
import boa_exec_revisitor.impl.operation.impl.EvalBoolResImpl;
import boa_exec_revisitor.impl.operation.impl.EvalBoundFunResImpl;
import boa_exec_revisitor.impl.operation.impl.EvalFunResImpl;
import boa_exec_revisitor.impl.operation.impl.EvalIntResImpl;
import boa_exec_revisitor.impl.operation.impl.EvalMapResImpl;
import boa_exec_revisitor.impl.operation.impl.EvalResImpl;
import boa_exec_revisitor.impl.operation.impl.ExprImpl;
import boa_exec_revisitor.impl.operation.impl.FieldImpl;
import boa_exec_revisitor.impl.operation.impl.FileImpl;
import boa_exec_revisitor.impl.operation.impl.FunImpl;
import boa_exec_revisitor.impl.operation.impl.IfImpl;
import boa_exec_revisitor.impl.operation.impl.IntImpl;
import boa_exec_revisitor.impl.operation.impl.LetImpl;
import boa_exec_revisitor.impl.operation.impl.NotImpl;
import boa_exec_revisitor.impl.operation.impl.ProjectImpl;
import boa_exec_revisitor.impl.operation.impl.SeqImpl;
import boa_exec_revisitor.impl.operation.impl.SkipImpl;
import boa_exec_revisitor.impl.operation.impl.ThisImpl;
import boa_exec_revisitor.impl.operation.impl.TopLevelCmdImpl;
import boa_exec_revisitor.impl.operation.impl.VarImpl;
import boa_exec_revisitor.impl.operation.impl.WithImpl;

public interface Boa_exec_revisitorImplementation extends BoaRevisitor<App, ArithOp, ArithOpDivide, ArithOpMinus, ArithOpPlus, ArithOpRemainder, ArithOpTimes, Assign, BObject, Bool, BoolOp, BoolOpAnd, BoolOpOr, CmpOp, CmpOpEqual, CmpOpLess, CmpOpUnequal, Copy, Ctx, Def, EvalBoolRes, EvalBoundFunRes, EvalFunRes, EvalIntRes, EvalMapRes, EvalRes, Expr, Field, File, Fun, If, Int, Let, Not, Project, Seq, Skip, This, TopLevelCmd, Var, With> {
  default File boa__File(boa.File it) {
    return new FileImpl(it, this);
  }

  default TopLevelCmd boa__TopLevelCmd(boa.TopLevelCmd it) {
    return new TopLevelCmdImpl(it, this);
  }

  default Expr boa__Expr(boa.Expr it) {
    return new ExprImpl(it, this);
  }

  default Def boa__Def(boa.Def it) {
    return new DefImpl(it, this);
  }

  default App boa__App(boa.App it) {
    return new AppImpl(it, this);
  }

  default Var boa__Var(boa.Var it) {
    return new VarImpl(it, this);
  }

  default This boa__This(boa.This it) {
    return new ThisImpl(it, this);
  }

  default Bool boa__Bool(boa.Bool it) {
    return new BoolImpl(it, this);
  }

  default Int boa__Int(boa.Int it) {
    return new IntImpl(it, this);
  }

  default Skip boa__Skip(boa.Skip it) {
    return new SkipImpl(it, this);
  }

  default Project boa__Project(boa.Project it) {
    return new ProjectImpl(it, this);
  }

  default BObject boa__BObject(boa.BObject it) {
    return new BObjectImpl(it, this);
  }

  default Field boa__Field(boa.Field it) {
    return new FieldImpl(it, this);
  }

  default Copy boa__Copy(boa.Copy it) {
    return new CopyImpl(it, this);
  }

  default With boa__With(boa.With it) {
    return new WithImpl(it, this);
  }

  default ArithOp boa__ArithOp(boa.ArithOp it) {
    return new ArithOpImpl(it, this);
  }

  default Not boa__Not(boa.Not it) {
    return new NotImpl(it, this);
  }

  default CmpOp boa__CmpOp(boa.CmpOp it) {
    return new CmpOpImpl(it, this);
  }

  default BoolOp boa__BoolOp(boa.BoolOp it) {
    return new BoolOpImpl(it, this);
  }

  default If boa__If(boa.If it) {
    return new IfImpl(it, this);
  }

  default Let boa__Let(boa.Let it) {
    return new LetImpl(it, this);
  }

  default Fun boa__Fun(boa.Fun it) {
    return new FunImpl(it, this);
  }

  default Assign boa__Assign(boa.Assign it) {
    return new AssignImpl(it, this);
  }

  default ArithOpPlus boa__ArithOpPlus(boa.ArithOpPlus it) {
    return new ArithOpPlusImpl(it, this);
  }

  default ArithOpMinus boa__ArithOpMinus(boa.ArithOpMinus it) {
    return new ArithOpMinusImpl(it, this);
  }

  default ArithOpTimes boa__ArithOpTimes(boa.ArithOpTimes it) {
    return new ArithOpTimesImpl(it, this);
  }

  default ArithOpDivide boa__ArithOpDivide(boa.ArithOpDivide it) {
    return new ArithOpDivideImpl(it, this);
  }

  default ArithOpRemainder boa__ArithOpRemainder(boa.ArithOpRemainder it) {
    return new ArithOpRemainderImpl(it, this);
  }

  default BoolOpAnd boa__BoolOpAnd(boa.BoolOpAnd it) {
    return new BoolOpAndImpl(it, this);
  }

  default BoolOpOr boa__BoolOpOr(boa.BoolOpOr it) {
    return new BoolOpOrImpl(it, this);
  }

  default Seq boa__Seq(boa.Seq it) {
    return new SeqImpl(it, this);
  }

  default CmpOpEqual boa__CmpOpEqual(boa.CmpOpEqual it) {
    return new CmpOpEqualImpl(it, this);
  }

  default CmpOpUnequal boa__CmpOpUnequal(boa.CmpOpUnequal it) {
    return new CmpOpUnequalImpl(it, this);
  }

  default CmpOpLess boa__CmpOpLess(boa.CmpOpLess it) {
    return new CmpOpLessImpl(it, this);
  }

  default Ctx boa__Ctx(boa.Ctx it) {
    return new CtxImpl(it, this);
  }

  default EvalRes boa__EvalRes(boa.EvalRes it) {
    return new EvalResImpl(it, this);
  }

  default EvalMapRes boa__EvalMapRes(boa.EvalMapRes it) {
    return new EvalMapResImpl(it, this);
  }

  default EvalFunRes boa__EvalFunRes(boa.EvalFunRes it) {
    return new EvalFunResImpl(it, this);
  }

  default EvalBoundFunRes boa__EvalBoundFunRes(boa.EvalBoundFunRes it) {
    return new EvalBoundFunResImpl(it, this);
  }

  default EvalIntRes boa__EvalIntRes(boa.EvalIntRes it) {
    return new EvalIntResImpl(it, this);
  }

  default EvalBoolRes boa__EvalBoolRes(boa.EvalBoolRes it) {
    return new EvalBoolResImpl(it, this);
  }
}
