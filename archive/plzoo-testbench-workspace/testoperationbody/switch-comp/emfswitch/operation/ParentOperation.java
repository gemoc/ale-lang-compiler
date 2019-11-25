package emfswitch.operation;

import emfswitch.SwitchImplementation;
import testoperationbody.Parent;

public class ParentOperation {
	private final Parent it;

	private final SwitchImplementation emfswitch;

	public ParentOperation(Parent it, SwitchImplementation emfswitch) {
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public void notOverriden() {
	}

	public void overriden() {
	}
}
