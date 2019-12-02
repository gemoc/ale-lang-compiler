package interpreter.emfswitch.operation;

import boa.Ctx;
import boa.TopLevelCmd;
import interpreter.emfswitch.InterpreterSwitchImplementation;

public class TopLevelCmdOperation {
	private final TopLevelCmd it;

	private final InterpreterSwitchImplementation emfswitch;

	public TopLevelCmdOperation(TopLevelCmd it, InterpreterSwitchImplementation emfswitch) {
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public void nextLine(Ctx ctx) {
	}
}
