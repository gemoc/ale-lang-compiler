package emfswitch.operation;

import emfswitch.SwitchImplementation;
import kmLogo.StackFrame;

public class StackFrameOperation {
	private final StackFrame it;

	private final SwitchImplementation emfswitch;

	public StackFrameOperation(StackFrame it, SwitchImplementation emfswitch) {
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
