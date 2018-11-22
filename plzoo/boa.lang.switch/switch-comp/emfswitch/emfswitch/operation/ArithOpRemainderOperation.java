package emfswitch.emfswitch.operation;

import boa.ArithOpRemainder;
import boa.Ctx;
import boa.EvalIntRes;
import boa.EvalRes;
import emfswitch.emfswitch.EmfswitchSwitchImplementation;

public class ArithOpRemainderOperation extends ArithOpOperation {
  private final ArithOpRemainder it;

  private final EmfswitchSwitchImplementation emfswitch;

  public ArithOpRemainderOperation(ArithOpRemainder it, EmfswitchSwitchImplementation emfswitch) {
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
        EvalIntRes ret = ((EvalIntRes)boa.BoaFactory.eINSTANCE.createEvalIntRes());
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
