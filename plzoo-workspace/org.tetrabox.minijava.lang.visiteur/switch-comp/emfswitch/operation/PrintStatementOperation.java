package emfswitch.operation;

import emfswitch.SwitchImplementation;
import java.lang.String;
import miniJava.PrintStatement;
import miniJava.State;
import miniJava.Value;

public class PrintStatementOperation extends StatementOperation {
	private final PrintStatement it;

	private final SwitchImplementation emfswitch;

	public PrintStatementOperation(PrintStatement it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public void evaluateStatement(State state) {
		Value evaluateExpression = ((emfswitch.operation.ExpressionOperation) emfswitch
				.doSwitch(this.it.getExpression())).evaluateExpression(state);
		String res = ((String) /* CASEF *//* CASEA */((ValueOperation) emfswitch.doSwitch(evaluateExpression))
				.customToString());
		/* CASEA */((emfswitch.operation.StateOperation) emfswitch.doSwitch(state)).println(res);
	}
}
