package test.impl.operation;

import miniJava.State;
import miniJava.Value;

public interface SuperiorOp extends ExpressionOp {
	Value evaluateExpression(State state);
}
