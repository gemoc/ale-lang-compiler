package emfswitch.operation;

import emfswitch.SwitchImplementation;
import kmLogo.BinaryExp;

public class BinaryExpOperation extends ExpressionOperation {
	private final BinaryExp it;

	private final SwitchImplementation emfswitch;

	public BinaryExpOperation(BinaryExp it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
