package visitor.visitor.operation.boa.impl;

import visitor.boa.visitor.boa.Ctx;
import visitor.boa.visitor.boa.EvalBoolRes;
import visitor.boa.visitor.boa.EvalRes;
import visitor.boa.visitor.boa.Not;
import visitor.visitor.VisitorInterface;
import visitor.visitor.operation.boa.NotOperation;

public class NotOperationImpl extends ExprOperationImpl implements NotOperation {
  private final Not it;

  private final VisitorInterface vis;

  public NotOperationImpl(Not it, VisitorInterface vis) {
    super(it, vis);
    this.it = it;
    this.vis = vis;
  }

  public EvalRes eval(Ctx ctx) {
    EvalRes result;
    EvalRes vvalue = ((EvalRes)((visitor.visitor.operation.boa.ExprOperation)this.it.getValue().accept(vis)).eval(ctx));
    if(vvalue instanceof visitor.boa.visitor.boa.EvalBoolRes) {
      EvalBoolRes bvvalue = ((EvalBoolRes)vvalue);
      EvalBoolRes ret = ((EvalBoolRes)visitor.boa.visitor.boa.BoaFactory.eINSTANCE.createEvalBoolRes());
      ret.setValue(!(bvvalue.isValue()));
      result = ret;
    }
    else {
      result = null;
    }
    return result;
  }
}
