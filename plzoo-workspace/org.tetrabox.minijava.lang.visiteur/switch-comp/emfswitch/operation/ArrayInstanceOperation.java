package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.ArrayInstance;

public class ArrayInstanceOperation {
  private final ArrayInstance it;

  private final SwitchImplementation emfswitch;

  public ArrayInstanceOperation(ArrayInstance it, SwitchImplementation emfswitch) {
    this.it = it;
    this.emfswitch = emfswitch;
  }
}
