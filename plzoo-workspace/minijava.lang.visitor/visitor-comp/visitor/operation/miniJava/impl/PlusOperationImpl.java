package visitor.operation.miniJava.impl;

import miniJava.visitor.miniJava.IntegerValue;
import miniJava.visitor.miniJava.MiniJavaFactory;
import miniJava.visitor.miniJava.Plus;
import miniJava.visitor.miniJava.State;
import miniJava.visitor.miniJava.StringValue;
import miniJava.visitor.miniJava.Value;
import visitor.VisitorInterface;
import visitor.operation.miniJava.ExpressionOperation;
import visitor.operation.miniJava.PlusOperation;

public class PlusOperationImpl extends ExpressionOperationImpl implements PlusOperation {
	private final Plus it;

	private final VisitorInterface vis;

	public PlusOperationImpl(Plus it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}

	public Value evaluateExpression(State state) {
		Value result;
		Value left = ((Value) (((ExpressionOperation)this.it.getLeft().accept(vis)).evaluateExpression((State) (state))));
		Value right = ((Value) (((ExpressionOperation)this.it.getRight().accept(vis)).evaluateExpression((State) (state))));
		if(left instanceof IntegerValue) {
			if(right instanceof IntegerValue) {
				IntegerValue bleft = ((IntegerValue) (left));
				IntegerValue bright = ((IntegerValue) (right));
				IntegerValue tmp = ((IntegerValue) (MiniJavaFactory.eINSTANCE.createIntegerValue()));
				tmp.setValue((bleft.getValue()) + (bright.getValue()));
				result = tmp;
			}
			else {
				if(right instanceof StringValue) {
					StringValue tmp = ((StringValue) (MiniJavaFactory.eINSTANCE.createStringValue()));
					tmp.setValue((left.customToString()) + (right.customToString()));
					result = tmp;
				}
				else {
					result = null;
				}
			}
		}
		else {
			if(((left instanceof miniJava.visitor.miniJava.StringValue) || (right instanceof miniJava.visitor.miniJava.StringValue))) {
				StringValue tmp = ((StringValue) (MiniJavaFactory.eINSTANCE.createStringValue()));
				tmp.setValue((left.customToString()) + (right.customToString()));
				result = tmp;
			}
			else {
				result = null;
			}
		}
		return result;
	}
}
