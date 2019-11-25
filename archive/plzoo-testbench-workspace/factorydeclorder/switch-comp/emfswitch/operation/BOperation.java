package emfswitch.operation;

import emfswitch.SwitchImplementation;
import factorydeclorder.B;

public class BOperation {
	private final B it;

	private final SwitchImplementation emfswitch;

	public BOperation(B it, SwitchImplementation emfswitch) {
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
