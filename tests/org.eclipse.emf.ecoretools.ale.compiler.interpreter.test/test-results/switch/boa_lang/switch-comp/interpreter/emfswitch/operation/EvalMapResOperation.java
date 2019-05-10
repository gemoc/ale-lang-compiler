package interpreter.emfswitch.operation;

import boa.EvalMapRes;
import interpreter.emfswitch.InterpreterSwitchImplementation;

public class EvalMapResOperation extends EvalResOperation {
	private final EvalMapRes it;

	private final InterpreterSwitchImplementation emfswitch;

	public EvalMapResOperation(EvalMapRes it, InterpreterSwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
