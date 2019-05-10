package interpreter.emfswitch.operation;

import boa.BoaFactory;
import boa.Ctx;
import boa.EvalMapRes;
import boa.EvalRes;
import boa.This;
import interpreter.emfswitch.InterpreterSwitchImplementation;

public class ThisOperation extends ExprOperation {
	private final This it;

	private final InterpreterSwitchImplementation emfswitch;

	public ThisOperation(This it, InterpreterSwitchImplementation emfswitch) {
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
