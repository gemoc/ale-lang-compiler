package visitor.operation.kmLogo.impl;

import kmLogo.visitor.kmLogo.Forward;
import kmLogo.visitor.kmLogo.Turtle;
import visitor.VisitorInterface;
import visitor.operation.kmLogo.ForwardOperation;

public class ForwardOperationImpl extends PrimitiveOperationImpl implements ForwardOperation {
  private final Forward it;

  private final VisitorInterface vis;

  public ForwardOperationImpl(Forward it, VisitorInterface vis) {
    super(it, vis);
    this.it = it;
    this.vis = vis;
  }

  public double eval(Turtle turtle) {
    double result;
    double move = ((double)((visitor.operation.kmLogo.ExpressionOperation)this.it.getSteps().accept(vis)).eval(turtle));
    ((visitor.operation.kmLogo.TurtleOperation)turtle.accept(vis)).forward(move);
    result = 0.0;
    return result;
  }
}
