package emfswitch.operation;

import emfswitch.SwitchImplementation;
import kmLogo.UnaryExpression;

public class UnaryExpressionOperation extends ExpressionOperation {
	private final UnaryExpression it;

	private final SwitchImplementation emfswitch;

	public UnaryExpressionOperation(UnaryExpression it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
