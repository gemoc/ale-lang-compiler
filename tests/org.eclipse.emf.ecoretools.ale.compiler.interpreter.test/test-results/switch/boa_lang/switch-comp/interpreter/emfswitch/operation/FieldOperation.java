package interpreter.emfswitch.operation;

import boa.Field;
import interpreter.emfswitch.InterpreterSwitchImplementation;

public class FieldOperation {
	private final Field it;

	private final InterpreterSwitchImplementation emfswitch;

	public FieldOperation(Field it, InterpreterSwitchImplementation emfswitch) {
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
