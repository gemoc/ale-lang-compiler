package emfswitch.emfswitch.operation;

import boa.Ctx;
import emfswitch.emfswitch.EmfswitchSwitchImplementation;

public class CtxOperation {
  private final Ctx it;

  private final EmfswitchSwitchImplementation emfswitch;

  public CtxOperation(Ctx it, EmfswitchSwitchImplementation emfswitch) {
    this.it = it;
    this.emfswitch = emfswitch;
  }
}
