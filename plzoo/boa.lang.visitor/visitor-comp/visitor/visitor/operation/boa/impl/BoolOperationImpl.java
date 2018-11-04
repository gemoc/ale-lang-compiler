package visitor.visitor.operation.boa.impl;

import visitor.boa.visitor.boa.Bool;
import visitor.boa.visitor.boa.Ctx;
import visitor.boa.visitor.boa.EvalBoolRes;
import visitor.boa.visitor.boa.EvalRes;
import visitor.visitor.VisitorInterface;
import visitor.visitor.operation.boa.BoolOperation;

public class BoolOperationImpl extends ExprOperationImpl implements BoolOperation {
  private final Bool it;

  private final VisitorInterface vis;

  public BoolOperationImpl(Bool it, VisitorInterface vis) {
    super(it, vis);
    this.it = it;
    this.vis = vis;
  }

  public EvalRes eval(Ctx ctx) {
    EvalRes result;
    EvalBoolRes ret = ((EvalBoolRes)visitor.boa.visitor.boa.BoaFactory.eINSTANCE.createEvalBoolRes());
    ret.setValue(this.it.isValue());
    result = ret;
    return result;
  }
}
