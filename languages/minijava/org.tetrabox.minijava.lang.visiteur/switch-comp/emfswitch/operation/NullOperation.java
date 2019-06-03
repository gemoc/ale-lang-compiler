package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.Null;
import miniJava.State;
import miniJava.Value;

public class NullOperation extends ExpressionOperation {
  private final Null it;

  private final SwitchImplementation emfswitch;

  public NullOperation(Null it, SwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }

  public Value evaluateExpression(State state) {
    Value result;
    result = miniJava.MiniJavaFactory.eINSTANCE.createNullValue();
    return result;
  }
}
