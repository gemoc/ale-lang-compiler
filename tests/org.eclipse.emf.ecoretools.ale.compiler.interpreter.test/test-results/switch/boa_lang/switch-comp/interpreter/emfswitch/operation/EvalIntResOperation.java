package interpreter.emfswitch.operation;

import boa.EvalIntRes;
import interpreter.emfswitch.InterpreterSwitchImplementation;

public class EvalIntResOperation extends EvalResOperation {
	private final EvalIntRes it;

	private final InterpreterSwitchImplementation emfswitch;

	public EvalIntResOperation(EvalIntRes it, InterpreterSwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
