package emfswitch.emfswitch.operation;

import boa.BoaFactory;
import boa.Ctx;
import boa.EvalMapRes;
import boa.EvalRes;
import boa.Skip;
import emfswitch.emfswitch.EmfswitchSwitchImplementation;

public class SkipOperation extends ExprOperation {
	private final Skip it;

	private final EmfswitchSwitchImplementation emfswitch;

	public SkipOperation(Skip it, EmfswitchSwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public EvalRes eval(Ctx ctx) {
		EvalRes result;
		result = ((EvalMapRes) (BoaFactory.eINSTANCE.createEvalMapRes()));
		return result;
	}
}
