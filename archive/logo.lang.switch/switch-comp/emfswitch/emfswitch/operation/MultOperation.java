package emfswitch.emfswitch.operation;

import emfswitch.emfswitch.EmfswitchSwitchImplementation;
import kmLogo.Mult;
import kmLogo.Turtle;

public class MultOperation extends BinaryExpOperation {
  private final Mult it;

  private final EmfswitchSwitchImplementation emfswitch;

  public MultOperation(Mult it, EmfswitchSwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }

  public double eval(Turtle turtle) {
    double result;
    result = (/*CASEA*/((emfswitch.emfswitch.operation.ExpressionOperation) emfswitch.doSwitch(this.it.getLhs())).eval(turtle)) * (/*CASEA*/((emfswitch.emfswitch.operation.ExpressionOperation) emfswitch.doSwitch(this.it.getRhs())).eval(turtle));
    return result;
  }
}
