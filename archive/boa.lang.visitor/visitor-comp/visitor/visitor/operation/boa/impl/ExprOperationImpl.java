package visitor.visitor.operation.boa.impl;

import visitor.boa.visitor.boa.Ctx;
import visitor.boa.visitor.boa.EvalRes;
import visitor.boa.visitor.boa.Expr;
import visitor.visitor.VisitorInterface;
import visitor.visitor.operation.boa.ExprOperation;

public abstract class ExprOperationImpl extends TopLevelCmdOperationImpl implements ExprOperation {
  private final Expr it;

  private final VisitorInterface vis;

  public ExprOperationImpl(Expr it, VisitorInterface vis) {
    super(it, vis);
    this.it = it;
    this.vis = vis;
  }

  public EvalRes eval(Ctx ctx) {
    EvalRes result;
    result = null;
    return result;
  }

  public void nextLine(Ctx ctx) {
    org.eclipse.emf.ecoretools.ale.compiler.lib.LogService.log(execboa.SerializeService.serialize(((visitor.visitor.operation.boa.ExprOperation)this.it.accept(vis)).eval(ctx)));
  }
}
