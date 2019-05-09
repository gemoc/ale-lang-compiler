package emfswitch.operation;

import boa.ArithOp;
import emfswitch.SwitchImplementation;

public class ArithOpOperation extends ExprOperation {
	private final ArithOp it;

	private final SwitchImplementation emfswitch;

	public ArithOpOperation(ArithOp it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
