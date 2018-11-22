package emfswitch.emfswitch.operation;

import emfswitch.emfswitch.EmfswitchSwitchImplementation;
import kmLogo.Back;
import kmLogo.Turtle;

public class BackOperation extends PrimitiveOperation {
  private final Back it;

  private final EmfswitchSwitchImplementation emfswitch;

  public BackOperation(Back it, EmfswitchSwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }

  public double eval(Turtle turtle) {
    double result;
    double move = ((double)((emfswitch.emfswitch.operation.ExpressionOperation) emfswitch.doSwitch(this.it.getSteps())).eval(turtle));
    ((emfswitch.emfswitch.operation.TurtleOperation) emfswitch.doSwitch(turtle)).forward(-(move));
    result = 0.0;
    return result;
  }
}
