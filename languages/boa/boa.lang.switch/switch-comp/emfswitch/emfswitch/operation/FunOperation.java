package emfswitch.emfswitch.operation;

import boa.Ctx;
import boa.EvalFunRes;
import boa.EvalRes;
import boa.Fun;
import emfswitch.emfswitch.BoaFactory;
import emfswitch.emfswitch.EmfswitchSwitchImplementation;

public class FunOperation extends ExprOperation {
	private final Fun it;

	private final EmfswitchSwitchImplementation emfswitch;

	public FunOperation(Fun it, EmfswitchSwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		EvalFunRes ret = ((EvalFunRes) (BoaFactory.eINSTANCE.createEvalFunRes()));
		ret.setExp(this.it.getBody());
		ret.setCtx(ctx);
		ret.setName(this.it.getName());
		result = ret;
		return result;
	}
}
