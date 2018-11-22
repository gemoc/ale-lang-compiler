package emfswitch.emfswitch.operation;

import emfswitch.emfswitch.EmfswitchSwitchImplementation;
import kmLogo.If;
import kmLogo.Turtle;

public class IfOperation extends ControlStructureOperation {
  private final If it;

  private final EmfswitchSwitchImplementation emfswitch;

  public IfOperation(If it, EmfswitchSwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }

  public double eval(Turtle turtle) {
    double result;
    if((((emfswitch.emfswitch.operation.ExpressionOperation) emfswitch.doSwitch(this.it.getCondition())).eval(turtle)) != (0.0)) {
      result = ((emfswitch.emfswitch.operation.BlockOperation) emfswitch.doSwitch(this.it.getThenPart())).eval(turtle);
    }
    else {
      if((this.it.getElsePart()) != (null)) {
        result = ((emfswitch.emfswitch.operation.BlockOperation) emfswitch.doSwitch(this.it.getElsePart())).eval(turtle);
      }
      else {
        result = 0.0;
      }
    }
    return result;
  }
}
