package emfswitch.emfswitch.operation;

import boa.EvalIntRes;
import emfswitch.emfswitch.EmfswitchSwitchImplementation;

public class EvalIntResOperation extends EvalResOperation {
  private final EvalIntRes it;

  private final EmfswitchSwitchImplementation emfswitch;

  public EvalIntResOperation(EvalIntRes it, EmfswitchSwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }
}
