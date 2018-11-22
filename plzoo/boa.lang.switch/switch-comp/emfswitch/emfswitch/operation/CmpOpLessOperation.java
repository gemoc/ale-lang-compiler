package emfswitch.emfswitch.operation;

import boa.CmpOpLess;
import boa.Ctx;
import boa.EvalBoolRes;
import boa.EvalIntRes;
import boa.EvalRes;
import emfswitch.emfswitch.EmfswitchSwitchImplementation;

public class CmpOpLessOperation extends CmpOpOperation {
  private final CmpOpLess it;

  private final EmfswitchSwitchImplementation emfswitch;

  public CmpOpLessOperation(CmpOpLess it, EmfswitchSwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }

  public EvalRes eval(Ctx ctx) {
    EvalRes result;
    EvalRes vlhs = ((EvalRes)((emfswitch.emfswitch.operation.ExprOperation) emfswitch.doSwitch(this.it.getLhs())).eval(ctx));
    EvalRes vrhs = ((EvalRes)((emfswitch.emfswitch.operation.ExprOperation) emfswitch.doSwitch(this.it.getRhs())).eval(ctx));
    if(vlhs instanceof boa.EvalIntRes) {
      if(vrhs instanceof boa.EvalIntRes) {
        EvalIntRes ivlhs = ((EvalIntRes)vlhs);
        EvalIntRes ivrhs = ((EvalIntRes)vrhs);
        EvalBoolRes ret = ((EvalBoolRes)boa.BoaFactory.eINSTANCE.createEvalBoolRes());
        ret.setValue((ivlhs.getValue()) < (ivrhs.getValue()));
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
