package emfswitch.operation;

import emfswitch.SwitchImplementation;
import kmLogo.Primitive;

public class PrimitiveOperation extends InstructionOperation {
	private final Primitive it;

	private final SwitchImplementation emfswitch;

	public PrimitiveOperation(Primitive it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
