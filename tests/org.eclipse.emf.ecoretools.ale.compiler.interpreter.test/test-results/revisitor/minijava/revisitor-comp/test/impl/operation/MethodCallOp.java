package test.impl.operation;

import miniJava.Method;
import miniJava.State;
import miniJava.Value;

public interface MethodCallOp extends ExpressionOp {
	Value evaluateExpression(State state);

	void call(Method realMethod, State state);
}
