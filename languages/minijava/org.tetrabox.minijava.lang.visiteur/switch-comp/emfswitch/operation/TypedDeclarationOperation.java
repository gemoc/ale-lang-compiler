package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.TypedDeclaration;

public class TypedDeclarationOperation extends NamedElementOperation {
  private final TypedDeclaration it;

  private final SwitchImplementation emfswitch;

  public TypedDeclarationOperation(TypedDeclaration it, SwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }
}
