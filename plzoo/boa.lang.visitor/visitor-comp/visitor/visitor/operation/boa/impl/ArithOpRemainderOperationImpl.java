package visitor.visitor.operation.boa.impl;

import visitor.boa.visitor.boa.ArithOpRemainder;
import visitor.boa.visitor.boa.Ctx;
import visitor.boa.visitor.boa.EvalIntRes;
import visitor.boa.visitor.boa.EvalRes;
import visitor.visitor.VisitorInterface;
import visitor.visitor.operation.boa.ArithOpRemainderOperation;

public class ArithOpRemainderOperationImpl extends ArithOpOperationImpl implements ArithOpRemainderOperation {
  private final ArithOpRemainder it;

  private final VisitorInterface vis;

  public ArithOpRemainderOperationImpl(ArithOpRemainder it, VisitorInterface vis) {
    super(it, vis);
    this.it = it;
    this.vis = vis;
  }

  public EvalRes eval(Ctx ctx) {
    EvalRes result;
    EvalRes vlhs = ((EvalRes)((visitor.visitor.operation.boa.ExprOperation)this.it.getLhs().accept(vis)).eval(ctx));
    EvalRes vrhs = ((EvalRes)((visitor.visitor.operation.boa.ExprOperation)this.it.getRhs().accept(vis)).eval(ctx));
    if(vlhs instanceof visitor.boa.visitor.boa.EvalIntRes) {
      if(vrhs instanceof visitor.boa.visitor.boa.EvalIntRes) {
        EvalIntRes ivlhs = ((EvalIntRes)vlhs);
        EvalIntRes ivrhs = ((EvalIntRes)vrhs);
        EvalIntRes ret = ((EvalIntRes)visitor.boa.visitor.boa.BoaFactory.eINSTANCE.createEvalIntRes());
        ret.setValue(execboa.MathService.mod(this.it, ivlhs.getValue(), ivrhs.getValue()));
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
