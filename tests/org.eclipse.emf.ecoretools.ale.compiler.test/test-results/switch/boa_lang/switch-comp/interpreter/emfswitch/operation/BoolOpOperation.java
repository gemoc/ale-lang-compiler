package interpreter.emfswitch.operation;

import boa.BoolOp;
import interpreter.emfswitch.InterpreterSwitchImplementation;

public class BoolOpOperation extends ExprOperation {
	private final BoolOp it;

	private final InterpreterSwitchImplementation emfswitch;

	public BoolOpOperation(BoolOp it, InterpreterSwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
