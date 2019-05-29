package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.And;
import miniJava.BooleanValue;
import miniJava.MiniJavaFactory;
import miniJava.State;
import miniJava.Value;

public class AndOperation extends ExpressionOperation {
	private final And it;

	private final SwitchImplementation emfswitch;

	public AndOperation(And it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public Value evaluateExpression(State state) {
		Value result;
		Value left = ((Value) (((ExpressionOperation) emfswitch.doSwitch(this.it.getLeft())).evaluateExpression((State) (state))));
		Value right = ((Value) (((ExpressionOperation) emfswitch.doSwitch(this.it.getRight())).evaluateExpression((State) (state))));
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
