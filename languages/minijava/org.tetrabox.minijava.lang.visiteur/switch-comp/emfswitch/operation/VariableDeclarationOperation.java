package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.VariableDeclaration;

public class VariableDeclarationOperation extends SymbolOperation {
  private final VariableDeclaration it;

  private final SwitchImplementation emfswitch;

  public VariableDeclarationOperation(VariableDeclaration it, SwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }
}
