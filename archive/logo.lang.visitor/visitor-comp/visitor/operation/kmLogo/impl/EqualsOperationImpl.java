package visitor.operation.kmLogo.impl;

import kmLogo.visitor.kmLogo.Equals;
import kmLogo.visitor.kmLogo.Turtle;
import visitor.VisitorInterface;
import visitor.operation.kmLogo.EqualsOperation;

public class EqualsOperationImpl extends BinaryExpOperationImpl implements EqualsOperation {
  private final Equals it;

  private final VisitorInterface vis;

  public EqualsOperationImpl(Equals it, VisitorInterface vis) {
    super(it, vis);
    this.it = it;
    this.vis = vis;
  }

  public double eval(Turtle turtle) {
    double result;
    if(java.util.Objects.equals((((visitor.operation.kmLogo.ExpressionOperation)this.it.getLhs().accept(vis)).eval(turtle)), (((visitor.operation.kmLogo.ExpressionOperation)this.it.getRhs().accept(vis)).eval(turtle)))) {
      result = 1.0;
    }
    else {
      result = 0.0;
    }
    return result;
  }
}
