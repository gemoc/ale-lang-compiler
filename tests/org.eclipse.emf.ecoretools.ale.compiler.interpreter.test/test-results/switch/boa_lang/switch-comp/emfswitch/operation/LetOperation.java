package emfswitch.operation;

import boa.BoaFactory;
import boa.Ctx;
import boa.EvalRes;
import boa.Expr;
import boa.Let;
import emfswitch.SwitchImplementation;

public class LetOperation extends ExprOperation {
	private final Let it;

	private final SwitchImplementation emfswitch;

	public LetOperation(Let it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		Expr lhs = ((Expr) (this.it.getLhs()));
		EvalRes vlhs = ((EvalRes) (((ExprOperation) emfswitch.doSwitch(lhs)).eval((Ctx) ctx)));
		Ctx nctx = ((Ctx) (BoaFactory.eINSTANCE.createCtx()));
		execboa.MapService.putAll(nctx.getEnv(), ctx.getEnv());
		execboa.MapService.put(nctx.getEnv(), this.it.getName(), vlhs);
		result = ((ExprOperation) emfswitch.doSwitch(this.it.getRhs())).eval((Ctx) nctx);
		return result;
	}
}
