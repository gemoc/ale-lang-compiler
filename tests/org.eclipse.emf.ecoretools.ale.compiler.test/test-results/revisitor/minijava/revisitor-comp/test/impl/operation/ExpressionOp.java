package test.impl.operation;

import miniJava.State;
import miniJava.Value;

public interface ExpressionOp extends StatementOp, AssigneeOp {
	void evaluateStatement(State state);

	Value evaluateExpression(State state);
}
