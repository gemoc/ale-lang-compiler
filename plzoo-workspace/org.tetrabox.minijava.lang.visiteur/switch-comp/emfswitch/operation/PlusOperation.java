package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.IntegerValue;
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
		Value left = ((Value) /* CASEA */((emfswitch.operation.ExpressionOperation) emfswitch
				.doSwitch(this.it.getLeft())).evaluateExpression(state));
		Value right = ((Value) /* CASEA */((emfswitch.operation.ExpressionOperation) emfswitch
				.doSwitch(this.it.getRight())).evaluateExpression(state));
		if (left instanceof miniJava.IntegerValue) {
			if (right instanceof miniJava.IntegerValue) {
				IntegerValue bleft = ((IntegerValue) left);
				IntegerValue bright = ((IntegerValue) right);
				IntegerValue tmp = ((IntegerValue) miniJava.MiniJavaFactory.eINSTANCE.createIntegerValue());
				tmp.setValue((bleft.getValue()) + (bright.getValue()));
				result = tmp;
			} else {
				if (right instanceof miniJava.StringValue) {
					StringValue tmp = ((StringValue) miniJava.MiniJavaFactory.eINSTANCE.createStringValue());
					tmp.setValue((/* CASEF */((ValueOperation) emfswitch.caseValue(left)).customToString())
							+ (/* CASEF */((ValueOperation) emfswitch.caseValue(right)).customToString()));
					result = tmp;
				} else {
					result = null;
				}
			}
		} else {
			if (((left instanceof miniJava.StringValue) || (right instanceof miniJava.StringValue))) {
				StringValue tmp = ((StringValue) miniJava.MiniJavaFactory.eINSTANCE.createStringValue());
				tmp.setValue((/* CASEF */((ValueOperation) emfswitch.caseValue(left)).customToString())
						+ (/* CASEF */((ValueOperation) emfswitch.caseValue(right)).customToString()));
				result = tmp;
			} else {
				result = null;
			}
		}
		return result;
	}
}
