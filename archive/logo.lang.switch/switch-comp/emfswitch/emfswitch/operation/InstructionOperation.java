package emfswitch.emfswitch.operation;

import emfswitch.emfswitch.EmfswitchSwitchImplementation;
import kmLogo.Instruction;
import kmLogo.Turtle;

public class InstructionOperation {
  private final Instruction it;

  private final EmfswitchSwitchImplementation emfswitch;

  public InstructionOperation(Instruction it, EmfswitchSwitchImplementation emfswitch) {
    this.it = it;
    this.emfswitch = emfswitch;
  }

  public double eval(Turtle turtle) {
    double result;
    result = 0.0;
    return result;
  }
}
