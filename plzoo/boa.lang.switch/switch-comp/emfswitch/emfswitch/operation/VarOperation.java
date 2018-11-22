package emfswitch.emfswitch.operation;

import boa.Ctx;
import boa.EvalRes;
import boa.Var;
import emfswitch.emfswitch.EmfswitchSwitchImplementation;

public class VarOperation extends ExprOperation {
  private final Var it;

  private final EmfswitchSwitchImplementation emfswitch;

  public VarOperation(Var it, EmfswitchSwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }

  public EvalRes eval(Ctx ctx) {
    EvalRes result;
    if(execboa.MapService.containsKey(ctx.getEnv(), this.it.getName())) {
      result = execboa.MapService.getFromMap(ctx.getEnv(), this.it.getName());
    }
    else {
      result = null;
    }
    return result;
  }
}
