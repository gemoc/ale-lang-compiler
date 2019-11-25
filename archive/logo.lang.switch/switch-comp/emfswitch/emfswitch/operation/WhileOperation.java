package emfswitch.emfswitch.operation;

import emfswitch.emfswitch.EmfswitchSwitchImplementation;
import kmLogo.Turtle;
import kmLogo.While;

public class WhileOperation extends ControlStructureOperation {
  private final While it;

  private final EmfswitchSwitchImplementation emfswitch;

  public WhileOperation(While it, EmfswitchSwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }

  public double eval(Turtle turtle) {
    double result;
    while ((/*CASEA*/((emfswitch.emfswitch.operation.ExpressionOperation) emfswitch.doSwitch(this.it.getCondition())).eval(turtle)) > (0.0)) {
      /*CASEA*/((emfswitch.emfswitch.operation.BlockOperation) emfswitch.doSwitch(this.it.getBlock())).eval(turtle);
    }
    result = 0.0;
    return result;
  }
}
