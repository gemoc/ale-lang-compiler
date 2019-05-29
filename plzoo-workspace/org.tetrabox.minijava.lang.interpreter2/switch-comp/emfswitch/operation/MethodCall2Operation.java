package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.MethodCall2;

public class MethodCall2Operation extends CallOperation {
	private final MethodCall2 it;

	private final SwitchImplementation emfswitch;

	public MethodCall2Operation(MethodCall2 it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
