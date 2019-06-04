package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.BoolConstant;
import miniJava.BooleanValue;
import miniJava.MiniJavaFactory;
import miniJava.State;
import miniJava.Value;
import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;

public class BoolConstantOperation extends ExpressionOperation {
	private final BoolConstant it;

	private final SwitchImplementation emfswitch;

	public BoolConstantOperation(BoolConstant it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public Value evaluateExpression(State state) {
		Value result;
		BooleanValue ret = ((BooleanValue) (MiniJavaFactory.eINSTANCE.createBooleanValue()));
		ret.setValue(EqualService.equals((this.it.getValue()), ("true")));
		result = ((BooleanValue) (ret));
		return result;
	}
}
