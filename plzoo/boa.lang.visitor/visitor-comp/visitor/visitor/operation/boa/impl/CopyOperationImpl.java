package visitor.visitor.operation.boa.impl;

import visitor.boa.visitor.boa.Copy;
import visitor.boa.visitor.boa.Ctx;
import visitor.boa.visitor.boa.EvalMapRes;
import visitor.boa.visitor.boa.EvalRes;
import visitor.visitor.VisitorInterface;
import visitor.visitor.operation.boa.CopyOperation;

public class CopyOperationImpl extends ExprOperationImpl implements CopyOperation {
  private final Copy it;

  private final VisitorInterface vis;

  public CopyOperationImpl(Copy it, VisitorInterface vis) {
    super(it, vis);
    this.it = it;
    this.vis = vis;
  }

  public EvalRes eval(Ctx ctx) {
    EvalRes result;
    EvalRes vcopy = ((EvalRes)((visitor.visitor.operation.boa.ExprOperation)this.it.getCopy().accept(vis)).eval(ctx));
    if(vcopy instanceof visitor.boa.visitor.boa.EvalMapRes) {
      EvalMapRes mvcopy = ((EvalMapRes)vcopy);
      EvalMapRes ret = ((EvalMapRes)visitor.boa.visitor.boa.BoaFactory.eINSTANCE.createEvalMapRes());
      execboa.MapService.putAll(ret.getValues(), mvcopy.getValues());
      result = ret;
    }
    else {
      result = null;
    }
    return result;
  }
}
