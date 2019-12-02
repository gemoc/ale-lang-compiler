package test.impl.operation;

import miniJava.State;
import miniJava.Value;

public interface InferiorOrEqualOp extends ExpressionOp {
	Value evaluateExpression(State state);
}
