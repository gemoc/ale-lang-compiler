package visitor.visitor.operation.boa.impl;

import visitor.boa.visitor.boa.Ctx;
import visitor.boa.visitor.boa.EvalMapRes;
import visitor.boa.visitor.boa.EvalRes;
import visitor.boa.visitor.boa.This;
import visitor.visitor.VisitorInterface;
import visitor.visitor.operation.boa.ThisOperation;

public class ThisOperationImpl extends ExprOperationImpl implements ThisOperation {
  private final This it;

  private final VisitorInterface vis;

  public ThisOperationImpl(This it, VisitorInterface vis) {
    super(it, vis);
    this.it = it;
    this.vis = vis;
  }

  public EvalRes eval(Ctx ctx) {
    EvalRes result;
    EvalMapRes ret = ((EvalMapRes)visitor.boa.visitor.boa.BoaFactory.eINSTANCE.createEvalMapRes());
    execboa.MapService.putAll(ret.getValues(), ctx.getTh());
    result = ret;
    return result;
  }
}
