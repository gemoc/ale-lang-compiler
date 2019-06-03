package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.Call;

public class CallOperation {
  private final Call it;

  private final SwitchImplementation emfswitch;

  public CallOperation(Call it, SwitchImplementation emfswitch) {
    this.it = it;
    this.emfswitch = emfswitch;
  }
}
