package emfswitch.emfswitch.operation;

import boa.ArithOp;
import emfswitch.emfswitch.EmfswitchSwitchImplementation;

public class ArithOpOperation extends ExprOperation {
	private final ArithOp it;

	private final EmfswitchSwitchImplementation emfswitch;

	public ArithOpOperation(ArithOp it, EmfswitchSwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
