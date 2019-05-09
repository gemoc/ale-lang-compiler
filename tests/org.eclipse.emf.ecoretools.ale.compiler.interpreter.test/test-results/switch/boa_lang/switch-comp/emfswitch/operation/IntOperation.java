package emfswitch.operation;

import boa.BoaFactory;
import boa.Ctx;
import boa.EvalIntRes;
import boa.EvalRes;
import boa.Int;
import emfswitch.SwitchImplementation;

public class IntOperation extends ExprOperation {
	private final Int it;

	private final SwitchImplementation emfswitch;

	public IntOperation(Int it, SwitchImplementation emfswitch) {
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
