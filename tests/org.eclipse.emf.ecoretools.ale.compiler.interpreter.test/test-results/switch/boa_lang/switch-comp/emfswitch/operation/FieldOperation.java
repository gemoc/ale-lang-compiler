package emfswitch.operation;

import boa.Field;
import emfswitch.SwitchImplementation;

public class FieldOperation {
	private final Field it;

	private final SwitchImplementation emfswitch;

	public FieldOperation(Field it, SwitchImplementation emfswitch) {
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
