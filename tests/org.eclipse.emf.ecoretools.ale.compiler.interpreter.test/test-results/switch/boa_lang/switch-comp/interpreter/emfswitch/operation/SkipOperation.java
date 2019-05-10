package interpreter.emfswitch.operation;

import boa.BoaFactory;
import boa.Ctx;
import boa.EvalRes;
import boa.Skip;
import interpreter.emfswitch.InterpreterSwitchImplementation;

public class SkipOperation extends ExprOperation {
	private final Skip it;

	private final InterpreterSwitchImplementation emfswitch;

	public SkipOperation(Skip it, InterpreterSwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		result = BoaFactory.eINSTANCE.createEvalMapRes();
		return result;
	}
}
