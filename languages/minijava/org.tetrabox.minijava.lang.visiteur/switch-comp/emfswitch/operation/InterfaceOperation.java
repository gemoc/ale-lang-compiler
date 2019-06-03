package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.Interface;

public class InterfaceOperation extends TypeDeclarationOperation {
  private final Interface it;

  private final SwitchImplementation emfswitch;

  public InterfaceOperation(Interface it, SwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }
}
