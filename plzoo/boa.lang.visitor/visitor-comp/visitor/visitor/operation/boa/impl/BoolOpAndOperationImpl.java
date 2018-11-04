package visitor.visitor.operation.boa.impl;

import visitor.boa.visitor.boa.BoolOpAnd;
import visitor.boa.visitor.boa.Ctx;
import visitor.boa.visitor.boa.EvalBoolRes;
import visitor.boa.visitor.boa.EvalRes;
import visitor.visitor.VisitorInterface;
import visitor.visitor.operation.boa.BoolOpAndOperation;

public class BoolOpAndOperationImpl extends BoolOpOperationImpl implements BoolOpAndOperation {
  private final BoolOpAnd it;

  private final VisitorInterface vis;

  public BoolOpAndOperationImpl(BoolOpAnd it, VisitorInterface vis) {
    super(it, vis);
    this.it = it;
    this.vis = vis;
  }

  public EvalRes eval(Ctx ctx) {
    EvalRes result;
    EvalRes vlhs = ((EvalRes)((visitor.visitor.operation.boa.ExprOperation)this.it.getLhs().accept(vis)).eval(ctx));
    EvalRes vrhs = ((EvalRes)((visitor.visitor.operation.boa.ExprOperation)this.it.getRhs().accept(vis)).eval(ctx));
    if(vlhs instanceof visitor.boa.visitor.boa.EvalBoolRes) {
      if(vrhs instanceof visitor.boa.visitor.boa.EvalBoolRes) {
        EvalBoolRes ivlhs = ((EvalBoolRes)vlhs);
        EvalBoolRes ivrhs = ((EvalBoolRes)vrhs);
        EvalBoolRes ret = ((EvalBoolRes)visitor.boa.visitor.boa.BoaFactory.eINSTANCE.createEvalBoolRes());
        ret.setValue(((ivlhs.isValue()) && (ivrhs.isValue())));
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
