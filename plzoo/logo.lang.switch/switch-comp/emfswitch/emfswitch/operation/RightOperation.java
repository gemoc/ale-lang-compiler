package emfswitch.emfswitch.operation;

import emfswitch.emfswitch.EmfswitchSwitchImplementation;
import kmLogo.Right;
import kmLogo.Turtle;

public class RightOperation extends PrimitiveOperation {
  private final Right it;

  private final EmfswitchSwitchImplementation emfswitch;

  public RightOperation(Right it, EmfswitchSwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }

  public double eval(Turtle turtle) {
    double result;
    double angle = ((double)((emfswitch.emfswitch.operation.ExpressionOperation) emfswitch.doSwitch(this.it.getAngle())).eval(turtle));
    ((emfswitch.emfswitch.operation.TurtleOperation) emfswitch.doSwitch(turtle)).rotate(-(angle));
    result = 0.0;
    return result;
  }
}
