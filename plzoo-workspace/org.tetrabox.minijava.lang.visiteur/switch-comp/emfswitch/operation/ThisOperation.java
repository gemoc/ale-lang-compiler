package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.ObjectInstance;
import miniJava.ObjectRefValue;
import miniJava.State;
import miniJava.This;
import miniJava.Value;

public class ThisOperation extends ExpressionOperation {
  private final This it;

  private final SwitchImplementation emfswitch;

  public ThisOperation(This it, SwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }

  public Value evaluateExpression(State state) {
    Value result;
    ObjectInstance currentInstance = ((ObjectInstance)/*CASEA*/((emfswitch.operation.StateOperation) emfswitch.doSwitch(state)).findCurrentFrame().getInstance());
    ObjectRefValue tmp = ((ObjectRefValue)miniJava.MiniJavaFactory.eINSTANCE.createObjectRefValue());
    tmp.setInstance(currentInstance);
    result = tmp;
    return result;
  }
}
