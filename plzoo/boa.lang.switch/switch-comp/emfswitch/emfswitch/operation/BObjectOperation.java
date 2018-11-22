package emfswitch.emfswitch.operation;

import boa.BObject;
import boa.Ctx;
import boa.EvalMapRes;
import boa.EvalRes;
import boa.Field;
import emfswitch.emfswitch.EmfswitchSwitchImplementation;

public class BObjectOperation extends ExprOperation {
  private final BObject it;

  private final EmfswitchSwitchImplementation emfswitch;

  public BObjectOperation(BObject it, EmfswitchSwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }

  public EvalRes eval(Ctx ctx) {
    EvalRes result;
    EvalMapRes ret = ((EvalMapRes)boa.BoaFactory.eINSTANCE.createEvalMapRes());
    for(Field x: this.it.getFields()) {
      EvalRes v = ((EvalRes)((emfswitch.emfswitch.operation.ExprOperation) emfswitch.doSwitch(x.getValue())).eval(ctx));
      execboa.MapService.put(ret.getValues(), x.getName(), v);
    }
    result = ret;
    return result;
  }
}
