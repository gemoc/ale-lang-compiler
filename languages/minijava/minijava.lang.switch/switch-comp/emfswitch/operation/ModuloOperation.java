package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.IntegerValue;
import miniJava.MiniJavaFactory;
import miniJava.Modulo;
import miniJava.State;
import miniJava.Value;
import minijava.MathService;

public class ModuloOperation extends ExpressionOperation {
	private final Modulo it;

	private final SwitchImplementation emfswitch;

	public ModuloOperation(Modulo it, SwitchImplementation emfswitch) {
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
				tmp.setValue(MathService.mod((Modulo) (this.it), (int) (bleft.getValue()), (int) (bright.getValue())));
				result = ((IntegerValue) (tmp));
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
