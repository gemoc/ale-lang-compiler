package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.VoidTypeRef;

public class VoidTypeRefOperation extends SingleTypeRefOperation {
  private final VoidTypeRef it;

  private final SwitchImplementation emfswitch;

  public VoidTypeRefOperation(VoidTypeRef it, SwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }
}
