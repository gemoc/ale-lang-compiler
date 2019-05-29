package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.PrintStatement;
import miniJava.State;

public class PrintStatementOperation extends StatementOperation {
	private final PrintStatement it;

	private final SwitchImplementation emfswitch;

	public PrintStatementOperation(PrintStatement it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public void evaluateStatement(State state) {
		String res = ((String) (((ValueOperation) emfswitch.doSwitch(((ExpressionOperation) emfswitch.doSwitch(this.it.getExpression())).evaluateExpression((State) (state)))).customToString()));
		((StateOperation) emfswitch.doSwitch(state)).println((String) (res));
	}
}
