package emfswitch.emfswitch.operation;

import boa.App;
import boa.Ctx;
import boa.EvalBoundFunRes;
import boa.EvalFunRes;
import boa.EvalRes;
import emfswitch.emfswitch.EmfswitchSwitchImplementation;

public class AppOperation extends ExprOperation {
  private final App it;

  private final EmfswitchSwitchImplementation emfswitch;

  public AppOperation(App it, EmfswitchSwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }

  public EvalRes eval(Ctx ctx) {
    EvalRes result;
    EvalRes vlhs = ((EvalRes)((emfswitch.emfswitch.operation.ExprOperation) emfswitch.doSwitch(this.it.getLhs())).eval(ctx));
    EvalRes vrhs = ((EvalRes)((emfswitch.emfswitch.operation.ExprOperation) emfswitch.doSwitch(this.it.getRhs())).eval(ctx));
    if(vlhs instanceof boa.EvalFunRes) {
      if(vlhs instanceof boa.EvalBoundFunRes) {
        EvalBoundFunRes fct = ((EvalBoundFunRes)vlhs);
        Ctx callCtx = ((Ctx)boa.BoaFactory.eINSTANCE.createCtx());
        execboa.MapService.putAll(callCtx.getEnv(), fct.getCtx().getEnv());
        execboa.MapService.put(callCtx.getEnv(), fct.getName(), vrhs);
        execboa.MapService.replaceWith(callCtx.getTh(), fct.getTh());
        EvalRes fe = ((EvalRes)((emfswitch.emfswitch.operation.AppOperation) emfswitch.doSwitch(this.it)).callFunc(fct,callCtx));
        if(fe instanceof boa.EvalFunRes) {
          EvalFunRes fun = ((EvalFunRes)fe);
          EvalBoundFunRes tmp = ((EvalBoundFunRes)boa.BoaFactory.eINSTANCE.createEvalBoundFunRes());
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
        Ctx callCtx = ((Ctx)boa.BoaFactory.eINSTANCE.createCtx());
        execboa.MapService.putAll(callCtx.getEnv(), fct.getCtx().getEnv());
        execboa.MapService.put(callCtx.getEnv(), fct.getName(), vrhs);
        execboa.MapService.replaceWith(callCtx.getTh(), ctx.getTh());
        EvalRes fe = ((EvalRes)((emfswitch.emfswitch.operation.AppOperation) emfswitch.doSwitch(this.it)).callFunc(fct,callCtx));
        if(fe instanceof boa.EvalFunRes) {
          EvalFunRes fun = ((EvalFunRes)fe);
          EvalBoundFunRes tmp = ((EvalBoundFunRes)boa.BoaFactory.eINSTANCE.createEvalBoundFunRes());
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
    result = ((emfswitch.emfswitch.operation.ExprOperation) emfswitch.doSwitch(fct.getExp())).eval(callCtx);
    return result;
  }
}
