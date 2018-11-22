package emfswitch.emfswitch.operation;

import emfswitch.emfswitch.EmfswitchSwitchImplementation;
import kmLogo.Constant;
import kmLogo.Turtle;

public class ConstantOperation extends ExpressionOperation {
  private final Constant it;

  private final EmfswitchSwitchImplementation emfswitch;

  public ConstantOperation(Constant it, EmfswitchSwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }

  public double eval(Turtle turtle) {
    double result;
    result = this.it.getValue();
    return result;
  }
}
