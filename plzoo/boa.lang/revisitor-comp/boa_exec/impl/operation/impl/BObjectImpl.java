package boa_exec.impl.operation.impl;

import boa.revisitor.BoaRevisitor;
import boa_dynamic.Ctx;
import boa_dynamic.EvalMapRes;
import boa_dynamic.EvalRes;
import boa_exec.impl.operation.App;
import boa_exec.impl.operation.ArithOp;
import boa_exec.impl.operation.ArithOpDivide;
import boa_exec.impl.operation.ArithOpMinus;
import boa_exec.impl.operation.ArithOpPlus;
import boa_exec.impl.operation.ArithOpRemainder;
import boa_exec.impl.operation.ArithOpTimes;
import boa_exec.impl.operation.Assign;
import boa_exec.impl.operation.BObject;
import boa_exec.impl.operation.Bool;
import boa_exec.impl.operation.BoolOp;
import boa_exec.impl.operation.BoolOpAnd;
import boa_exec.impl.operation.BoolOpOr;
import boa_exec.impl.operation.CmpOp;
import boa_exec.impl.operation.CmpOpEqual;
import boa_exec.impl.operation.CmpOpLess;
import boa_exec.impl.operation.CmpOpUnequal;
import boa_exec.impl.operation.Copy;
import boa_exec.impl.operation.Def;
import boa_exec.impl.operation.Expr;
import boa_exec.impl.operation.Field;
import boa_exec.impl.operation.File;
import boa_exec.impl.operation.Fun;
import boa_exec.impl.operation.If;
import boa_exec.impl.operation.Int;
import boa_exec.impl.operation.Let;
import boa_exec.impl.operation.Not;
import boa_exec.impl.operation.Project;
import boa_exec.impl.operation.Seq;
import boa_exec.impl.operation.Skip;
import boa_exec.impl.operation.This;
import boa_exec.impl.operation.TopLevelCmd;
import boa_exec.impl.operation.Var;
import boa_exec.impl.operation.With;

public class BObjectImpl extends ExprImpl implements BObject {
  private BoaRevisitor<App, ArithOp, ArithOpDivide, ArithOpMinus, ArithOpPlus, ArithOpRemainder, ArithOpTimes, Assign, BObject, Bool, BoolOp, BoolOpAnd, BoolOpOr, CmpOp, CmpOpEqual, CmpOpLess, CmpOpUnequal, Copy, Def, Expr, Field, File, Fun, If, Int, Let, Not, Project, Seq, Skip, This, TopLevelCmd, Var, With> rev;

  private boa.BObject obj;

  public BObjectImpl(boa.BObject obj,
      BoaRevisitor<App, ArithOp, ArithOpDivide, ArithOpMinus, ArithOpPlus, ArithOpRemainder, ArithOpTimes, Assign, BObject, Bool, BoolOp, BoolOpAnd, BoolOpOr, CmpOp, CmpOpEqual, CmpOpLess, CmpOpUnequal, Copy, Def, Expr, Field, File, Fun, If, Int, Let, Not, Project, Seq, Skip, This, TopLevelCmd, Var, With> rev) {
    super(obj, rev);
    this.obj = obj;
    this.rev = rev;
  }

  public EvalRes eval(Ctx ctx) {
    EvalRes result;
    EvalMapRes ret = ((EvalMapRes)boa_dynamic.Boa_dynamicFactory.eINSTANCE.createEvalMapRes());
    for(boa.Field x: this.obj.getFields()) {
      EvalRes v = ((EvalRes)rev.$(x.getValue()).eval(ctx));
      execboa.MapService.put(ret.getValues(), x.getName(), v);
    }
    result = ret;
    return result;
  }
}
