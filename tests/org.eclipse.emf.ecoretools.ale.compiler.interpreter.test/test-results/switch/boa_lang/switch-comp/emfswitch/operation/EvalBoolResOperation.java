package emfswitch.operation;

import boa.EvalBoolRes;
import emfswitch.SwitchImplementation;

public class EvalBoolResOperation extends EvalResOperation {
	private final EvalBoolRes it;

	private final SwitchImplementation emfswitch;

	public EvalBoolResOperation(EvalBoolRes it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
