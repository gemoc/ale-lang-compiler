package visitor.operation.kmLogo.impl;

import kmLogo.visitor.kmLogo.Div;
import kmLogo.visitor.kmLogo.Turtle;
import visitor.VisitorInterface;
import visitor.operation.kmLogo.DivOperation;

public class DivOperationImpl extends BinaryExpOperationImpl implements DivOperation {
  private final Div it;

  private final VisitorInterface vis;

  public DivOperationImpl(Div it, VisitorInterface vis) {
    super(it, vis);
    this.it = it;
    this.vis = vis;
  }

  public double eval(Turtle turtle) {
    double result;
    if((((visitor.operation.kmLogo.ExpressionOperation)this.it.getRhs().accept(vis)).eval(turtle)) != (0.0)) {
      result = (((visitor.operation.kmLogo.ExpressionOperation)this.it.getLhs().accept(vis)).eval(turtle)) / (((visitor.operation.kmLogo.ExpressionOperation)this.it.getRhs().accept(vis)).eval(turtle));
    }
    else {
      result = 0.0;
    }
    return result;
  }
}
