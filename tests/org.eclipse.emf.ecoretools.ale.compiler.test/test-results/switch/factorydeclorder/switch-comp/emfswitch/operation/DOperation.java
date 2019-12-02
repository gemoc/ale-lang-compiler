package emfswitch.operation;

import emfswitch.SwitchImplementation;
import factorydeclorder.D;

public class DOperation {
	private final D it;

	private final SwitchImplementation emfswitch;

	public DOperation(D it, SwitchImplementation emfswitch) {
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
