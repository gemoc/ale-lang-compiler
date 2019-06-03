package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.Field;

public class FieldOperation extends MemberOperation {
  private final Field it;

  private final SwitchImplementation emfswitch;

  public FieldOperation(Field it, SwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }
}
