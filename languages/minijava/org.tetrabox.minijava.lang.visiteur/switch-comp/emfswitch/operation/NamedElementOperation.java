package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.NamedElement;

public class NamedElementOperation {
  private final NamedElement it;

  private final SwitchImplementation emfswitch;

  public NamedElementOperation(NamedElement it, SwitchImplementation emfswitch) {
    this.it = it;
    this.emfswitch = emfswitch;
  }
}
