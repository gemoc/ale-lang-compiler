package visitor.operation.kmLogo.impl;

import kmLogo.visitor.kmLogo.StackFrame;
import visitor.VisitorInterface;
import visitor.operation.kmLogo.StackFrameOperation;

public class StackFrameOperationImpl implements StackFrameOperation {
  private final StackFrame it;

  private final VisitorInterface vis;

  public StackFrameOperationImpl(StackFrame it, VisitorInterface vis) {
    this.it = it;
    this.vis = vis;
  }
}
