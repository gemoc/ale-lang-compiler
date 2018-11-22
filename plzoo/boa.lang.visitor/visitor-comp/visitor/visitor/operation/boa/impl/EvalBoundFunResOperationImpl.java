package visitor.visitor.operation.boa.impl;

import visitor.boa.visitor.boa.EvalBoundFunRes;
import visitor.visitor.VisitorInterface;
import visitor.visitor.operation.boa.EvalBoundFunResOperation;

public class EvalBoundFunResOperationImpl extends EvalFunResOperationImpl implements EvalBoundFunResOperation {
  private final EvalBoundFunRes it;

  private final VisitorInterface vis;

  public EvalBoundFunResOperationImpl(EvalBoundFunRes it, VisitorInterface vis) {
    super(it, vis);
    this.it = it;
    this.vis = vis;
  }
}
