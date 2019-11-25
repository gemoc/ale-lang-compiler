package visitor.visitor.operation.boa.impl;

import visitor.boa.visitor.boa.ArithOp;
import visitor.visitor.VisitorInterface;
import visitor.visitor.operation.boa.ArithOpOperation;

public abstract class ArithOpOperationImpl extends ExprOperationImpl implements ArithOpOperation {
  private final ArithOp it;

  private final VisitorInterface vis;

  public ArithOpOperationImpl(ArithOp it, VisitorInterface vis) {
    super(it, vis);
    this.it = it;
    this.vis = vis;
  }
}
