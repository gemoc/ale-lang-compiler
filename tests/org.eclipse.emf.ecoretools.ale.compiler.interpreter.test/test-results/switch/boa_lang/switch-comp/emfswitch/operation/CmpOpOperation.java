package emfswitch.operation;

import boa.CmpOp;
import emfswitch.SwitchImplementation;

public class CmpOpOperation extends ExprOperation {
	private final CmpOp it;

	private final SwitchImplementation emfswitch;

	public CmpOpOperation(CmpOp it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
