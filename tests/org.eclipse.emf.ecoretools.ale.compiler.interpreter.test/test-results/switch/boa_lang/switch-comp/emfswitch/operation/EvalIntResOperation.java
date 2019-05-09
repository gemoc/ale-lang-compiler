package emfswitch.operation;

import boa.EvalIntRes;
import emfswitch.SwitchImplementation;

public class EvalIntResOperation extends EvalResOperation {
	private final EvalIntRes it;

	private final SwitchImplementation emfswitch;

	public EvalIntResOperation(EvalIntRes it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
