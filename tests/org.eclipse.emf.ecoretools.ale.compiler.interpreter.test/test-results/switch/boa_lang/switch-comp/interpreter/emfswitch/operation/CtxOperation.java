package interpreter.emfswitch.operation;

import boa.Ctx;
import interpreter.emfswitch.InterpreterSwitchImplementation;

public class CtxOperation {
	private final Ctx it;

	private final InterpreterSwitchImplementation emfswitch;

	public CtxOperation(Ctx it, InterpreterSwitchImplementation emfswitch) {
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
