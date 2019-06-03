package emfswitch.emfswitch.operation;

import boa.Field;
import emfswitch.emfswitch.EmfswitchSwitchImplementation;

public class FieldOperation {
	private final Field it;

	private final EmfswitchSwitchImplementation emfswitch;

	public FieldOperation(Field it, EmfswitchSwitchImplementation emfswitch) {
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
