package emfswitch.operation;

import emfswitch.SwitchImplementation;
import factorydeclorder.C;

public class COperation extends BOperation {
	private final C it;

	private final SwitchImplementation emfswitch;

	public COperation(C it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
