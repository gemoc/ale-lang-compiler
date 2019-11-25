package visitor.operation.kmLogo.impl;

import kmLogo.visitor.kmLogo.If;
import kmLogo.visitor.kmLogo.Turtle;
import visitor.VisitorInterface;
import visitor.operation.kmLogo.IfOperation;

public class IfOperationImpl extends ControlStructureOperationImpl implements IfOperation {
  private final If it;

  private final VisitorInterface vis;

  public IfOperationImpl(If it, VisitorInterface vis) {
    super(it, vis);
    this.it = it;
    this.vis = vis;
  }

  public double eval(Turtle turtle) {
    double result;
    if((((visitor.operation.kmLogo.ExpressionOperation)this.it.getCondition().accept(vis)).eval(turtle)) != (0.0)) {
      result = ((visitor.operation.kmLogo.BlockOperation)this.it.getThenPart().accept(vis)).eval(turtle);
    }
    else {
      if((this.it.getElsePart()) != (null)) {
        result = ((visitor.operation.kmLogo.BlockOperation)this.it.getElsePart().accept(vis)).eval(turtle);
      }
      else {
        result = 0.0;
      }
    }
    return result;
  }
}
