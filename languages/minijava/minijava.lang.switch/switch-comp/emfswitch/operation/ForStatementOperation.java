package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.BooleanValue;
import miniJava.ForStatement;
import miniJava.State;

public class ForStatementOperation extends StatementOperation {
	private final ForStatement it;

	private final SwitchImplementation emfswitch;

	public ForStatementOperation(ForStatement it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public void evaluateStatement(State state) {
		((StateOperation) emfswitch.doSwitch(state)).pushNewContext();
		((AssignmentOperation) emfswitch.doSwitch(this.it.getDeclaration())).evaluateStatement((State) (state));
		BooleanValue continueFor = ((BooleanValue) (((BooleanValue) (((ExpressionOperation) emfswitch.doSwitch(this.it.getCondition())).evaluateExpression((State) (state))))));
		while (continueFor.isValue()) {
			((BlockOperation) emfswitch.doSwitch(this.it.getBlock())).evaluateStatement((State) (state));
			((AssignmentOperation) emfswitch.doSwitch(this.it.getProgression())).evaluateStatement((State) (state));
			BooleanValue continueFor2 = ((BooleanValue) (((BooleanValue) (((ExpressionOperation) emfswitch.doSwitch(this.it.getCondition())).evaluateExpression((State) (state))))));
			continueFor = ((BooleanValue) (continueFor2));
		}
		((StateOperation) emfswitch.doSwitch(state)).popCurrentContext();
	}
}
