package emfswitch.emfswitch.operation;

import boa.Ctx;
import boa.EvalBoolRes;
import boa.EvalRes;
import boa.Not;
import emfswitch.emfswitch.EmfswitchSwitchImplementation;

public class NotOperation extends ExprOperation {
  private final Not it;

  private final EmfswitchSwitchImplementation emfswitch;

  public NotOperation(Not it, EmfswitchSwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }

  public EvalRes eval(Ctx ctx) {
    EvalRes result;
    EvalRes vvalue = ((EvalRes)((emfswitch.emfswitch.operation.ExprOperation) emfswitch.doSwitch(this.it.getValue())).eval(ctx));
    if(vvalue instanceof boa.EvalBoolRes) {
      EvalBoolRes bvvalue = ((EvalBoolRes)vvalue);
      EvalBoolRes ret = ((EvalBoolRes)boa.BoaFactory.eINSTANCE.createEvalBoolRes());
      ret.setValue(!(bvvalue.isValue()));
      result = ret;
    }
    else {
      result = null;
    }
    return result;
  }
}
