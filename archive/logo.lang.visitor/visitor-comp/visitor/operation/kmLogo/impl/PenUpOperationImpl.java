package visitor.operation.kmLogo.impl;

import kmLogo.visitor.kmLogo.PenUp;
import kmLogo.visitor.kmLogo.Turtle;
import visitor.VisitorInterface;
import visitor.operation.kmLogo.PenUpOperation;

public class PenUpOperationImpl extends PrimitiveOperationImpl implements PenUpOperation {
  private final PenUp it;

  private final VisitorInterface vis;

  public PenUpOperationImpl(PenUp it, VisitorInterface vis) {
    super(it, vis);
    this.it = it;
    this.vis = vis;
  }

  public double eval(Turtle turtle) {
    double result;
    turtle.setPenUp(true);
    result = 0.0;
    return result;
  }
}
