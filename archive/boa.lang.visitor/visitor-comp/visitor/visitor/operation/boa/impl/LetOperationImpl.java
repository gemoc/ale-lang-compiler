package visitor.visitor.operation.boa.impl;

import visitor.boa.visitor.boa.Ctx;
import visitor.boa.visitor.boa.EvalRes;
import visitor.boa.visitor.boa.Expr;
import visitor.boa.visitor.boa.Let;
import visitor.visitor.VisitorInterface;
import visitor.visitor.operation.boa.LetOperation;

public class LetOperationImpl extends ExprOperationImpl implements LetOperation {
  private final Let it;

  private final VisitorInterface vis;

  public LetOperationImpl(Let it, VisitorInterface vis) {
    super(it, vis);
    this.it = it;
    this.vis = vis;
  }

  public EvalRes eval(Ctx ctx) {
    EvalRes result;
    Expr lhs = ((Expr)this.it.getLhs());
    EvalRes vlhs = ((EvalRes)((visitor.visitor.operation.boa.ExprOperation)lhs.accept(vis)).eval(ctx));
    Ctx nctx = ((Ctx)visitor.boa.visitor.boa.BoaFactory.eINSTANCE.createCtx());
    execboa.MapService.putAll(nctx.getEnv(), ctx.getEnv());
    execboa.MapService.put(nctx.getEnv(), this.it.getName(), vlhs);
    result = ((visitor.visitor.operation.boa.ExprOperation)this.it.getRhs().accept(vis)).eval(nctx);
    return result;
  }
}
