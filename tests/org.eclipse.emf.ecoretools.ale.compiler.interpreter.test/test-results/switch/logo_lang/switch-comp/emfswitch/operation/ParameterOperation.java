package emfswitch.operation;

import emfswitch.SwitchImplementation;
import kmLogo.Parameter;

public class ParameterOperation {
	private final Parameter it;

	private final SwitchImplementation emfswitch;

	public ParameterOperation(Parameter it, SwitchImplementation emfswitch) {
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
