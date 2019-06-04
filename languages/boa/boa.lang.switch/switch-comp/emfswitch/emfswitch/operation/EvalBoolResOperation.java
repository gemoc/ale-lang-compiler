package emfswitch.emfswitch.operation;

import boa.EvalBoolRes;
import emfswitch.emfswitch.EmfswitchSwitchImplementation;

public class EvalBoolResOperation extends EvalResOperation {
	private final EvalBoolRes it;

	private final EmfswitchSwitchImplementation emfswitch;

	public EvalBoolResOperation(EvalBoolRes it, EmfswitchSwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
