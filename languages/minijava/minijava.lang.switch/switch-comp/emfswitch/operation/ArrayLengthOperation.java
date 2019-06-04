package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.ArrayLength;
import miniJava.ArrayRefValue;
import miniJava.IntegerValue;
import miniJava.MiniJavaFactory;
import miniJava.State;
import miniJava.Value;

public class ArrayLengthOperation extends ExpressionOperation {
	private final ArrayLength it;

	private final SwitchImplementation emfswitch;

	public ArrayLengthOperation(ArrayLength it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public Value evaluateExpression(State state) {
		Value result;
		ArrayRefValue arrayRef = ((ArrayRefValue) (((ExpressionOperation) emfswitch.doSwitch(this.it.getArray())).evaluateExpression((State) (state))));
		int size = ((int) (arrayRef.getInstance().getSize()));
		IntegerValue tmp = ((IntegerValue) (MiniJavaFactory.eINSTANCE.createIntegerValue()));
		tmp.setValue(size);
		result = tmp;
		return result;
	}
}
