package emfswitch.emfswitch.operation;

import emfswitch.emfswitch.EmfswitchSwitchImplementation;
import kmLogo.CallStack;

public class CallStackOperation {
	private final CallStack it;

	private final EmfswitchSwitchImplementation emfswitch;

	public CallStackOperation(CallStack it, EmfswitchSwitchImplementation emfswitch) {
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
