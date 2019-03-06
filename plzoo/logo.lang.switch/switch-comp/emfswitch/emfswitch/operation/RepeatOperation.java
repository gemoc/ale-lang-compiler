package emfswitch.emfswitch.operation;

import emfswitch.emfswitch.EmfswitchSwitchImplementation;
import kmLogo.Repeat;
import kmLogo.Turtle;

public class RepeatOperation extends ControlStructureOperation {
  private final Repeat it;

  private final EmfswitchSwitchImplementation emfswitch;

  public RepeatOperation(Repeat it, EmfswitchSwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }

  public double eval(Turtle turtle) {
    double result;
    double time = ((double)/*CASEA*/((emfswitch.emfswitch.operation.ExpressionOperation) emfswitch.doSwitch(this.it.getCondition())).eval(turtle));
    while ((time) > (0.0)) {
      /*CASEA*/((emfswitch.emfswitch.operation.BlockOperation) emfswitch.doSwitch(this.it.getBlock())).eval(turtle);
      time = (time) - (1.0);
    }
    result = 0.0;
    return result;
  }
}
