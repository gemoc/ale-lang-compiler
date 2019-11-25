package emfswitch.emfswitch.operation;

import boa.EvalRes;
import emfswitch.emfswitch.EmfswitchSwitchImplementation;

public class EvalResOperation {
  private final EvalRes it;

  private final EmfswitchSwitchImplementation emfswitch;

  public EvalResOperation(EvalRes it, EmfswitchSwitchImplementation emfswitch) {
    this.it = it;
    this.emfswitch = emfswitch;
  }
}
