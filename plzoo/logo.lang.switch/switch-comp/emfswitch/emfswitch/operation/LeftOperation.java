package emfswitch.emfswitch.operation;

import emfswitch.emfswitch.EmfswitchSwitchImplementation;
import kmLogo.Left;
import kmLogo.Turtle;

public class LeftOperation extends PrimitiveOperation {
  private final Left it;

  private final EmfswitchSwitchImplementation emfswitch;

  public LeftOperation(Left it, EmfswitchSwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }

  public double eval(Turtle turtle) {
    double result;
    double angle = ((double)/*CASEA*/((emfswitch.emfswitch.operation.ExpressionOperation) emfswitch.doSwitch(this.it.getAngle())).eval(turtle));
    /*CASEA*/((emfswitch.emfswitch.operation.TurtleOperation) emfswitch.doSwitch(turtle)).rotate(angle);
    result = 0.0;
    return result;
  }
}
