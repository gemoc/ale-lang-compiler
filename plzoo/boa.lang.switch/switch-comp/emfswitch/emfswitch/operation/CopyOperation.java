package emfswitch.emfswitch.operation;

import boa.Copy;
import boa.Ctx;
import boa.EvalMapRes;
import boa.EvalRes;
import emfswitch.emfswitch.EmfswitchSwitchImplementation;

public class CopyOperation extends ExprOperation {
  private final Copy it;

  private final EmfswitchSwitchImplementation emfswitch;

  public CopyOperation(Copy it, EmfswitchSwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }

  public EvalRes eval(Ctx ctx) {
    EvalRes result;
    EvalRes vcopy = ((EvalRes)((emfswitch.emfswitch.operation.ExprOperation) emfswitch.doSwitch(this.it.getCopy())).eval(ctx));
    if(vcopy instanceof boa.EvalMapRes) {
      EvalMapRes mvcopy = ((EvalMapRes)vcopy);
      EvalMapRes ret = ((EvalMapRes)boa.BoaFactory.eINSTANCE.createEvalMapRes());
      execboa.MapService.putAll(ret.getValues(), mvcopy.getValues());
      result = ret;
    }
    else {
      result = null;
    }
    return result;
  }
}
