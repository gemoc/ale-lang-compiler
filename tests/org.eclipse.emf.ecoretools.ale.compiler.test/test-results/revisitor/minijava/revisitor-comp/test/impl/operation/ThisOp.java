package test.impl.operation;

import miniJava.State;
import miniJava.Value;

public interface ThisOp extends ExpressionOp {
	Value evaluateExpression(State state);
}
