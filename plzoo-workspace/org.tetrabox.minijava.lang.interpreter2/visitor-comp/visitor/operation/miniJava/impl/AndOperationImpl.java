package visitor.operation.miniJava.impl;

import miniJava.visitor.miniJava.And;
import miniJava.visitor.miniJava.BooleanValue;
import miniJava.visitor.miniJava.MiniJavaFactory;
import miniJava.visitor.miniJava.State;
import miniJava.visitor.miniJava.Value;
import visitor.VisitorInterface;
import visitor.operation.miniJava.AndOperation;

public class AndOperationImpl extends ExpressionOperationImpl implements AndOperation {
	private final And it;

	private final VisitorInterface vis;

	public AndOperationImpl(And it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}

	public Value evaluateExpression(State state) {
		Value result;
		Value left = ((Value) (this.it.getLeft().evaluateExpression((State) (state))));
		Value right = ((Value) (this.it.getRight().evaluateExpression((State) (state))));
		if(left instanceof BooleanValue) {
			if(right instanceof BooleanValue) {
				BooleanValue bleft = ((BooleanValue) (left));
				BooleanValue bright = ((BooleanValue) (right));
				BooleanValue tmp = ((BooleanValue) (MiniJavaFactory.eINSTANCE.createBooleanValue()));
				tmp.setValue(((bleft.isValue()) && (bright.isValue())));
				result = tmp;
			}
			else {
				result = null;
			}
		}
		else {
			result = null;
		}
		return result;
	}
}
