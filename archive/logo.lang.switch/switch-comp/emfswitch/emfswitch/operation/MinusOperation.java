package emfswitch.emfswitch.operation;

import emfswitch.emfswitch.EmfswitchSwitchImplementation;
import kmLogo.Minus;
import kmLogo.Turtle;

public class MinusOperation extends BinaryExpOperation {
  private final Minus it;

  private final EmfswitchSwitchImplementation emfswitch;

  public MinusOperation(Minus it, EmfswitchSwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }

  public double eval(Turtle turtle) {
    double result;
    result = (/*CASEA*/((emfswitch.emfswitch.operation.ExpressionOperation) emfswitch.doSwitch(this.it.getLhs())).eval(turtle)) - (/*CASEA*/((emfswitch.emfswitch.operation.ExpressionOperation) emfswitch.doSwitch(this.it.getRhs())).eval(turtle));
    return result;
  }
}
