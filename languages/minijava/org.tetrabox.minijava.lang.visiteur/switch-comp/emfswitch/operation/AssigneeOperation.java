package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.Assignee;

public class AssigneeOperation {
  private final Assignee it;

  private final SwitchImplementation emfswitch;

  public AssigneeOperation(Assignee it, SwitchImplementation emfswitch) {
    this.it = it;
    this.emfswitch = emfswitch;
  }
}
