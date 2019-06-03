package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.FieldBinding;

public class FieldBindingOperation {
	private final FieldBinding it;

	private final SwitchImplementation emfswitch;

	public FieldBindingOperation(FieldBinding it, SwitchImplementation emfswitch) {
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
