package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.BooleanValue;
import miniJava.Or;
import miniJava.State;
import miniJava.Value;

public class OrOperation extends ExpressionOperation {
	private final Or it;

	private final SwitchImplementation emfswitch;

	public OrOperation(Or it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public Value evaluateExpression(State state) {
		Value result;
		BooleanValue left = ((BooleanValue) /* CASEF */((ExpressionOperation) emfswitch
				.caseExpression(this.it.getLeft())).evaluateExpression(state));
		BooleanValue right = ((BooleanValue) /* CASEF */((ExpressionOperation) emfswitch
				.caseExpression(this.it.getRight())).evaluateExpression(state));
		BooleanValue res = ((BooleanValue) miniJava.MiniJavaFactory.eINSTANCE.createBooleanValue());
		res.setValue(((/* CASEF */left.isValue()) || (/* CASEF */right.isValue())));
		result = res;
		return result;
	}
}
