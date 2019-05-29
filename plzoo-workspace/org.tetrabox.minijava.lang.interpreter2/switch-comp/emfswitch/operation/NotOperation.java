package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.BooleanValue;
import miniJava.MiniJavaFactory;
import miniJava.Not;
import miniJava.State;
import miniJava.Value;

public class NotOperation extends ExpressionOperation {
	private final Not it;

	private final SwitchImplementation emfswitch;

	public NotOperation(Not it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public Value evaluateExpression(State state) {
		Value result;
		BooleanValue left = ((BooleanValue) (((ExpressionOperation) emfswitch.doSwitch(this.it.getExpression())).evaluateExpression((State) (state))));
		BooleanValue tmp = ((BooleanValue) (MiniJavaFactory.eINSTANCE.createBooleanValue()));
		tmp.setValue(!(left.isValue()));
		result = tmp;
		return result;
	}
}
