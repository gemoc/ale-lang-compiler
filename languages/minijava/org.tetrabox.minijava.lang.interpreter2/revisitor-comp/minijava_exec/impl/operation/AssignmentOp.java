package minijava_exec.impl.operation;

import miniJava.State;

public interface AssignmentOp extends StatementOp {
	void evaluateStatement(State state);
}
