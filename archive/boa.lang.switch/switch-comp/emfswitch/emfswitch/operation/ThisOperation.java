package emfswitch.emfswitch.operation;

import boa.Ctx;
import boa.EvalMapRes;
import boa.EvalRes;
import boa.This;
import emfswitch.emfswitch.EmfswitchSwitchImplementation;

public class ThisOperation extends ExprOperation {
  private final This it;

  private final EmfswitchSwitchImplementation emfswitch;

  public ThisOperation(This it, EmfswitchSwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }

  public EvalRes eval(Ctx ctx) {
    EvalRes result;
    EvalMapRes ret = ((EvalMapRes)boa.BoaFactory.eINSTANCE.createEvalMapRes());
    execboa.MapService.putAll(ret.getValues(), ctx.getTh());
    result = ret;
    return result;
  }
}
