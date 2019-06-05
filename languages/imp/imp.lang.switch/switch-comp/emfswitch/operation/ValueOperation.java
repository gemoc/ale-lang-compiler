package emfswitch.operation;

import emfswitch.SwitchImplementation;
import imp.model.imp.Value;

public class ValueOperation {
	private final Value it;

	private final SwitchImplementation emfswitch;

	public ValueOperation(Value it, SwitchImplementation emfswitch) {
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
