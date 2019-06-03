package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.Symbol;

public class SymbolOperation extends TypedDeclarationOperation {
  private final Symbol it;

  private final SwitchImplementation emfswitch;

  public SymbolOperation(Symbol it, SwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }
}
