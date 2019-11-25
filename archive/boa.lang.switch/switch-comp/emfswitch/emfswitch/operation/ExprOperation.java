package emfswitch.emfswitch.operation;

import boa.Ctx;
import boa.EvalRes;
import boa.Expr;
import emfswitch.emfswitch.EmfswitchSwitchImplementation;

public class ExprOperation extends TopLevelCmdOperation {
  private final Expr it;

  private final EmfswitchSwitchImplementation emfswitch;

  public ExprOperation(Expr it, EmfswitchSwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }

  public EvalRes eval(Ctx ctx) {
    EvalRes result;
    result = null;
    return result;
  }

  public void nextLine(Ctx ctx) {
    org.eclipse.emf.ecoretools.ale.compiler.lib.LogService.log(execboa.SerializeService.serialize(((emfswitch.emfswitch.operation.ExprOperation) emfswitch.doSwitch(this.it)).eval(ctx)));
  }
}
