package interpreter.emfswitch.operation;

import boa.ArithOp;
import interpreter.emfswitch.InterpreterSwitchImplementation;

public class ArithOpOperation extends ExprOperation {
	private final ArithOp it;

	private final InterpreterSwitchImplementation emfswitch;

	public ArithOpOperation(ArithOp it, InterpreterSwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
