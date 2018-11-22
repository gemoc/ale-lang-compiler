package emfswitch.emfswitch.operation;

import boa.Ctx;
import boa.EvalBoolRes;
import boa.EvalRes;
import boa.If;
import emfswitch.emfswitch.EmfswitchSwitchImplementation;

public class IfOperation extends ExprOperation {
  private final If it;

  private final EmfswitchSwitchImplementation emfswitch;

  public IfOperation(If it, EmfswitchSwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }

  public EvalRes eval(Ctx ctx) {
    EvalRes result;
    EvalRes vcond = ((EvalRes)((emfswitch.emfswitch.operation.ExprOperation) emfswitch.doSwitch(this.it.getCond())).eval(ctx));
    if(vcond instanceof boa.EvalBoolRes) {
      EvalBoolRes bvcond = ((EvalBoolRes)vcond);
      if(bvcond.isValue()) {
        result = ((emfswitch.emfswitch.operation.ExprOperation) emfswitch.doSwitch(this.it.getThn())).eval(ctx);
      }
      else {
        result = ((emfswitch.emfswitch.operation.ExprOperation) emfswitch.doSwitch(this.it.getEls())).eval(ctx);
      }
    }
    else {
      result = null;
    }
    return result;
  }
}
