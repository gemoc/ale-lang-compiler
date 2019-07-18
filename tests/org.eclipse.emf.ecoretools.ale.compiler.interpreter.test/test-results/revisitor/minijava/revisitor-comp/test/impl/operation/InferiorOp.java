package test.impl.operation;

import miniJava.State;
import miniJava.Value;

public interface InferiorOp extends ExpressionOp {
	Value evaluateExpression(State state);
}
