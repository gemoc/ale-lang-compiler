package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.IntegerValue;
import miniJava.MiniJavaFactory;
import miniJava.Plus;
import miniJava.State;
import miniJava.StringValue;
import miniJava.Value;

public class PlusOperation extends ExpressionOperation {
	private final Plus it;

	private final SwitchImplementation emfswitch;

	public PlusOperation(Plus it, SwitchImplementation emfswitch) {
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
				IntegerValue tmp = ((IntegerValue) (MiniJavaFactory.eINSTANCE.createIntegerValue()));
				tmp.setValue((bleft.getValue()) + (bright.getValue()));
				result = ((IntegerValue) (tmp));
			}
			else {
				if(right instanceof StringValue) {
					StringValue tmp = ((StringValue) (MiniJavaFactory.eINSTANCE.createStringValue()));
					tmp.setValue((((IntegerValueOperation) emfswitch.doSwitch(left)).customToString()) + (((StringValueOperation) emfswitch.doSwitch(right)).customToString()));
					result = ((StringValue) (tmp));
				}
				else {
					result = ((Value) (null));
				}
			}
		}
		else {
			if(((left instanceof StringValue) || (right instanceof StringValue))) {
				StringValue tmp = ((StringValue) (MiniJavaFactory.eINSTANCE.createStringValue()));
				tmp.setValue((((StringValueOperation) emfswitch.doSwitch(left)).customToString()) + (((StringValueOperation) emfswitch.doSwitch(right)).customToString()));
				result = ((StringValue) (tmp));
			}
			else {
				result = ((Value) (null));
			}
		}
		return result;
	}
}
