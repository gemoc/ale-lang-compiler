package emfswitch.emfswitch.operation;

import emfswitch.emfswitch.EmfswitchSwitchImplementation;
import kmLogo.Lower;
import kmLogo.Turtle;

public class LowerOperation extends BinaryExpOperation {
  private final Lower it;

  private final EmfswitchSwitchImplementation emfswitch;

  public LowerOperation(Lower it, EmfswitchSwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }

  public double eval(Turtle turtle) {
    double result;
    if((((emfswitch.emfswitch.operation.ExpressionOperation) emfswitch.doSwitch(this.it.getLhs())).eval(turtle)) < (((emfswitch.emfswitch.operation.ExpressionOperation) emfswitch.doSwitch(this.it.getRhs())).eval(turtle))) {
      result = 1.0;
    }
    else {
      result = 0.0;
    }
    return result;
  }
}
