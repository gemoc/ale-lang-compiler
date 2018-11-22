package emfswitch.emfswitch.operation;

import emfswitch.emfswitch.EmfswitchSwitchImplementation;
import kmLogo.Point;

public class PointOperation {
  private final Point it;

  private final EmfswitchSwitchImplementation emfswitch;

  public PointOperation(Point it, EmfswitchSwitchImplementation emfswitch) {
    this.it = it;
    this.emfswitch = emfswitch;
  }
}
