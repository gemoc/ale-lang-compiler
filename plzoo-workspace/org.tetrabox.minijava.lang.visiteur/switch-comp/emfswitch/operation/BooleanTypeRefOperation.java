package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.BooleanTypeRef;

public class BooleanTypeRefOperation extends SingleTypeRefOperation {
  private final BooleanTypeRef it;

  private final SwitchImplementation emfswitch;

  public BooleanTypeRefOperation(BooleanTypeRef it, SwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }
}
