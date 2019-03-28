package emfswitch.operation;

import emfswitch.SwitchImplementation;
import testoperationbody.ChildA;
import testoperationbody.EnumA;

public class ChildAOperation extends ParentOperation {
	private final ChildA it;

	private final SwitchImplementation emfswitch;

	public ChildAOperation(ChildA it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public void overriden() {
	}

	public EnumA onlyA() {
		EnumA result;
		result = this.it.getValue();
		return result;
	}
}
