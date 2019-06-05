package emfswitch.operation;

import emfswitch.SwitchImplementation;
import imp.model.imp.BoolValue;

public class BoolValueOperation extends ValueOperation {
	private final BoolValue it;

	private final SwitchImplementation emfswitch;

	public BoolValueOperation(BoolValue it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
