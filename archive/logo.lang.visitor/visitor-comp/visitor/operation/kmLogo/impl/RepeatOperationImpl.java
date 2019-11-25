package visitor.operation.kmLogo.impl;

import kmLogo.visitor.kmLogo.Repeat;
import kmLogo.visitor.kmLogo.Turtle;
import visitor.VisitorInterface;
import visitor.operation.kmLogo.RepeatOperation;

public class RepeatOperationImpl extends ControlStructureOperationImpl implements RepeatOperation {
  private final Repeat it;

  private final VisitorInterface vis;

  public RepeatOperationImpl(Repeat it, VisitorInterface vis) {
    super(it, vis);
    this.it = it;
    this.vis = vis;
  }

  public double eval(Turtle turtle) {
    double result;
    double time = ((double)((visitor.operation.kmLogo.ExpressionOperation)this.it.getCondition().accept(vis)).eval(turtle));
    while ((time) > (0.0)) {
      ((visitor.operation.kmLogo.BlockOperation)this.it.getBlock().accept(vis)).eval(turtle);
      time = (time) - (1.0);
    }
    result = 0.0;
    return result;
  }
}
