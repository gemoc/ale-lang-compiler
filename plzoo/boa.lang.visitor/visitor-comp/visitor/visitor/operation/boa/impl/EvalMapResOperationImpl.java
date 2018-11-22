package visitor.visitor.operation.boa.impl;

import visitor.boa.visitor.boa.EvalMapRes;
import visitor.visitor.VisitorInterface;
import visitor.visitor.operation.boa.EvalMapResOperation;

public class EvalMapResOperationImpl extends EvalResOperationImpl implements EvalMapResOperation {
  private final EvalMapRes it;

  private final VisitorInterface vis;

  public EvalMapResOperationImpl(EvalMapRes it, VisitorInterface vis) {
    super(it, vis);
    this.it = it;
    this.vis = vis;
  }
}
