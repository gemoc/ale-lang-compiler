package visitor.visitor.operation.boa.impl;

import visitor.boa.visitor.boa.BObject;
import visitor.boa.visitor.boa.Ctx;
import visitor.boa.visitor.boa.EvalMapRes;
import visitor.boa.visitor.boa.EvalRes;
import visitor.boa.visitor.boa.Field;
import visitor.visitor.VisitorInterface;
import visitor.visitor.operation.boa.BObjectOperation;

public class BObjectOperationImpl extends ExprOperationImpl implements BObjectOperation {
  private final BObject it;

  private final VisitorInterface vis;

  public BObjectOperationImpl(BObject it, VisitorInterface vis) {
    super(it, vis);
    this.it = it;
    this.vis = vis;
  }

  public EvalRes eval(Ctx ctx) {
    EvalRes result;
    EvalMapRes ret = ((EvalMapRes)visitor.boa.visitor.boa.BoaFactory.eINSTANCE.createEvalMapRes());
    for(Field x: this.it.getFields()) {
      EvalRes v = ((EvalRes)((visitor.visitor.operation.boa.ExprOperation)x.getValue().accept(vis)).eval(ctx));
      execboa.MapService.put(ret.getValues(), x.getName(), v);
    }
    result = ret;
    return result;
  }
}
