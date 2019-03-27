package emfswitch.operation;

import emfswitch.SwitchImplementation;
import testenums.Root;

public class RootOperation {
	private final Root it;

	private final SwitchImplementation emfswitch;

	public RootOperation(Root it, SwitchImplementation emfswitch) {
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
