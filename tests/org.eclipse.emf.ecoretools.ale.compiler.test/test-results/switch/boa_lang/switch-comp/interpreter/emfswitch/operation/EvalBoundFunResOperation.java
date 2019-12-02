package interpreter.emfswitch.operation;

import boa.EvalBoundFunRes;
import interpreter.emfswitch.InterpreterSwitchImplementation;

public class EvalBoundFunResOperation extends EvalFunResOperation {
	private final EvalBoundFunRes it;

	private final InterpreterSwitchImplementation emfswitch;

	public EvalBoundFunResOperation(EvalBoundFunRes it, InterpreterSwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
