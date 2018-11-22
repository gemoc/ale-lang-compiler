package emfswitch.emfswitch.operation;

import boa.Assign;
import boa.Ctx;
import boa.EvalMapRes;
import boa.EvalRes;
import emfswitch.emfswitch.EmfswitchSwitchImplementation;

public class AssignOperation extends ExprOperation {
  private final Assign it;

  private final EmfswitchSwitchImplementation emfswitch;

  public AssignOperation(Assign it, EmfswitchSwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }

  public EvalRes eval(Ctx ctx) {
    EvalRes result;
    EvalRes vlhs = ((EvalRes)((emfswitch.emfswitch.operation.ExprOperation) emfswitch.doSwitch(this.it.getLhs())).eval(ctx));
    EvalRes vrhs = ((EvalRes)((emfswitch.emfswitch.operation.ExprOperation) emfswitch.doSwitch(this.it.getRhs())).eval(ctx));
    if(vlhs instanceof boa.EvalMapRes) {
      EvalMapRes mvlhs = ((EvalMapRes)vlhs);
      if(execboa.MapService.containsKey(mvlhs.getValues(), this.it.getName())) {
        execboa.MapService.put(mvlhs.getValues(), this.it.getName(), vrhs);
        result = vrhs;
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
}
