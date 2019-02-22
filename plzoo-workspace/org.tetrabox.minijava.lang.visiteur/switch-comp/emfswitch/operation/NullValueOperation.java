package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.NullValue;
import miniJava.Value;

public class NullValueOperation extends ValueOperation {
  private final NullValue it;

  private final SwitchImplementation emfswitch;

  public NullValueOperation(NullValue it, SwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }

  public Value copyj() {
    Value result;
    NullValue tmp = ((NullValue)miniJava.MiniJavaFactory.eINSTANCE.createNullValue());
    result = tmp;
    return result;
  }
}
