package emfswitch.emfswitch.operation;

import boa.Ctx;
import boa.EvalIntRes;
import boa.EvalRes;
import boa.Int;
import emfswitch.emfswitch.BoaFactory;
import emfswitch.emfswitch.EmfswitchSwitchImplementation;

public class IntOperation extends ExprOperation {
	private final Int it;

	private final EmfswitchSwitchImplementation emfswitch;

	public IntOperation(Int it, EmfswitchSwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		EvalIntRes ret = ((EvalIntRes) (BoaFactory.eINSTANCE.createEvalIntRes()));
		ret.setValue(this.it.getValue());
		result = ret;
		return result;
	}
}
