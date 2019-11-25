package visitor.visitor.operation.boa.impl;

import visitor.boa.visitor.boa.App;
import visitor.boa.visitor.boa.Ctx;
import visitor.boa.visitor.boa.EvalBoundFunRes;
import visitor.boa.visitor.boa.EvalFunRes;
import visitor.boa.visitor.boa.EvalRes;
import visitor.visitor.VisitorInterface;
import visitor.visitor.operation.boa.AppOperation;

public class AppOperationImpl extends ExprOperationImpl implements AppOperation {
  private final App it;

  private final VisitorInterface vis;

  public AppOperationImpl(App it, VisitorInterface vis) {
    super(it, vis);
    this.it = it;
    this.vis = vis;
  }

  public EvalRes eval(Ctx ctx) {
    EvalRes result;
    EvalRes vlhs = ((EvalRes)((visitor.visitor.operation.boa.ExprOperation)this.it.getLhs().accept(vis)).eval(ctx));
    EvalRes vrhs = ((EvalRes)((visitor.visitor.operation.boa.ExprOperation)this.it.getRhs().accept(vis)).eval(ctx));
    if(vlhs instanceof visitor.boa.visitor.boa.EvalFunRes) {
      if(vlhs instanceof visitor.boa.visitor.boa.EvalBoundFunRes) {
        EvalBoundFunRes fct = ((EvalBoundFunRes)vlhs);
        Ctx callCtx = ((Ctx)visitor.boa.visitor.boa.BoaFactory.eINSTANCE.createCtx());
        execboa.MapService.putAll(callCtx.getEnv(), fct.getCtx().getEnv());
        execboa.MapService.put(callCtx.getEnv(), fct.getName(), vrhs);
        execboa.MapService.replaceWith(callCtx.getTh(), fct.getTh());
        EvalRes fe = ((EvalRes)((visitor.visitor.operation.boa.AppOperation)this.it.accept(vis)).callFunc(fct,callCtx));
        if(fe instanceof visitor.boa.visitor.boa.EvalFunRes) {
          EvalFunRes fun = ((EvalFunRes)fe);
          EvalBoundFunRes tmp = ((EvalBoundFunRes)visitor.boa.visitor.boa.BoaFactory.eINSTANCE.createEvalBoundFunRes());
          tmp.setExp(fun.getExp());
          tmp.setCtx(fun.getCtx());
          tmp.setName(fun.getName());
          execboa.MapService.replaceWith(tmp.getTh(), fct.getTh());
          result = tmp;
        }
        else {
          result = fe;
        }
      }
      else {
        EvalFunRes fct = ((EvalFunRes)vlhs);
        Ctx callCtx = ((Ctx)visitor.boa.visitor.boa.BoaFactory.eINSTANCE.createCtx());
        execboa.MapService.putAll(callCtx.getEnv(), fct.getCtx().getEnv());
        execboa.MapService.put(callCtx.getEnv(), fct.getName(), vrhs);
        execboa.MapService.replaceWith(callCtx.getTh(), ctx.getTh());
        EvalRes fe = ((EvalRes)((visitor.visitor.operation.boa.AppOperation)this.it.accept(vis)).callFunc(fct,callCtx));
        if(fe instanceof visitor.boa.visitor.boa.EvalFunRes) {
          EvalFunRes fun = ((EvalFunRes)fe);
          EvalBoundFunRes tmp = ((EvalBoundFunRes)visitor.boa.visitor.boa.BoaFactory.eINSTANCE.createEvalBoundFunRes());
          tmp.setExp(fun.getExp());
          tmp.setCtx(fun.getCtx());
          tmp.setName(fun.getName());
          execboa.MapService.replaceWith(tmp.getTh(), ctx.getTh());
          result = tmp;
        }
        else {
          result = fe;
        }
      }
    }
    else {
      result = null;
    }
    return result;
  }

  public EvalRes callFunc(EvalFunRes fct, Ctx callCtx) {
    EvalRes result;
    result = ((visitor.visitor.operation.boa.ExprOperation)fct.getExp().accept(vis)).eval(callCtx);
    return result;
  }
}
