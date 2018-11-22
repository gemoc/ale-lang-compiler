package visitor.operation.kmLogo.impl;

import kmLogo.visitor.kmLogo.Instruction;
import kmLogo.visitor.kmLogo.ProcDeclaration;
import kmLogo.visitor.kmLogo.Turtle;
import visitor.VisitorInterface;
import visitor.operation.kmLogo.ProcDeclarationOperation;

public class ProcDeclarationOperationImpl extends InstructionOperationImpl implements ProcDeclarationOperation {
  private final ProcDeclaration it;

  private final VisitorInterface vis;

  public ProcDeclarationOperationImpl(ProcDeclaration it, VisitorInterface vis) {
    super(it, vis);
    this.it = it;
    this.vis = vis;
  }

  public double eval(Turtle turtle) {
    double result;
    result = 0.0;
    for(Instruction instr: this.it.getInstructions()) {
      result = ((visitor.operation.kmLogo.InstructionOperation)instr.accept(vis)).eval(turtle);
    }
    return result;
  }
}
