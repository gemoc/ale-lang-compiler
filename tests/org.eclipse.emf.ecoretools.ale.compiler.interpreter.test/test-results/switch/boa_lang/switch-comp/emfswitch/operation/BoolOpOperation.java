package emfswitch.operation;

import boa.BoolOp;
import emfswitch.SwitchImplementation;

public class BoolOpOperation extends ExprOperation {
	private final BoolOp it;

	private final SwitchImplementation emfswitch;

	public BoolOpOperation(BoolOp it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
