package emfswitch.operation;

import emfswitch.SwitchImplementation;
import factorydeclorder.A;

public class AOperation extends DOperation {
	private final A it;

	private final SwitchImplementation emfswitch;

	public AOperation(A it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
