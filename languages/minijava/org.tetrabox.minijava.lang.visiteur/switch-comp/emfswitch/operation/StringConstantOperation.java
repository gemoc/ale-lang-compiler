package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.State;
import miniJava.StringConstant;
import miniJava.StringValue;
import miniJava.Value;

public class StringConstantOperation extends ExpressionOperation {
  private final StringConstant it;

  private final SwitchImplementation emfswitch;

  public StringConstantOperation(StringConstant it, SwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }

  public Value evaluateExpression(State state) {
    Value result;
    StringValue ret = ((StringValue)miniJava.MiniJavaFactory.eINSTANCE.createStringValue());
    ret.setValue(this.it.getValue());
    result = ret;
    return result;
  }
}
