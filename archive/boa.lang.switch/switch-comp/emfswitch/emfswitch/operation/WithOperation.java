package emfswitch.emfswitch.operation;

import boa.Ctx;
import boa.EvalMapRes;
import boa.EvalRes;
import boa.With;
import emfswitch.emfswitch.EmfswitchSwitchImplementation;

public class WithOperation extends ExprOperation {
  private final With it;

  private final EmfswitchSwitchImplementation emfswitch;

  public WithOperation(With it, EmfswitchSwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }

  public EvalRes eval(Ctx ctx) {
    EvalRes result;
    EvalRes vlhs = ((EvalRes)((emfswitch.emfswitch.operation.ExprOperation) emfswitch.doSwitch(this.it.getLhs())).eval(ctx));
    EvalRes vrhs = ((EvalRes)((emfswitch.emfswitch.operation.ExprOperation) emfswitch.doSwitch(this.it.getRhs())).eval(ctx));
    if(vlhs instanceof boa.EvalMapRes) {
      EvalMapRes mvlhs = ((EvalMapRes)vlhs);
      if(vrhs instanceof boa.EvalMapRes) {
        EvalMapRes mvrhs = ((EvalMapRes)vrhs);
        EvalMapRes ret = ((EvalMapRes)boa.BoaFactory.eINSTANCE.createEvalMapRes());
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
