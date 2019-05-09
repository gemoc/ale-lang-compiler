package emfswitch.operation;

import boa.Ctx;
import boa.EvalRes;
import boa.Var;
import emfswitch.SwitchImplementation;

public class VarOperation extends ExprOperation {
	private final Var it;

	private final SwitchImplementation emfswitch;

	public VarOperation(Var it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		if(execboa.MapService.containsKey(ctx.getEnv(), this.it.getName())) {
			result = execboa.MapService.getFromMap(ctx.getEnv(), this.it.getName());
		}
		else {
			result = null;
		}
		return result;
	}
}
