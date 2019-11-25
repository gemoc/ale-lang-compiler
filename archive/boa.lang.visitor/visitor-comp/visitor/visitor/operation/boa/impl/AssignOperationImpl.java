package visitor.visitor.operation.boa.impl;

import visitor.boa.visitor.boa.Assign;
import visitor.boa.visitor.boa.Ctx;
import visitor.boa.visitor.boa.EvalMapRes;
import visitor.boa.visitor.boa.EvalRes;
import visitor.visitor.VisitorInterface;
import visitor.visitor.operation.boa.AssignOperation;

public class AssignOperationImpl extends ExprOperationImpl implements AssignOperation {
  private final Assign it;

  private final VisitorInterface vis;

  public AssignOperationImpl(Assign it, VisitorInterface vis) {
    super(it, vis);
    this.it = it;
    this.vis = vis;
  }

  public EvalRes eval(Ctx ctx) {
    EvalRes result;
    EvalRes vlhs = ((EvalRes)((visitor.visitor.operation.boa.ExprOperation)this.it.getLhs().accept(vis)).eval(ctx));
    EvalRes vrhs = ((EvalRes)((visitor.visitor.operation.boa.ExprOperation)this.it.getRhs().accept(vis)).eval(ctx));
    if(vlhs instanceof visitor.boa.visitor.boa.EvalMapRes) {
      EvalMapRes mvlhs = ((EvalMapRes)vlhs);
      if(execboa.MapService.containsKey(mvlhs.getValues(), this.it.getName())) {
        execboa.MapService.put(mvlhs.getValues(), this.it.getName(), vrhs);
        result = vrhs;
      }
      else {
        result = null;
      }
    }
    else {
      result = null;
    }
    return result;
  }
}
