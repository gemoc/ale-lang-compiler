package test.impl.operation;

import miniJava.State;
import miniJava.Value;

public interface NullOp extends ExpressionOp {
	Value evaluateExpression(State state);
}
