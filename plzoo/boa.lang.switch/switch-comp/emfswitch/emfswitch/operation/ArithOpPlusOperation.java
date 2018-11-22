package emfswitch.emfswitch.operation;

import boa.ArithOpPlus;
import boa.Ctx;
import boa.EvalIntRes;
import boa.EvalRes;
import emfswitch.emfswitch.EmfswitchSwitchImplementation;

public class ArithOpPlusOperation extends ArithOpOperation {
  private final ArithOpPlus it;

  private final EmfswitchSwitchImplementation emfswitch;

  public ArithOpPlusOperation(ArithOpPlus it, EmfswitchSwitchImplementation emfswitch) {
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
        ret.setValue((ivlhs.getValue()) + (ivrhs.getValue()));
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
