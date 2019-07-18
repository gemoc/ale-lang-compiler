package test.impl.operation;

import miniJava.State;
import miniJava.Value;

public interface IntConstantOp extends ExpressionOp {
	Value evaluateExpression(State state);
}
