package emfswitch.emfswitch.operation;

import boa.BoolOpAnd;
import boa.Ctx;
import boa.EvalBoolRes;
import boa.EvalRes;
import emfswitch.emfswitch.EmfswitchSwitchImplementation;

public class BoolOpAndOperation extends BoolOpOperation {
  private final BoolOpAnd it;

  private final EmfswitchSwitchImplementation emfswitch;

  public BoolOpAndOperation(BoolOpAnd it, EmfswitchSwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }

  public EvalRes eval(Ctx ctx) {
    EvalRes result;
    EvalRes vlhs = ((EvalRes)((emfswitch.emfswitch.operation.ExprOperation) emfswitch.doSwitch(this.it.getLhs())).eval(ctx));
    EvalRes vrhs = ((EvalRes)((emfswitch.emfswitch.operation.ExprOperation) emfswitch.doSwitch(this.it.getRhs())).eval(ctx));
    if(vlhs instanceof boa.EvalBoolRes) {
      if(vrhs instanceof boa.EvalBoolRes) {
        EvalBoolRes ivlhs = ((EvalBoolRes)vlhs);
        EvalBoolRes ivrhs = ((EvalBoolRes)vrhs);
        EvalBoolRes ret = ((EvalBoolRes)boa.BoaFactory.eINSTANCE.createEvalBoolRes());
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
