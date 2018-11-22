package emfswitch.emfswitch.operation;

import emfswitch.emfswitch.EmfswitchSwitchImplementation;
import kmLogo.Primitive;

public class PrimitiveOperation extends InstructionOperation {
  private final Primitive it;

  private final EmfswitchSwitchImplementation emfswitch;

  public PrimitiveOperation(Primitive it, EmfswitchSwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }
}
