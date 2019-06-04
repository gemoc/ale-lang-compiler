package emfswitch.emfswitch.operation;

import boa.BoolOp;
import emfswitch.emfswitch.EmfswitchSwitchImplementation;

public class BoolOpOperation extends ExprOperation {
	private final BoolOp it;

	private final EmfswitchSwitchImplementation emfswitch;

	public BoolOpOperation(BoolOp it, EmfswitchSwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
