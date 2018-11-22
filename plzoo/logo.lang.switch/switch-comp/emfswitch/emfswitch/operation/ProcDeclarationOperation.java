package emfswitch.emfswitch.operation;

import emfswitch.emfswitch.EmfswitchSwitchImplementation;
import kmLogo.Instruction;
import kmLogo.ProcDeclaration;
import kmLogo.Turtle;

public class ProcDeclarationOperation extends InstructionOperation {
  private final ProcDeclaration it;

  private final EmfswitchSwitchImplementation emfswitch;

  public ProcDeclarationOperation(ProcDeclaration it, EmfswitchSwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }

  public double eval(Turtle turtle) {
    double result;
    result = 0.0;
    for(Instruction instr: this.it.getInstructions()) {
      result = ((emfswitch.emfswitch.operation.InstructionOperation) emfswitch.doSwitch(instr)).eval(turtle);
    }
    return result;
  }
}
