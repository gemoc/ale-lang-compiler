package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.ObjectInstance;

public class ObjectInstanceOperation {
  private final ObjectInstance it;

  private final SwitchImplementation emfswitch;

  public ObjectInstanceOperation(ObjectInstance it, SwitchImplementation emfswitch) {
    this.it = it;
    this.emfswitch = emfswitch;
  }
}
