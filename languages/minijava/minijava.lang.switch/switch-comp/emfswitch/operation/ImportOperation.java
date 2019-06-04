package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.Import;

public class ImportOperation {
	private final Import it;

	private final SwitchImplementation emfswitch;

	public ImportOperation(Import it, SwitchImplementation emfswitch) {
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
