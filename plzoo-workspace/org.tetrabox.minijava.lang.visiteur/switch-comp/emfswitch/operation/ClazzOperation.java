package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.Clazz;

public class ClazzOperation extends TypeDeclarationOperation {
  private final Clazz it;

  private final SwitchImplementation emfswitch;

  public ClazzOperation(Clazz it, SwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }
}
