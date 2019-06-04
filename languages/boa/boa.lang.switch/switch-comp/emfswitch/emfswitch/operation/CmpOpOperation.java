package emfswitch.emfswitch.operation;

import boa.CmpOp;
import emfswitch.emfswitch.EmfswitchSwitchImplementation;

public class CmpOpOperation extends ExprOperation {
	private final CmpOp it;

	private final EmfswitchSwitchImplementation emfswitch;

	public CmpOpOperation(CmpOp it, EmfswitchSwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
