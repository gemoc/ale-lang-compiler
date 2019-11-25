package visitor.operation.kmLogo.impl;

import kmLogo.visitor.kmLogo.Right;
import kmLogo.visitor.kmLogo.Turtle;
import visitor.VisitorInterface;
import visitor.operation.kmLogo.RightOperation;

public class RightOperationImpl extends PrimitiveOperationImpl implements RightOperation {
  private final Right it;

  private final VisitorInterface vis;

  public RightOperationImpl(Right it, VisitorInterface vis) {
    super(it, vis);
    this.it = it;
    this.vis = vis;
  }

  public double eval(Turtle turtle) {
    double result;
    double angle = ((double)((visitor.operation.kmLogo.ExpressionOperation)this.it.getAngle().accept(vis)).eval(turtle));
    ((visitor.operation.kmLogo.TurtleOperation)turtle.accept(vis)).rotate(-(angle));
    result = 0.0;
    return result;
  }
}
