package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.BooleanValue;
import miniJava.State;
import miniJava.WhileStatement;

public class WhileStatementOperation extends StatementOperation {
	private final WhileStatement it;

	private final SwitchImplementation emfswitch;

	public WhileStatementOperation(WhileStatement it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public void evaluateStatement(State state) {
		BooleanValue continueWhile = ((BooleanValue) (((BooleanValue) (((ExpressionOperation) emfswitch.doSwitch(this.it.getCondition())).evaluateExpression((State) (state))))));
		while (continueWhile.isValue()) {
			((BlockOperation) emfswitch.doSwitch(this.it.getBlock())).evaluateStatement((State) (state));
			BooleanValue continueWhile2 = ((BooleanValue) (((BooleanValue) (((ExpressionOperation) emfswitch.doSwitch(this.it.getCondition())).evaluateExpression((State) (state))))));
			continueWhile = continueWhile2;
		}
	}
}
