package emfswitch.operation;

import boa.BoaFactory;
import boa.Ctx;
import boa.EvalMapRes;
import boa.EvalRes;
import boa.This;
import emfswitch.SwitchImplementation;

public class ThisOperation extends ExprOperation {
	private final This it;

	private final SwitchImplementation emfswitch;

	public ThisOperation(This it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		EvalMapRes ret = ((EvalMapRes) (BoaFactory.eINSTANCE.createEvalMapRes()));
		execboa.MapService.putAll(ret.getValues(), ctx.getTh());
		result = ret;
		return result;
	}
}
