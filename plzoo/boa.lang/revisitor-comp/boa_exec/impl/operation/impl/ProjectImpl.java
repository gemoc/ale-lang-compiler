package boa_exec.impl.operation.impl;

import boa.revisitor.BoaRevisitor;
import boa_dynamic.Ctx;
import boa_dynamic.EvalBoundFunRes;
import boa_dynamic.EvalFunRes;
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

public class ProjectImpl extends ExprImpl implements Project {
  private BoaRevisitor<App, ArithOp, ArithOpDivide, ArithOpMinus, ArithOpPlus, ArithOpRemainder, ArithOpTimes, Assign, BObject, Bool, BoolOp, BoolOpAnd, BoolOpOr, CmpOp, CmpOpEqual, CmpOpLess, CmpOpUnequal, Copy, Def, Expr, Field, File, Fun, If, Int, Let, Not, Project, Seq, Skip, This, TopLevelCmd, Var, With> rev;

  private boa.Project obj;

  public ProjectImpl(boa.Project obj,
      BoaRevisitor<App, ArithOp, ArithOpDivide, ArithOpMinus, ArithOpPlus, ArithOpRemainder, ArithOpTimes, Assign, BObject, Bool, BoolOp, BoolOpAnd, BoolOpOr, CmpOp, CmpOpEqual, CmpOpLess, CmpOpUnequal, Copy, Def, Expr, Field, File, Fun, If, Int, Let, Not, Project, Seq, Skip, This, TopLevelCmd, Var, With> rev) {
    super(obj, rev);
    this.obj = obj;
    this.rev = rev;
  }

  public EvalRes eval(Ctx ctx) {
    EvalRes result;
    EvalRes vexp = ((EvalRes)rev.$(this.obj.getExp()).eval(ctx));
    if(vexp instanceof boa_dynamic.EvalMapRes) {
      EvalMapRes mvexp = ((EvalMapRes)vexp);
      if(execboa.MapService.containsKey(mvexp.getValues(), this.obj.getName())) {
        EvalRes x = ((EvalRes)mvexp.getValues().get(this.obj.getName()));
        if(x instanceof boa_dynamic.EvalFunRes) {
          EvalFunRes func = ((EvalFunRes)x);
          result = rev.$(this.obj).project(func,mvexp);
        }
        else {
          result = x;
        }
      }
      else {
        result = null;
      }
    }
    else {
      result = null;
    }
    return result;
  }

  public EvalRes project(EvalFunRes func, EvalMapRes mvexp) {
    EvalRes result;
    EvalBoundFunRes ret = ((EvalBoundFunRes)boa_dynamic.Boa_dynamicFactory.eINSTANCE.createEvalBoundFunRes());
    ret.setExp(func.getExp());
    ret.setCtx(func.getCtx());
    ret.setName(func.getName());
    execboa.MapService.replaceWith(ret.getTh(), mvexp.getValues());
    result = ret;
    return result;
  }
}
