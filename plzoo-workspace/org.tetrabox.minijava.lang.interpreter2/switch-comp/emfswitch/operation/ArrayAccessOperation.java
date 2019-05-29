package emfswitch.operation;

import org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService;

import emfswitch.SwitchImplementation;
import miniJava.ArrayAccess;
import miniJava.ArrayRefValue;
import miniJava.IntegerValue;
import miniJava.State;
import miniJava.Value;

public class ArrayAccessOperation extends ExpressionOperation {
	private final ArrayAccess it;

	private final SwitchImplementation emfswitch;

	public ArrayAccessOperation(ArrayAccess it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public Value evaluateExpression(State state) {
		Value result;
		ArrayRefValue arrayVal = ((ArrayRefValue) (((ArrayRefValue) (((ExpressionOperation) emfswitch.doSwitch(this.it.getObject())).evaluateExpression((State) (state))))));
		IntegerValue indexVal = ((IntegerValue) (((IntegerValue) (((ExpressionOperation) emfswitch.doSwitch(this.it.getIndex())).evaluateExpression((State) (state))))));
		int v = ((int) (indexVal.getValue()));
		Value vtmp = ((Value) (CollectionService.get(arrayVal.getInstance().getValue(), v)));
		result = ((ValueOperation) emfswitch.doSwitch(vtmp)).copyj();
		return result;
	}
}
