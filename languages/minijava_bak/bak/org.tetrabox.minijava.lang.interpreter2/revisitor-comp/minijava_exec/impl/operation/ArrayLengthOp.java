package minijava_exec.impl.operation;

import miniJava.State;
import miniJava.Value;

public interface ArrayLengthOp extends ExpressionOp {
	Value evaluateExpression(State state);
}
