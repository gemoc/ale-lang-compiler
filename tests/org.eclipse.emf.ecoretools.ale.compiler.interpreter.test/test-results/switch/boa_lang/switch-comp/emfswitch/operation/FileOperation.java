package emfswitch.operation;

import boa.BoaFactory;
import boa.Ctx;
import boa.File;
import boa.TopLevelCmd;
import emfswitch.SwitchImplementation;
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;

public class FileOperation {
	private final File it;

	private final SwitchImplementation emfswitch;

	public FileOperation(File it, SwitchImplementation emfswitch) {
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public void eval() {
		LogService.log("v2");
		Ctx ctx = ((Ctx) (BoaFactory.eINSTANCE.createCtx()));
		for (TopLevelCmd it: this.it.getCommands()) {
			((TopLevelCmdOperation) emfswitch.doSwitch(it)).nextLine((Ctx) ctx);
		}
	}
}
