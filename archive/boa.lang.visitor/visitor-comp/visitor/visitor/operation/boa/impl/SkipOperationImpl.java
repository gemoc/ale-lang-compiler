package visitor.visitor.operation.boa.impl;

import visitor.boa.visitor.boa.Ctx;
import visitor.boa.visitor.boa.EvalRes;
import visitor.boa.visitor.boa.Skip;
import visitor.visitor.VisitorInterface;
import visitor.visitor.operation.boa.SkipOperation;

public class SkipOperationImpl extends ExprOperationImpl implements SkipOperation {
  private final Skip it;

  private final VisitorInterface vis;

  public SkipOperationImpl(Skip it, VisitorInterface vis) {
    super(it, vis);
    this.it = it;
    this.vis = vis;
  }

  public EvalRes eval(Ctx ctx) {
    EvalRes result;
    result = visitor.boa.visitor.boa.BoaFactory.eINSTANCE.createEvalMapRes();
    return result;
  }
}
