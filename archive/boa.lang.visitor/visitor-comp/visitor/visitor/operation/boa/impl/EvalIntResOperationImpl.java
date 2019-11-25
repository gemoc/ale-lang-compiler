package visitor.visitor.operation.boa.impl;

import visitor.boa.visitor.boa.EvalIntRes;
import visitor.visitor.VisitorInterface;
import visitor.visitor.operation.boa.EvalIntResOperation;

public class EvalIntResOperationImpl extends EvalResOperationImpl implements EvalIntResOperation {
  private final EvalIntRes it;

  private final VisitorInterface vis;

  public EvalIntResOperationImpl(EvalIntRes it, VisitorInterface vis) {
    super(it, vis);
    this.it = it;
    this.vis = vis;
  }
}
