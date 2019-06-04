package emfswitch.emfswitch.operation;

import boa.EvalFunRes;
import emfswitch.emfswitch.EmfswitchSwitchImplementation;

public class EvalFunResOperation extends EvalResOperation {
	private final EvalFunRes it;

	private final EmfswitchSwitchImplementation emfswitch;

	public EvalFunResOperation(EvalFunRes it, EmfswitchSwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
