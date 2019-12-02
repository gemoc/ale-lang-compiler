package test.impl.operation;

import miniJava.State;

public interface BlockOp extends StatementOp {
	void evaluateStatementKeepContext(State state);

	void evaluateStatement(State state);
}
