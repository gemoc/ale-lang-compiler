package emfswitch.operation;

import emfswitch.SwitchImplementation;
import testoperationbody.ChildB;

public class ChildBOperation extends ParentOperation {
	private final ChildB it;

	private final SwitchImplementation emfswitch;

	public ChildBOperation(ChildB it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public void overriden() {
	}
}
