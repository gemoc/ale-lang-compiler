package visitor.visitor.operation.boa.impl;

import visitor.boa.visitor.boa.Ctx;
import visitor.visitor.VisitorInterface;
import visitor.visitor.operation.boa.CtxOperation;

public class CtxOperationImpl implements CtxOperation {
  private final Ctx it;

  private final VisitorInterface vis;

  public CtxOperationImpl(Ctx it, VisitorInterface vis) {
    this.it = it;
    this.vis = vis;
  }
}
