package visitor.operation.kmLogo.impl;

import kmLogo.visitor.kmLogo.UnaryExpression;
import visitor.VisitorInterface;
import visitor.operation.kmLogo.UnaryExpressionOperation;

public abstract class UnaryExpressionOperationImpl extends ExpressionOperationImpl implements UnaryExpressionOperation {
  private final UnaryExpression it;

  private final VisitorInterface vis;

  public UnaryExpressionOperationImpl(UnaryExpression it, VisitorInterface vis) {
    super(it, vis);
    this.it = it;
    this.vis = vis;
  }
}
