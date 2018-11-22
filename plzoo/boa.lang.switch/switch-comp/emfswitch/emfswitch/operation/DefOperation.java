package emfswitch.emfswitch.operation;

import boa.Ctx;
import boa.Def;
import boa.EvalRes;
import emfswitch.emfswitch.EmfswitchSwitchImplementation;

public class DefOperation extends TopLevelCmdOperation {
  private final Def it;

  private final EmfswitchSwitchImplementation emfswitch;

  public DefOperation(Def it, EmfswitchSwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }

  public void nextLine(Ctx ctx) {
    EvalRes e = ((EvalRes)((emfswitch.emfswitch.operation.ExprOperation) emfswitch.doSwitch(this.it.getExpr())).eval(ctx));
    org.eclipse.emf.ecoretools.ale.compiler.lib.LogService.log(((this.it.getName()) + (" = ")) + (execboa.SerializeService.serialize(e)));
    execboa.MapService.put(ctx.getEnv(), this.it.getName(), e);
  }
}
