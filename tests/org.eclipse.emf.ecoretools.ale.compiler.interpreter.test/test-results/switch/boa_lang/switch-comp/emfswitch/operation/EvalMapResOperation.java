package emfswitch.operation;

import boa.EvalMapRes;
import emfswitch.SwitchImplementation;

public class EvalMapResOperation extends EvalResOperation {
	private final EvalMapRes it;

	private final SwitchImplementation emfswitch;

	public EvalMapResOperation(EvalMapRes it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
