package visitor.visitor.operation.boa.impl;

import visitor.boa.visitor.boa.EvalBoolRes;
import visitor.visitor.VisitorInterface;
import visitor.visitor.operation.boa.EvalBoolResOperation;

public class EvalBoolResOperationImpl extends EvalResOperationImpl implements EvalBoolResOperation {
  private final EvalBoolRes it;

  private final VisitorInterface vis;

  public EvalBoolResOperationImpl(EvalBoolRes it, VisitorInterface vis) {
    super(it, vis);
    this.it = it;
    this.vis = vis;
  }
}
