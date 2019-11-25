package visitor.visitor.operation.boa.impl;

import visitor.boa.visitor.boa.Ctx;
import visitor.boa.visitor.boa.EvalBoolRes;
import visitor.boa.visitor.boa.EvalRes;
import visitor.boa.visitor.boa.If;
import visitor.visitor.VisitorInterface;
import visitor.visitor.operation.boa.IfOperation;

public class IfOperationImpl extends ExprOperationImpl implements IfOperation {
  private final If it;

  private final VisitorInterface vis;

  public IfOperationImpl(If it, VisitorInterface vis) {
    super(it, vis);
    this.it = it;
    this.vis = vis;
  }

  public EvalRes eval(Ctx ctx) {
    EvalRes result;
    EvalRes vcond = ((EvalRes)((visitor.visitor.operation.boa.ExprOperation)this.it.getCond().accept(vis)).eval(ctx));
    if(vcond instanceof visitor.boa.visitor.boa.EvalBoolRes) {
      EvalBoolRes bvcond = ((EvalBoolRes)vcond);
      if(bvcond.isValue()) {
        result = ((visitor.visitor.operation.boa.ExprOperation)this.it.getThn().accept(vis)).eval(ctx);
      }
      else {
        result = ((visitor.visitor.operation.boa.ExprOperation)this.it.getEls().accept(vis)).eval(ctx);
      }
    }
    else {
      result = null;
    }
    return result;
  }
}
