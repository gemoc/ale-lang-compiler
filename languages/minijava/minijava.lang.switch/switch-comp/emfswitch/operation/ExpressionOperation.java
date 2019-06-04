package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.Expression;
import miniJava.State;
import miniJava.Value;

public class ExpressionOperation extends StatementOperation {
	private final Expression it;

	private final SwitchImplementation emfswitch;

	public ExpressionOperation(Expression it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public void evaluateStatement(State state) {
		((ExpressionOperation) emfswitch.doSwitch(this.it)).evaluateExpression((State) (state));
	}

	public Value evaluateExpression(State state) {
		Value result;
		result = null;
		return result;
	}
}
