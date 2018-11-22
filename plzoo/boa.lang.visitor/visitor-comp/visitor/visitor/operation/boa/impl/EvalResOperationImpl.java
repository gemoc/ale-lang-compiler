package visitor.visitor.operation.boa.impl;

import visitor.boa.visitor.boa.EvalRes;
import visitor.visitor.VisitorInterface;
import visitor.visitor.operation.boa.EvalResOperation;

public abstract class EvalResOperationImpl implements EvalResOperation {
  private final EvalRes it;

  private final VisitorInterface vis;

  public EvalResOperationImpl(EvalRes it, VisitorInterface vis) {
    this.it = it;
    this.vis = vis;
  }
}
