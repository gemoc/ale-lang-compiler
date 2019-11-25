package visitor.operation.kmLogo.impl;

import kmLogo.visitor.kmLogo.Primitive;
import visitor.VisitorInterface;
import visitor.operation.kmLogo.PrimitiveOperation;

public abstract class PrimitiveOperationImpl extends InstructionOperationImpl implements PrimitiveOperation {
  private final Primitive it;

  private final VisitorInterface vis;

  public PrimitiveOperationImpl(Primitive it, VisitorInterface vis) {
    super(it, vis);
    this.it = it;
    this.vis = vis;
  }
}
