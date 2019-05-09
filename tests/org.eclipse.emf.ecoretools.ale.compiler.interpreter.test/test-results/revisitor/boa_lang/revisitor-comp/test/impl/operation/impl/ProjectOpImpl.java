package test.impl.operation.impl;

import boa.BoaFactory;
import boa.Ctx;
import boa.EvalBoundFunRes;
import boa.EvalFunRes;
import boa.EvalMapRes;
import boa.EvalRes;
import boa.Expr;
import boa.Project;
import boa.revisitor.BoaRevisitor;
import org.eclipse.acceleo.query.runtime.impl.Nothing;
import test.impl.operation.AppOp;
import test.impl.operation.ArithOpDivideOp;
import test.impl.operation.ArithOpMinusOp;
import test.impl.operation.ArithOpOp;
import test.impl.operation.ArithOpPlusOp;
import test.impl.operation.ArithOpRemainderOp;
import test.impl.operation.ArithOpTimesOp;
import test.impl.operation.AssignOp;
import test.impl.operation.BObjectOp;
import test.impl.operation.BoolOp;
import test.impl.operation.BoolOpAndOp;
import test.impl.operation.BoolOpOp;
import test.impl.operation.BoolOpOrOp;
import test.impl.operation.CmpOpEqualOp;
import test.impl.operation.CmpOpLessOp;
import test.impl.operation.CmpOpOp;
import test.impl.operation.CmpOpUnequalOp;
import test.impl.operation.CopyOp;
import test.impl.operation.CtxOp;
import test.impl.operation.DefOp;
import test.impl.operation.EvalBoolResOp;
import test.impl.operation.EvalBoundFunResOp;
import test.impl.operation.EvalFunResOp;
import test.impl.operation.EvalIntResOp;
import test.impl.operation.EvalMapResOp;
import test.impl.operation.EvalResOp;
import test.impl.operation.ExprOp;
import test.impl.operation.FieldOp;
import test.impl.operation.FileOp;
import test.impl.operation.FunOp;
import test.impl.operation.IfOp;
import test.impl.operation.IntOp;
import test.impl.operation.LetOp;
import test.impl.operation.NotOp;
import test.impl.operation.ProjectOp;
import test.impl.operation.SeqOp;
import test.impl.operation.SkipOp;
import test.impl.operation.ThisOp;
import test.impl.operation.TopLevelCmdOp;
import test.impl.operation.VarOp;
import test.impl.operation.WithOp;

public class ProjectOpImpl extends ExprOpImpl implements ProjectOp {
  private BoaRevisitor<AppOp, ArithOpOp, ArithOpDivideOp, ArithOpMinusOp, ArithOpPlusOp, ArithOpRemainderOp, ArithOpTimesOp, AssignOp, BObjectOp, BoolOp, BoolOpOp, BoolOpAndOp, BoolOpOrOp, CmpOpOp, CmpOpEqualOp, CmpOpLessOp, CmpOpUnequalOp, CopyOp, CtxOp, DefOp, EvalBoolResOp, EvalBoundFunResOp, EvalFunResOp, EvalIntResOp, EvalMapResOp, EvalResOp, ExprOp, FieldOp, FileOp, FunOp, IfOp, IntOp, LetOp, NotOp, ProjectOp, SeqOp, SkipOp, ThisOp, TopLevelCmdOp, VarOp, WithOp> rev;

  private Project obj;

  public ProjectOpImpl(Project obj,
      BoaRevisitor<AppOp, ArithOpOp, ArithOpDivideOp, ArithOpMinusOp, ArithOpPlusOp, ArithOpRemainderOp, ArithOpTimesOp, AssignOp, BObjectOp, BoolOp, BoolOpOp, BoolOpAndOp, BoolOpOrOp, CmpOpOp, CmpOpEqualOp, CmpOpLessOp, CmpOpUnequalOp, CopyOp, CtxOp, DefOp, EvalBoolResOp, EvalBoundFunResOp, EvalFunResOp, EvalIntResOp, EvalMapResOp, EvalResOp, ExprOp, FieldOp, FileOp, FunOp, IfOp, IntOp, LetOp, NotOp, ProjectOp, SeqOp, SkipOp, ThisOp, TopLevelCmdOp, VarOp, WithOp> rev) {
    super(obj, rev);
    this.obj = obj;
    this.rev = rev;
  }

  public EvalRes eval(Ctx ctx) {
    EvalRes result;
    EvalRes vexp = ((EvalRes) (rev.$((Expr)this.obj.getExp()).eval(((Ctx) (ctx)))));
    if(vexp instanceof EvalMapRes) {
      EvalMapRes mvexp = ((EvalMapRes) (vexp));
      if(execboa.MapService.containsKey(mvexp.getValues(), this.obj.getName())) {
        EvalRes x = ((EvalRes) (mvexp.getValues().get(this.obj.getName())));
        if(x instanceof EvalFunRes) {
          EvalFunRes func = ((EvalFunRes) (x));
          result = rev.$((Project)this.obj).project(((EvalFunRes) (func)),((EvalMapRes) (mvexp)));
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
    EvalBoundFunRes ret = ((EvalBoundFunRes) (BoaFactory.eINSTANCE.createEvalBoundFunRes()));
    ret.setExp(func.getExp());
    ret.setCtx(func.getCtx());
    ret.setName(func.getName());
    execboa.MapService.replaceWith(ret.getTh(), mvexp.getValues());
    result = ret;
    return result;
  }
}
