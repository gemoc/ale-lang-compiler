package test.impl.operation;

import miniJava.State;
import miniJava.Value;

public interface MultiplicationOp extends ExpressionOp {
	Value evaluateExpression(State state);
}
