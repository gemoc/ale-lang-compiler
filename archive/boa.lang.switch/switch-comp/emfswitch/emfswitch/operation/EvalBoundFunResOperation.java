package emfswitch.emfswitch.operation;

import boa.EvalBoundFunRes;
import emfswitch.emfswitch.EmfswitchSwitchImplementation;

public class EvalBoundFunResOperation extends EvalFunResOperation {
  private final EvalBoundFunRes it;

  private final EmfswitchSwitchImplementation emfswitch;

  public EvalBoundFunResOperation(EvalBoundFunRes it, EmfswitchSwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }
}
