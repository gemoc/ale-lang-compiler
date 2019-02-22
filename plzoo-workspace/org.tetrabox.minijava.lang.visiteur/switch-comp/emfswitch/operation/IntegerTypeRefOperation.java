package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.IntegerTypeRef;

public class IntegerTypeRefOperation extends SingleTypeRefOperation {
  private final IntegerTypeRef it;

  private final SwitchImplementation emfswitch;

  public IntegerTypeRefOperation(IntegerTypeRef it, SwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }
}
