package emfswitch.emfswitch.operation;

import emfswitch.emfswitch.EmfswitchSwitchImplementation;
import kmLogo.Parameter;

public class ParameterOperation {
  private final Parameter it;

  private final EmfswitchSwitchImplementation emfswitch;

  public ParameterOperation(Parameter it, EmfswitchSwitchImplementation emfswitch) {
    this.it = it;
    this.emfswitch = emfswitch;
  }
}
