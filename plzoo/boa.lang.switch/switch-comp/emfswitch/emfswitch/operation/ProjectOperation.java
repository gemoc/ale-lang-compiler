package emfswitch.emfswitch.operation;

import boa.Ctx;
import boa.EvalBoundFunRes;
import boa.EvalFunRes;
import boa.EvalMapRes;
import boa.EvalRes;
import boa.Project;
import emfswitch.emfswitch.EmfswitchSwitchImplementation;

public class ProjectOperation extends ExprOperation {
  private final Project it;

  private final EmfswitchSwitchImplementation emfswitch;

  public ProjectOperation(Project it, EmfswitchSwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }

  public EvalRes eval(Ctx ctx) {
    EvalRes result;
    EvalRes vexp = ((EvalRes)((emfswitch.emfswitch.operation.ExprOperation) emfswitch.doSwitch(this.it.getExp())).eval(ctx));
    if(vexp instanceof boa.EvalMapRes) {
      EvalMapRes mvexp = ((EvalMapRes)vexp);
      if(execboa.MapService.containsKey(mvexp.getValues(), this.it.getName())) {
        EvalRes x = ((EvalRes)mvexp.getValues().get(this.it.getName()));
        if(x instanceof boa.EvalFunRes) {
          EvalFunRes func = ((EvalFunRes)x);
          result = ((emfswitch.emfswitch.operation.ProjectOperation) emfswitch.doSwitch(this.it)).project(func,mvexp);
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
    EvalBoundFunRes ret = ((EvalBoundFunRes)boa.BoaFactory.eINSTANCE.createEvalBoundFunRes());
    ret.setExp(func.getExp());
    ret.setCtx(func.getCtx());
    ret.setName(func.getName());
    execboa.MapService.replaceWith(ret.getTh(), mvexp.getValues());
    result = ret;
    return result;
  }
}
