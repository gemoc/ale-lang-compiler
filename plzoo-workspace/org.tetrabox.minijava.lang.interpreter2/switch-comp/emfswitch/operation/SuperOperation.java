package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.Super;

public class SuperOperation extends ExpressionOperation {
	private final Super it;

	private final SwitchImplementation emfswitch;

	public SuperOperation(Super it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
