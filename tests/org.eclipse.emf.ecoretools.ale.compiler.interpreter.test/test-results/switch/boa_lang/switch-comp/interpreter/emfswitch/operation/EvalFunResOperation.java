package interpreter.emfswitch.operation;

import boa.EvalFunRes;
import interpreter.emfswitch.InterpreterSwitchImplementation;

public class EvalFunResOperation extends EvalResOperation {
	private final EvalFunRes it;

	private final InterpreterSwitchImplementation emfswitch;

	public EvalFunResOperation(EvalFunRes it, InterpreterSwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
