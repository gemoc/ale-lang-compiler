package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.BooleanValue;
import miniJava.MiniJavaFactory;
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
		BooleanValue left = ((BooleanValue) (((BooleanValue) (((ExpressionOperation) emfswitch.doSwitch(this.it.getLeft())).evaluateExpression((State) (state))))));
		BooleanValue right = ((BooleanValue) (((BooleanValue) (((ExpressionOperation) emfswitch.doSwitch(this.it.getRight())).evaluateExpression((State) (state))))));
		BooleanValue res = ((BooleanValue) (MiniJavaFactory.eINSTANCE.createBooleanValue()));
		res.setValue(((left.isValue()) || (right.isValue())));
		result = ((BooleanValue) (res));
		return result;
	}
}
