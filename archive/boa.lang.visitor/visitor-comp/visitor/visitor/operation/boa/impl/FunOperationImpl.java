package visitor.visitor.operation.boa.impl;

import visitor.boa.visitor.boa.Ctx;
import visitor.boa.visitor.boa.EvalFunRes;
import visitor.boa.visitor.boa.EvalRes;
import visitor.boa.visitor.boa.Fun;
import visitor.visitor.VisitorInterface;
import visitor.visitor.operation.boa.FunOperation;

public class FunOperationImpl extends ExprOperationImpl implements FunOperation {
  private final Fun it;

  private final VisitorInterface vis;

  public FunOperationImpl(Fun it, VisitorInterface vis) {
    super(it, vis);
    this.it = it;
    this.vis = vis;
  }

  public EvalRes eval(Ctx ctx) {
    EvalRes result;
    EvalFunRes ret = ((EvalFunRes)visitor.boa.visitor.boa.BoaFactory.eINSTANCE.createEvalFunRes());
    ret.setExp(this.it.getBody());
    ret.setCtx(ctx);
    ret.setName(this.it.getName());
    result = ret;
    return result;
  }
}
