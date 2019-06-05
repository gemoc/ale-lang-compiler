package emfswitch.operation;

import emfswitch.SwitchImplementation;
import imp.model.imp.IntValue;

public class IntValueOperation extends ValueOperation {
	private final IntValue it;

	private final SwitchImplementation emfswitch;

	public IntValueOperation(IntValue it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
