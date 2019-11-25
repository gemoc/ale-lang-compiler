package emfswitch.emfswitch.operation;

import boa.Ctx;
import boa.EvalRes;
import boa.Skip;
import emfswitch.emfswitch.EmfswitchSwitchImplementation;

public class SkipOperation extends ExprOperation {
  private final Skip it;

  private final EmfswitchSwitchImplementation emfswitch;

  public SkipOperation(Skip it, EmfswitchSwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }

  public EvalRes eval(Ctx ctx) {
    EvalRes result;
    result = boa.BoaFactory.eINSTANCE.createEvalMapRes();
    return result;
  }
}
