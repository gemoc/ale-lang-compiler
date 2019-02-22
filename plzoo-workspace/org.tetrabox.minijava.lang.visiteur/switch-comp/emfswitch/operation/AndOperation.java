package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.And;
import miniJava.BooleanValue;
import miniJava.State;
import miniJava.Value;

public class AndOperation extends ExpressionOperation {
  private final And it;

  private final SwitchImplementation emfswitch;

  public AndOperation(And it, SwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }

  public Value evaluateExpression(State state) {
    Value result;
    Value left = ((ExpressionOperation) emfswitch.caseExpression(this.it.getLeft())).evaluateExpression(state);
    Value right = ((ExpressionOperation) emfswitch.caseExpression(this.it.getRight())).evaluateExpression(state);;
    if(left instanceof miniJava.BooleanValue) {
      if(right instanceof miniJava.BooleanValue) {
        BooleanValue bleft = ((BooleanValue)left);
        BooleanValue bright = ((BooleanValue)right);
        BooleanValue tmp = ((BooleanValue)miniJava.MiniJavaFactory.eINSTANCE.createBooleanValue());
        tmp.setValue(((/*CASEF*/bleft.isValue()) && (/*CASEF*/bright.isValue())));
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
