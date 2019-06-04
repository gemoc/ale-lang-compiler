package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.State;
import miniJava.Statement;

public class StatementOperation {
	private final Statement it;

	private final SwitchImplementation emfswitch;

	public StatementOperation(Statement it, SwitchImplementation emfswitch) {
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public void evaluateStatement(State state) {
	}
}
