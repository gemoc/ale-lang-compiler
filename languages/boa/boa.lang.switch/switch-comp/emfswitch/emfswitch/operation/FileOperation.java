package emfswitch.emfswitch.operation;

import boa.BoaFactory;
import boa.Ctx;
import boa.File;
import boa.TopLevelCmd;
import emfswitch.emfswitch.EmfswitchSwitchImplementation;

public class FileOperation {
	private final File it;

	private final EmfswitchSwitchImplementation emfswitch;

	public FileOperation(File it, EmfswitchSwitchImplementation emfswitch) {
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public void eval() {
		Ctx ctx = ((Ctx) (BoaFactory.eINSTANCE.createCtx()));
		for (TopLevelCmd it: this.it.getCommands()) {
			((TopLevelCmdOperation) emfswitch.doSwitch(it)).nextLine((Ctx) (ctx));
		}
	}
}
