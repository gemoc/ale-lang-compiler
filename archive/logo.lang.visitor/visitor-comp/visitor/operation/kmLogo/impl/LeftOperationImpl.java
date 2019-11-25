package visitor.operation.kmLogo.impl;

import kmLogo.visitor.kmLogo.Left;
import kmLogo.visitor.kmLogo.Turtle;
import visitor.VisitorInterface;
import visitor.operation.kmLogo.LeftOperation;

public class LeftOperationImpl extends PrimitiveOperationImpl implements LeftOperation {
  private final Left it;

  private final VisitorInterface vis;

  public LeftOperationImpl(Left it, VisitorInterface vis) {
    super(it, vis);
    this.it = it;
    this.vis = vis;
  }

  public double eval(Turtle turtle) {
    double result;
    double angle = ((double)((visitor.operation.kmLogo.ExpressionOperation)this.it.getAngle().accept(vis)).eval(turtle));
    ((visitor.operation.kmLogo.TurtleOperation)turtle.accept(vis)).rotate(angle);
    result = 0.0;
    return result;
  }
}
