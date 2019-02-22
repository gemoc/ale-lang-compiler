package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.NewCall;

public class NewCallOperation extends CallOperation {
  private final NewCall it;

  private final SwitchImplementation emfswitch;

  public NewCallOperation(NewCall it, SwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }
}
