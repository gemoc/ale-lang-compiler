package emfswitch.operation;

import boa.EvalFunRes;
import emfswitch.SwitchImplementation;

public class EvalFunResOperation extends EvalResOperation {
	private final EvalFunRes it;

	private final SwitchImplementation emfswitch;

	public EvalFunResOperation(EvalFunRes it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
