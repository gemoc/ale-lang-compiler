package interpreter.emfswitch.operation;

import boa.EvalBoolRes;
import interpreter.emfswitch.InterpreterSwitchImplementation;

public class EvalBoolResOperation extends EvalResOperation {
	private final EvalBoolRes it;

	private final InterpreterSwitchImplementation emfswitch;

	public EvalBoolResOperation(EvalBoolRes it, InterpreterSwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
