package emfswitch.emfswitch.operation;

import emfswitch.emfswitch.EmfswitchSwitchImplementation;
import kmLogo.StackFrame;

public class StackFrameOperation {
	private final StackFrame it;

	private final EmfswitchSwitchImplementation emfswitch;

	public StackFrameOperation(StackFrame it, EmfswitchSwitchImplementation emfswitch) {
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
