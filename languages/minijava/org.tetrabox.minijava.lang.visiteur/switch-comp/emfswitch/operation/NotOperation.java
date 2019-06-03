package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.BooleanValue;
import miniJava.Not;
import miniJava.State;
import miniJava.Value;

public class NotOperation extends ExpressionOperation {
  private final Not it;

  private final SwitchImplementation emfswitch;

  public NotOperation(Not it, SwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }

  public Value evaluateExpression(State state) {
    Value result;
    BooleanValue left = ((BooleanValue)/*CASEA*/((emfswitch.operation.ExpressionOperation) emfswitch.doSwitch(this.it.getExpression())).evaluateExpression(state));
    BooleanValue tmp = ((BooleanValue)miniJava.MiniJavaFactory.eINSTANCE.createBooleanValue());
    tmp.setValue(!(/*CASEF*/left.isValue()));
    result = tmp;
    return result;
  }
}
