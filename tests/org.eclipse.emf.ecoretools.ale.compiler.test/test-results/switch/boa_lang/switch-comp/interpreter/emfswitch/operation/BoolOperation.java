package interpreter.emfswitch.operation;

import boa.BoaFactory;
import boa.Bool;
import boa.Ctx;
import boa.EvalBoolRes;
import boa.EvalRes;
import interpreter.emfswitch.InterpreterSwitchImplementation;

public class BoolOperation extends ExprOperation {
	private final Bool it;

	private final InterpreterSwitchImplementation emfswitch;

	public BoolOperation(Bool it, InterpreterSwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		EvalBoolRes ret = ((EvalBoolRes) (BoaFactory.eINSTANCE.createEvalBoolRes()));
		ret.setValue(this.it.isValue());
		result = ret;
		return result;
	}
}
