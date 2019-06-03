package emfswitch.emfswitch.operation;

import boa.EvalMapRes;
import emfswitch.emfswitch.EmfswitchSwitchImplementation;

public class EvalMapResOperation extends EvalResOperation {
	private final EvalMapRes it;

	private final EmfswitchSwitchImplementation emfswitch;

	public EvalMapResOperation(EvalMapRes it, EmfswitchSwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
