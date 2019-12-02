package emfswitch.operation;

import emfswitch.SwitchImplementation;
import kmLogo.Variable;

public class VariableOperation {
	private final Variable it;

	private final SwitchImplementation emfswitch;

	public VariableOperation(Variable it, SwitchImplementation emfswitch) {
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
