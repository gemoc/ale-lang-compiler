package test.impl.operation;

import miniJava.State;
import miniJava.Value;

public interface SymbolRefOp extends ExpressionOp {
	Value evaluateExpression(State state);
}
