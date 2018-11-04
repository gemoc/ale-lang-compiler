package visitor.visitor.operation.boa.impl;

import visitor.boa.visitor.boa.Ctx;
import visitor.boa.visitor.boa.EvalRes;
import visitor.boa.visitor.boa.Var;
import visitor.visitor.VisitorInterface;
import visitor.visitor.operation.boa.VarOperation;

public class VarOperationImpl extends ExprOperationImpl implements VarOperation {
  private final Var it;

  private final VisitorInterface vis;

  public VarOperationImpl(Var it, VisitorInterface vis) {
    super(it, vis);
    this.it = it;
    this.vis = vis;
  }

  public EvalRes eval(Ctx ctx) {
    EvalRes result;
    if(execboa.MapService.containsKey(ctx.getEnv(), this.it.getName())) {
      result = execboa.MapService.getFromMap(ctx.getEnv(), this.it.getName());
    }
    else {
      result = null;
    }
    return result;
  }
}
