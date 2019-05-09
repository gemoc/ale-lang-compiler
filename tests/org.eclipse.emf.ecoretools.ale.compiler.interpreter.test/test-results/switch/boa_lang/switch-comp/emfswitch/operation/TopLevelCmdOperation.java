package emfswitch.operation;

import boa.Ctx;
import boa.TopLevelCmd;
import emfswitch.SwitchImplementation;

public class TopLevelCmdOperation {
	private final TopLevelCmd it;

	private final SwitchImplementation emfswitch;

	public TopLevelCmdOperation(TopLevelCmd it, SwitchImplementation emfswitch) {
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public void nextLine(Ctx ctx) {
	}
}
