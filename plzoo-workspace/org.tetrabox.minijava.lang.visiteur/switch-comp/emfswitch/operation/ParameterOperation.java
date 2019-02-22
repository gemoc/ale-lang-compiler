package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.Parameter;

public class ParameterOperation extends SymbolOperation {
  private final Parameter it;

  private final SwitchImplementation emfswitch;

  public ParameterOperation(Parameter it, SwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }

  public boolean compare(Parameter other) {
    boolean result;
    result = ((java.util.Objects.equals((this.it.getName()), (other.getName()))) && (/*CASEA*/((emfswitch.operation.TypeRefOperation) emfswitch.doSwitch(this.it.getTypeRef())).compare(other.getTypeRef())));
    return result;
  }
}
