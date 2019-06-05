package emfswitch.operation;

import emfswitch.SwitchImplementation;
import imp.model.imp.Unary;

public class UnaryOperation extends ExprOperation {
	private final Unary it;

	private final SwitchImplementation emfswitch;

	public UnaryOperation(Unary it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
