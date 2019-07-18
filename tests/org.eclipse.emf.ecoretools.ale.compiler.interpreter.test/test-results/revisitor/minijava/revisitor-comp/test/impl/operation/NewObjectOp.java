package test.impl.operation;

import miniJava.State;
import miniJava.Value;

public interface NewObjectOp extends ExpressionOp {
	Value evaluateExpression(State state);
}
