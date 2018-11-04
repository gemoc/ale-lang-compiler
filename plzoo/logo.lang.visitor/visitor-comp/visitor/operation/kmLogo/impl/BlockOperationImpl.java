package visitor.operation.kmLogo.impl;

import kmLogo.visitor.kmLogo.Block;
import kmLogo.visitor.kmLogo.Instruction;
import kmLogo.visitor.kmLogo.Turtle;
import visitor.VisitorInterface;
import visitor.operation.kmLogo.BlockOperation;

public class BlockOperationImpl extends InstructionOperationImpl implements BlockOperation {
  private final Block it;

  private final VisitorInterface vis;

  public BlockOperationImpl(Block it, VisitorInterface vis) {
    super(it, vis);
    this.it = it;
    this.vis = vis;
  }

  public double eval(Turtle turtle) {
    double result;
    for(Instruction inst: this.it.getInstructions()) {
      ((visitor.operation.kmLogo.InstructionOperation)inst.accept(vis)).eval(turtle);
    }
    result = 0.0;
    return result;
  }
}
