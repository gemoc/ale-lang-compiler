package visitor.visitor.operation.boa.impl;

import visitor.boa.visitor.boa.Ctx;
import visitor.boa.visitor.boa.EvalMapRes;
import visitor.boa.visitor.boa.EvalRes;
import visitor.boa.visitor.boa.With;
import visitor.visitor.VisitorInterface;
import visitor.visitor.operation.boa.WithOperation;

public class WithOperationImpl extends ExprOperationImpl implements WithOperation {
  private final With it;

  private final VisitorInterface vis;

  public WithOperationImpl(With it, VisitorInterface vis) {
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
      if(vrhs instanceof visitor.boa.visitor.boa.EvalMapRes) {
        EvalMapRes mvrhs = ((EvalMapRes)vrhs);
        EvalMapRes ret = ((EvalMapRes)visitor.boa.visitor.boa.BoaFactory.eINSTANCE.createEvalMapRes());
        execboa.MapService.putAll(ret.getValues(), mvlhs.getValues());
        execboa.MapService.putAll(ret.getValues(), mvrhs.getValues());
        result = ret;
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
