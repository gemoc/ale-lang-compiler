package emfswitch.emfswitch.operation;

import emfswitch.emfswitch.EmfswitchSwitchImplementation;
import kmLogo.Variable;

public class VariableOperation {
	private final Variable it;

	private final EmfswitchSwitchImplementation emfswitch;

	public VariableOperation(Variable it, EmfswitchSwitchImplementation emfswitch) {
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
