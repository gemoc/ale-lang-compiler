package visitor.operation.kmLogo.impl;

import kmLogo.visitor.kmLogo.Sin;
import kmLogo.visitor.kmLogo.Turtle;
import visitor.VisitorInterface;
import visitor.operation.kmLogo.SinOperation;

public class SinOperationImpl extends UnaryExpressionOperationImpl implements SinOperation {
  private final Sin it;

  private final VisitorInterface vis;

  public SinOperationImpl(Sin it, VisitorInterface vis) {
    super(it, vis);
    this.it = it;
    this.vis = vis;
  }

  public double eval(Turtle turtle) {
    double result;
    result = org.eclipse.emf.ecoretools.ale.core.interpreter.services.TrigoServices.sinus(((visitor.operation.kmLogo.ExpressionOperation)this.it.getExpression().accept(vis)).eval(turtle));
    return result;
  }
}
