package visitor.operation.kmLogo.impl;

import kmLogo.visitor.kmLogo.Minus;
import kmLogo.visitor.kmLogo.Turtle;
import visitor.VisitorInterface;
import visitor.operation.kmLogo.MinusOperation;

public class MinusOperationImpl extends BinaryExpOperationImpl implements MinusOperation {
  private final Minus it;

  private final VisitorInterface vis;

  public MinusOperationImpl(Minus it, VisitorInterface vis) {
    super(it, vis);
    this.it = it;
    this.vis = vis;
  }

  public double eval(Turtle turtle) {
    double result;
    result = (((visitor.operation.kmLogo.ExpressionOperation)this.it.getLhs().accept(vis)).eval(turtle)) - (((visitor.operation.kmLogo.ExpressionOperation)this.it.getRhs().accept(vis)).eval(turtle));
    return result;
  }
}
