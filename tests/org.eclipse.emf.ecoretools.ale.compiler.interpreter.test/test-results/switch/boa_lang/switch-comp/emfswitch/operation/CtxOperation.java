package emfswitch.operation;

import boa.Ctx;
import emfswitch.SwitchImplementation;

public class CtxOperation {
	private final Ctx it;

	private final SwitchImplementation emfswitch;

	public CtxOperation(Ctx it, SwitchImplementation emfswitch) {
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
