package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.OutputStream;

public class OutputStreamOperation {
	private final OutputStream it;

	private final SwitchImplementation emfswitch;

	public OutputStreamOperation(OutputStream it, SwitchImplementation emfswitch) {
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
