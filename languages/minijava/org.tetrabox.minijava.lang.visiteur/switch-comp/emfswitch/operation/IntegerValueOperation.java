package emfswitch.operation;

import emfswitch.SwitchImplementation;
import java.lang.String;
import miniJava.IntegerValue;
import miniJava.Value;

public class IntegerValueOperation extends ValueOperation {
  private final IntegerValue it;

  private final SwitchImplementation emfswitch;

  public IntegerValueOperation(IntegerValue it, SwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }

  public String customToString() {
    String result;
    result = (this.it.getValue()) + ("");
    return result;
  }

  public Value copyj() {
    Value result;
    IntegerValue tmp = ((IntegerValue)miniJava.MiniJavaFactory.eINSTANCE.createIntegerValue());
    tmp.setValue(this.it.getValue());
    result = tmp;
    return result;
  }
}
