package visitor.operation.kmLogo.impl;

import kmLogo.visitor.kmLogo.CallStack;
import visitor.VisitorInterface;
import visitor.operation.kmLogo.CallStackOperation;

public class CallStackOperationImpl implements CallStackOperation {
  private final CallStack it;

  private final VisitorInterface vis;

  public CallStackOperationImpl(CallStack it, VisitorInterface vis) {
    this.it = it;
    this.vis = vis;
  }
}
