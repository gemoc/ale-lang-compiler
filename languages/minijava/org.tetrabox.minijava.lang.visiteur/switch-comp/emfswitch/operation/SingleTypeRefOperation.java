package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.SingleTypeRef;

public class SingleTypeRefOperation extends TypeRefOperation {
  private final SingleTypeRef it;

  private final SwitchImplementation emfswitch;

  public SingleTypeRefOperation(SingleTypeRef it, SwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }
}
