package emfswitch.emfswitch.operation;

import emfswitch.emfswitch.EmfswitchSwitchImplementation;
import kmLogo.Div;
import kmLogo.Turtle;

public class DivOperation extends BinaryExpOperation {
  private final Div it;

  private final EmfswitchSwitchImplementation emfswitch;

  public DivOperation(Div it, EmfswitchSwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }

  public double eval(Turtle turtle) {
    double result;
    if((((emfswitch.emfswitch.operation.ExpressionOperation) emfswitch.doSwitch(this.it.getRhs())).eval(turtle)) != (0.0)) {
      result = (((emfswitch.emfswitch.operation.ExpressionOperation) emfswitch.doSwitch(this.it.getLhs())).eval(turtle)) / (((emfswitch.emfswitch.operation.ExpressionOperation) emfswitch.doSwitch(this.it.getRhs())).eval(turtle));
    }
    else {
      result = 0.0;
    }
    return result;
  }
}
