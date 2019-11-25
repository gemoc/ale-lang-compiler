package visitor.visitor.operation.boa.impl;

import visitor.boa.visitor.boa.Ctx;
import visitor.boa.visitor.boa.Def;
import visitor.boa.visitor.boa.EvalRes;
import visitor.visitor.VisitorInterface;
import visitor.visitor.operation.boa.DefOperation;

public class DefOperationImpl extends TopLevelCmdOperationImpl implements DefOperation {
  private final Def it;

  private final VisitorInterface vis;

  public DefOperationImpl(Def it, VisitorInterface vis) {
    super(it, vis);
    this.it = it;
    this.vis = vis;
  }

  public void nextLine(Ctx ctx) {
    EvalRes e = ((EvalRes)((visitor.visitor.operation.boa.ExprOperation)this.it.getExpr().accept(vis)).eval(ctx));
    org.eclipse.emf.ecoretools.ale.compiler.lib.LogService.log(((this.it.getName()) + (" = ")) + (execboa.SerializeService.serialize(e)));
    execboa.MapService.put(ctx.getEnv(), this.it.getName(), e);
  }
}
