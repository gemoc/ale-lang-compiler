package emfswitch.emfswitch.operation;

import emfswitch.emfswitch.EmfswitchSwitchImplementation;
import kmLogo.BinaryExp;

public class BinaryExpOperation extends ExpressionOperation {
  private final BinaryExp it;

  private final EmfswitchSwitchImplementation emfswitch;

  public BinaryExpOperation(BinaryExp it, EmfswitchSwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }
}
