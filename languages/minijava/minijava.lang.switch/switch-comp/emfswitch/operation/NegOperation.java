package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.IntegerValue;
import miniJava.MiniJavaFactory;
import miniJava.Neg;
import miniJava.State;
import miniJava.Value;

public class NegOperation extends ExpressionOperation {
	private final Neg it;

	private final SwitchImplementation emfswitch;

	public NegOperation(Neg it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public Value evaluateExpression(State state) {
		Value result;
		IntegerValue left = ((IntegerValue) (((IntegerValue) (((ExpressionOperation) emfswitch.doSwitch(this.it.getExpression())).evaluateExpression((State) (state))))));
		IntegerValue tmp = ((IntegerValue) (MiniJavaFactory.eINSTANCE.createIntegerValue()));
		tmp.setValue(-(left.getValue()));
		result = ((IntegerValue) (tmp));
		return result;
	}
}
