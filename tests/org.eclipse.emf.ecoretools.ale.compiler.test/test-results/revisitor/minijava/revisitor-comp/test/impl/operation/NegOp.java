package test.impl.operation;

import miniJava.State;
import miniJava.Value;

public interface NegOp extends ExpressionOp {
	Value evaluateExpression(State state);
}
