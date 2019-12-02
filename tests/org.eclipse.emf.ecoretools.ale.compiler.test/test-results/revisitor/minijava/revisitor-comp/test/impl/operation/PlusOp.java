package test.impl.operation;

import miniJava.State;
import miniJava.Value;

public interface PlusOp extends ExpressionOp {
	Value evaluateExpression(State state);
}
