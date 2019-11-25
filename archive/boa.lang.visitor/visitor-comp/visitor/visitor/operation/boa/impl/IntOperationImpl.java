package visitor.visitor.operation.boa.impl;

import visitor.boa.visitor.boa.Ctx;
import visitor.boa.visitor.boa.EvalIntRes;
import visitor.boa.visitor.boa.EvalRes;
import visitor.boa.visitor.boa.Int;
import visitor.visitor.VisitorInterface;
import visitor.visitor.operation.boa.IntOperation;

public class IntOperationImpl extends ExprOperationImpl implements IntOperation {
  private final Int it;

  private final VisitorInterface vis;

  public IntOperationImpl(Int it, VisitorInterface vis) {
    super(it, vis);
    this.it = it;
    this.vis = vis;
  }

  public EvalRes eval(Ctx ctx) {
    EvalRes result;
    EvalIntRes ret = ((EvalIntRes)visitor.boa.visitor.boa.BoaFactory.eINSTANCE.createEvalIntRes());
    ret.setValue(this.it.getValue());
    result = ret;
    return result;
  }
}
