package test.impl.operation.impl;

import boa.App;
import boa.BoaFactory;
import boa.Ctx;
import boa.EvalBoundFunRes;
import boa.EvalFunRes;
import boa.EvalRes;
import boa.Expr;
import boa.revisitor.BoaRevisitor;
import execboa.MapService;
import java.lang.String;
import org.eclipse.emf.common.util.EMap;
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

public class AppOpImpl extends ExprOpImpl implements AppOp {
  private BoaRevisitor<AppOp, ArithOpOp, ArithOpDivideOp, ArithOpMinusOp, ArithOpPlusOp, ArithOpRemainderOp, ArithOpTimesOp, AssignOp, BObjectOp, BoolOp, BoolOpOp, BoolOpAndOp, BoolOpOrOp, CmpOpOp, CmpOpEqualOp, CmpOpLessOp, CmpOpUnequalOp, CopyOp, CtxOp, DefOp, EvalBoolResOp, EvalBoundFunResOp, EvalFunResOp, EvalIntResOp, EvalMapResOp, EvalResOp, ExprOp, FieldOp, FileOp, FunOp, IfOp, IntOp, LetOp, NotOp, ProjectOp, SeqOp, SkipOp, ThisOp, TopLevelCmdOp, VarOp, WithOp> rev;

  private App obj;

  public AppOpImpl(App obj,
      BoaRevisitor<AppOp, ArithOpOp, ArithOpDivideOp, ArithOpMinusOp, ArithOpPlusOp, ArithOpRemainderOp, ArithOpTimesOp, AssignOp, BObjectOp, BoolOp, BoolOpOp, BoolOpAndOp, BoolOpOrOp, CmpOpOp, CmpOpEqualOp, CmpOpLessOp, CmpOpUnequalOp, CopyOp, CtxOp, DefOp, EvalBoolResOp, EvalBoundFunResOp, EvalFunResOp, EvalIntResOp, EvalMapResOp, EvalResOp, ExprOp, FieldOp, FileOp, FunOp, IfOp, IntOp, LetOp, NotOp, ProjectOp, SeqOp, SkipOp, ThisOp, TopLevelCmdOp, VarOp, WithOp> rev) {
    super(obj, rev);
    this.obj = obj;
    this.rev = rev;
  }

  public EvalRes eval(Ctx ctx) {
    EvalRes result;
    EvalRes vlhs = ((EvalRes) (rev.$((Expr)this.obj.getLhs()).eval(((Ctx) (ctx)))));
    EvalRes vrhs = ((EvalRes) (rev.$((Expr)this.obj.getRhs()).eval(((Ctx) (ctx)))));
    if(vlhs instanceof EvalFunRes) {
      if(vlhs instanceof EvalBoundFunRes) {
        EvalBoundFunRes fct = ((EvalBoundFunRes) (vlhs));
        Ctx callCtx = ((Ctx) (BoaFactory.eINSTANCE.createCtx()));
        MapService.putAll((EMap) (callCtx.getEnv()), (EMap) (fct.getCtx().getEnv()));
        MapService.put((EMap) (callCtx.getEnv()), (String) (fct.getName()), (EvalRes) (vrhs));
        MapService.replaceWith((EMap) (callCtx.getTh()), (EMap) (fct.getTh()));
        EvalRes fe = ((EvalRes) (rev.$((App)this.obj).callFunc(((EvalBoundFunRes) (fct)), ((Ctx) (callCtx)))));
        if(fe instanceof EvalFunRes) {
          EvalFunRes fun = ((EvalFunRes) (fe));
          EvalBoundFunRes tmp = ((EvalBoundFunRes) (BoaFactory.eINSTANCE.createEvalBoundFunRes()));
          tmp.setExp(fun.getExp());
          tmp.setCtx(fun.getCtx());
          tmp.setName(fun.getName());
          MapService.replaceWith((EMap) (tmp.getTh()), (EMap) (fct.getTh()));
          result = ((EvalBoundFunRes) (tmp));
        }
        else {
          result = ((EvalRes) (fe));
        }
      }
      else {
        EvalFunRes fct = ((EvalFunRes) (vlhs));
        Ctx callCtx = ((Ctx) (BoaFactory.eINSTANCE.createCtx()));
        MapService.putAll((EMap) (callCtx.getEnv()), (EMap) (fct.getCtx().getEnv()));
        MapService.put((EMap) (callCtx.getEnv()), (String) (fct.getName()), (EvalRes) (vrhs));
        MapService.replaceWith((EMap) (callCtx.getTh()), (EMap) (ctx.getTh()));
        EvalRes fe = ((EvalRes) (rev.$((App)this.obj).callFunc(((EvalFunRes) (fct)), ((Ctx) (callCtx)))));
        if(fe instanceof EvalFunRes) {
          EvalFunRes fun = ((EvalFunRes) (fe));
          EvalBoundFunRes tmp = ((EvalBoundFunRes) (BoaFactory.eINSTANCE.createEvalBoundFunRes()));
          tmp.setExp(fun.getExp());
          tmp.setCtx(fun.getCtx());
          tmp.setName(fun.getName());
          MapService.replaceWith((EMap) (tmp.getTh()), (EMap) (ctx.getTh()));
          result = ((EvalBoundFunRes) (tmp));
        }
        else {
          result = ((EvalRes) (fe));
        }
      }
    }
    else {
      result = ((EvalRes) (null));
    }
    return result;
  }

  public EvalRes callFunc(EvalFunRes fct, Ctx callCtx) {
    EvalRes result;
    result = ((EvalRes) (rev.$((Expr)fct.getExp()).eval(((Ctx) (callCtx)))));
    return result;
  }
}
