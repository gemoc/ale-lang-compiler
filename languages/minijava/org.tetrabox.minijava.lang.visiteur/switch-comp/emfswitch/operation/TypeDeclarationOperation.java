package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.TypeDeclaration;

public class TypeDeclarationOperation extends NamedElementOperation {
  private final TypeDeclaration it;

  private final SwitchImplementation emfswitch;

  public TypeDeclarationOperation(TypeDeclaration it, SwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }
}
