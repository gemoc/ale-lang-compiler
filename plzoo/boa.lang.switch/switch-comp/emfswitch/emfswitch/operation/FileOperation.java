package emfswitch.emfswitch.operation;

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
    org.eclipse.emf.ecoretools.ale.compiler.lib.LogService.log("v2");
    Ctx ctx = ((Ctx)boa.BoaFactory.eINSTANCE.createCtx());
    for(TopLevelCmd it: this.it.getCommands()) {
      ((emfswitch.emfswitch.operation.TopLevelCmdOperation) emfswitch.doSwitch(it)).nextLine(ctx);
    }
  }
}
