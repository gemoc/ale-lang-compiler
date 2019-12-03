package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.IntConstant;
import miniJava.IntegerValue;
import miniJava.MiniJavaFactory;
import miniJava.State;
import miniJava.Value;

public class IntConstantOperation extends ExpressionOperation {
	private final IntConstant it;

	private final SwitchImplementation emfswitch;

	public IntConstantOperation(IntConstant it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public Value evaluateExpression(State state) {
		Value result;
		IntegerValue ret = ((IntegerValue) (MiniJavaFactory.eINSTANCE.createIntegerValue()));
		ret.setValue(this.it.getValue());
		result = ((IntegerValue) (ret));
		return result;
	}
}
