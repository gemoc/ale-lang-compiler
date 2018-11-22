package emfswitch.emfswitch.operation;

import boa.Ctx;
import boa.EvalRes;
import boa.Expr;
import boa.Let;
import emfswitch.emfswitch.EmfswitchSwitchImplementation;

public class LetOperation extends ExprOperation {
  private final Let it;

  private final EmfswitchSwitchImplementation emfswitch;

  public LetOperation(Let it, EmfswitchSwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }

  public EvalRes eval(Ctx ctx) {
    EvalRes result;
    Expr lhs = ((Expr)this.it.getLhs());
    EvalRes vlhs = ((EvalRes)((emfswitch.emfswitch.operation.ExprOperation) emfswitch.doSwitch(lhs)).eval(ctx));
    Ctx nctx = ((Ctx)boa.BoaFactory.eINSTANCE.createCtx());
    execboa.MapService.putAll(nctx.getEnv(), ctx.getEnv());
    execboa.MapService.put(nctx.getEnv(), this.it.getName(), vlhs);
    result = ((emfswitch.emfswitch.operation.ExprOperation) emfswitch.doSwitch(this.it.getRhs())).eval(nctx);
    return result;
  }
}
