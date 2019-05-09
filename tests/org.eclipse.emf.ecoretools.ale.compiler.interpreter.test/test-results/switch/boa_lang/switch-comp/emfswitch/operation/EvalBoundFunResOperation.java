package emfswitch.operation;

import boa.EvalBoundFunRes;
import emfswitch.SwitchImplementation;

public class EvalBoundFunResOperation extends EvalFunResOperation {
	private final EvalBoundFunRes it;

	private final SwitchImplementation emfswitch;

	public EvalBoundFunResOperation(EvalBoundFunRes it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
