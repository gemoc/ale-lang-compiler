package emfswitch.operation;

import boa.EvalRes;
import emfswitch.SwitchImplementation;

public class EvalResOperation {
	private final EvalRes it;

	private final SwitchImplementation emfswitch;

	public EvalResOperation(EvalRes it, SwitchImplementation emfswitch) {
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
