package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.BooleanValue;
import miniJava.IntegerValue;
import miniJava.MiniJavaFactory;
import miniJava.State;
import miniJava.Superior;
import miniJava.Value;

public class SuperiorOperation extends ExpressionOperation {
	private final Superior it;

	private final SwitchImplementation emfswitch;

	public SuperiorOperation(Superior it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public Value evaluateExpression(State state) {
		Value result;
		Value left = ((Value) (((ExpressionOperation) emfswitch.doSwitch(this.it.getLeft())).evaluateExpression((State) (state))));
		Value right = ((Value) (((ExpressionOperation) emfswitch.doSwitch(this.it.getRight())).evaluateExpression((State) (state))));
		if(left instanceof IntegerValue) {
			if(right instanceof IntegerValue) {
				IntegerValue bleft = ((IntegerValue) (left));
				IntegerValue bright = ((IntegerValue) (right));
				BooleanValue tmp = ((BooleanValue) (MiniJavaFactory.eINSTANCE.createBooleanValue()));
				tmp.setValue((bleft.getValue()) > (bright.getValue()));
				result = ((BooleanValue) (tmp));
			}
			else {
				result = ((Value) (null));
			}
		}
		else {
			result = ((Value) (null));
		}
		return result;
	}
}
