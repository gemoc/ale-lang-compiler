package minijava_exec.impl.operation;

import miniJava.State;
import miniJava.Value;

public interface BoolConstantOp extends ExpressionOp {
	Value evaluateExpression(State state);
}
