package emfswitch.operation;

import boa.BoaFactory;
import boa.Ctx;
import boa.EvalRes;
import boa.Skip;
import emfswitch.SwitchImplementation;

public class SkipOperation extends ExprOperation {
	private final Skip it;

	private final SwitchImplementation emfswitch;

	public SkipOperation(Skip it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		result = BoaFactory.eINSTANCE.createEvalMapRes();
		return result;
	}
}
