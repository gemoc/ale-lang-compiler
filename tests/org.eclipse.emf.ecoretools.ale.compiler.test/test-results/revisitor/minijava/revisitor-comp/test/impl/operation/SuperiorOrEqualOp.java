package test.impl.operation;

import miniJava.State;
import miniJava.Value;

public interface SuperiorOrEqualOp extends ExpressionOp {
	Value evaluateExpression(State state);
}
