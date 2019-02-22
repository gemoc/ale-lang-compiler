package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.ArrayTypeRef;

public class ArrayTypeRefOperation extends TypeRefOperation {
  private final ArrayTypeRef it;

  private final SwitchImplementation emfswitch;

  public ArrayTypeRefOperation(ArrayTypeRef it, SwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }
}
