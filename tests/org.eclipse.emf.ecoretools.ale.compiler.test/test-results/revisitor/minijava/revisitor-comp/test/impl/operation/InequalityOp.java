package test.impl.operation;

import miniJava.State;
import miniJava.Value;

public interface InequalityOp extends ExpressionOp {
	Value evaluateExpression(State state);
}
