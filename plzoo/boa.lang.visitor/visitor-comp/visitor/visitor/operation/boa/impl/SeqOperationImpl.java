package visitor.visitor.operation.boa.impl;

import visitor.boa.visitor.boa.Ctx;
import visitor.boa.visitor.boa.EvalRes;
import visitor.boa.visitor.boa.Seq;
import visitor.visitor.VisitorInterface;
import visitor.visitor.operation.boa.SeqOperation;

public class SeqOperationImpl extends ExprOperationImpl implements SeqOperation {
  private final Seq it;

  private final VisitorInterface vis;

  public SeqOperationImpl(Seq it, VisitorInterface vis) {
    super(it, vis);
    this.it = it;
    this.vis = vis;
  }

  public EvalRes eval(Ctx ctx) {
    EvalRes result;
    EvalRes vlhs = ((EvalRes)((visitor.visitor.operation.boa.ExprOperation)this.it.getLhs().accept(vis)).eval(ctx));
    EvalRes vrhs = ((EvalRes)((visitor.visitor.operation.boa.ExprOperation)this.it.getRhs().accept(vis)).eval(ctx));
    result = vrhs;
    return result;
  }
}
