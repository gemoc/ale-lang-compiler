package interpreter.emfswitch.operation;

import boa.CmpOp;
import interpreter.emfswitch.InterpreterSwitchImplementation;

public class CmpOpOperation extends ExprOperation {
	private final CmpOp it;

	private final InterpreterSwitchImplementation emfswitch;

	public CmpOpOperation(CmpOp it, InterpreterSwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
