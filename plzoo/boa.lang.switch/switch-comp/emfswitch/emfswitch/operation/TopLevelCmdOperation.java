package emfswitch.emfswitch.operation;

import boa.Ctx;
import boa.TopLevelCmd;
import emfswitch.emfswitch.EmfswitchSwitchImplementation;

public class TopLevelCmdOperation {
  private final TopLevelCmd it;

  private final EmfswitchSwitchImplementation emfswitch;

  public TopLevelCmdOperation(TopLevelCmd it, EmfswitchSwitchImplementation emfswitch) {
    this.it = it;
    this.emfswitch = emfswitch;
  }

  public void nextLine(Ctx ctx) {
  }
}
