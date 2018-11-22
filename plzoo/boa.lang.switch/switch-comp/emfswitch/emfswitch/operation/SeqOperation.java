package emfswitch.emfswitch.operation;

import boa.Ctx;
import boa.EvalRes;
import boa.Seq;
import emfswitch.emfswitch.EmfswitchSwitchImplementation;

public class SeqOperation extends ExprOperation {
  private final Seq it;

  private final EmfswitchSwitchImplementation emfswitch;

  public SeqOperation(Seq it, EmfswitchSwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }

  public EvalRes eval(Ctx ctx) {
    EvalRes result;
    EvalRes vlhs = ((EvalRes)((emfswitch.emfswitch.operation.ExprOperation) emfswitch.doSwitch(this.it.getLhs())).eval(ctx));
    EvalRes vrhs = ((EvalRes)((emfswitch.emfswitch.operation.ExprOperation) emfswitch.doSwitch(this.it.getRhs())).eval(ctx));
    result = vrhs;
    return result;
  }
}
