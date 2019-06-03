package emfswitch.emfswitch.operation;

import emfswitch.emfswitch.EmfswitchSwitchImplementation;
import kmLogo.UnaryExpression;

public class UnaryExpressionOperation extends ExpressionOperation {
	private final UnaryExpression it;

	private final EmfswitchSwitchImplementation emfswitch;

	public UnaryExpressionOperation(UnaryExpression it, EmfswitchSwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
