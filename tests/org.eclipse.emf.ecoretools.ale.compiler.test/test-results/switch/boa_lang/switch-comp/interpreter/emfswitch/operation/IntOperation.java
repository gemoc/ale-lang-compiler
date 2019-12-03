package interpreter.emfswitch.operation;

import boa.BoaFactory;
import boa.Ctx;
import boa.EvalIntRes;
import boa.EvalRes;
import boa.Int;
import interpreter.emfswitch.InterpreterSwitchImplementation;

public class IntOperation extends ExprOperation {
	private final Int it;

	private final InterpreterSwitchImplementation emfswitch;

	public IntOperation(Int it, InterpreterSwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		EvalIntRes ret = ((EvalIntRes) (BoaFactory.eINSTANCE.createEvalIntRes()));
		ret.setValue(this.it.getValue());
		result = ((EvalIntRes) (ret));
		return result;
	}
}
