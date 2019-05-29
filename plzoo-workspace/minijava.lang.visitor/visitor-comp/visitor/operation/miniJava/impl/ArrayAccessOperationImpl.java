package visitor.operation.miniJava.impl;

import miniJava.visitor.miniJava.ArrayAccess;
import miniJava.visitor.miniJava.ArrayRefValue;
import miniJava.visitor.miniJava.IntegerValue;
import miniJava.visitor.miniJava.State;
import miniJava.visitor.miniJava.Value;
import visitor.VisitorInterface;
import visitor.operation.miniJava.ArrayAccessOperation;
import visitor.operation.miniJava.ExpressionOperation;

public class ArrayAccessOperationImpl extends ExpressionOperationImpl implements ArrayAccessOperation {
	private final ArrayAccess it;

	private final VisitorInterface vis;

	public ArrayAccessOperationImpl(ArrayAccess it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}

	public Value evaluateExpression(State state) {
		Value result;
		ArrayRefValue arrayVal = ((ArrayRefValue) (((ExpressionOperation)this.it.getObject().accept(vis)).evaluateExpression((State) (state))));
		IntegerValue indexVal = ((IntegerValue) (((ExpressionOperation)this.it.getIndex().accept(vis)).evaluateExpression((State) (state))));
		result = arrayVal.getInstance().getValue().get(indexVal.getValue()).copyj();
		return result;
	}
}
