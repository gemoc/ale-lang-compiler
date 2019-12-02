package emfswitch.operation;

import emfswitch.SwitchImplementation;
import kmLogo.CallStack;

public class CallStackOperation {
	private final CallStack it;

	private final SwitchImplementation emfswitch;

	public CallStackOperation(CallStack it, SwitchImplementation emfswitch) {
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
