package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.BoolConstant;
import miniJava.BooleanValue;
import miniJava.State;
import miniJava.Value;

public class BoolConstantOperation extends ExpressionOperation {
  private final BoolConstant it;

  private final SwitchImplementation emfswitch;

  public BoolConstantOperation(BoolConstant it, SwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }

  public Value evaluateExpression(State state) {
    Value result;
    BooleanValue ret = ((BooleanValue)miniJava.MiniJavaFactory.eINSTANCE.createBooleanValue());
    ret.setValue(java.util.Objects.equals((this.it.getValue()), ("true")));
    result = ret;
    return result;
  }
}
