package emfswitch.emfswitch.operation;

import emfswitch.emfswitch.EmfswitchSwitchImplementation;
import kmLogo.Forward;
import kmLogo.Turtle;

public class ForwardOperation extends PrimitiveOperation {
  private final Forward it;

  private final EmfswitchSwitchImplementation emfswitch;

  public ForwardOperation(Forward it, EmfswitchSwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }

  public double eval(Turtle turtle) {
    double result;
    double move = ((double)/*CASEA*/((emfswitch.emfswitch.operation.ExpressionOperation) emfswitch.doSwitch(this.it.getSteps())).eval(turtle));
    /*CASEA*/((emfswitch.emfswitch.operation.TurtleOperation) emfswitch.doSwitch(turtle)).forward(move);
    result = 0.0;
    return result;
  }
}
