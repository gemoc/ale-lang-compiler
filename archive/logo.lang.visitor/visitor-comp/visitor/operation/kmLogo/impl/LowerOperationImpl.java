package visitor.operation.kmLogo.impl;

import kmLogo.visitor.kmLogo.Lower;
import kmLogo.visitor.kmLogo.Turtle;
import visitor.VisitorInterface;
import visitor.operation.kmLogo.LowerOperation;

public class LowerOperationImpl extends BinaryExpOperationImpl implements LowerOperation {
  private final Lower it;

  private final VisitorInterface vis;

  public LowerOperationImpl(Lower it, VisitorInterface vis) {
    super(it, vis);
    this.it = it;
    this.vis = vis;
  }

  public double eval(Turtle turtle) {
    double result;
    if((((visitor.operation.kmLogo.ExpressionOperation)this.it.getLhs().accept(vis)).eval(turtle)) < (((visitor.operation.kmLogo.ExpressionOperation)this.it.getRhs().accept(vis)).eval(turtle))) {
      result = 1.0;
    }
    else {
      result = 0.0;
    }
    return result;
  }
}
