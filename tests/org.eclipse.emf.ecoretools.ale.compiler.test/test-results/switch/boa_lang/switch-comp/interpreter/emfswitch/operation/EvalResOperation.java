package interpreter.emfswitch.operation;

import boa.EvalRes;
import interpreter.emfswitch.InterpreterSwitchImplementation;

public class EvalResOperation {
	private final EvalRes it;

	private final InterpreterSwitchImplementation emfswitch;

	public EvalResOperation(EvalRes it, InterpreterSwitchImplementation emfswitch) {
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
