package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.IntegerValue;
import miniJava.Modulo;
import miniJava.State;
import miniJava.Value;

public class ModuloOperation extends ExpressionOperation {
  private final Modulo it;

  private final SwitchImplementation emfswitch;

  public ModuloOperation(Modulo it, SwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }

  public Value evaluateExpression(State state) {
    Value result;
    Value left = ((Value)/*CASEA*/((emfswitch.operation.ExpressionOperation) emfswitch.doSwitch(this.it.getLeft())).evaluateExpression(state));
    Value right = ((Value)/*CASEA*/((emfswitch.operation.ExpressionOperation) emfswitch.doSwitch(this.it.getRight())).evaluateExpression(state));
    if(left instanceof miniJava.IntegerValue) {
      if(right instanceof miniJava.IntegerValue) {
        IntegerValue bleft = ((IntegerValue)left);
        IntegerValue bright = ((IntegerValue)right);
        IntegerValue tmp = ((IntegerValue)miniJava.MiniJavaFactory.eINSTANCE.createIntegerValue());
        tmp.setValue(/*CASEB*/minijava.MathService.mod(this.it, bleft.getValue(), bright.getValue()));
        result = tmp;
      }
      else {
        result = null;
      }
    }
    else {
      result = null;
    }
    return result;
  }
}
