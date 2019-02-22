package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.ArrayAccess;
import miniJava.ArrayRefValue;
import miniJava.IntegerValue;
import miniJava.State;
import miniJava.Value;

public class ArrayAccessOperation extends ExpressionOperation {
  private final ArrayAccess it;

  private final SwitchImplementation emfswitch;

  public ArrayAccessOperation(ArrayAccess it, SwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }

  public Value evaluateExpression(State state) {
    Value result;
    ArrayRefValue arrayVal = ((ArrayRefValue)/*CASEA*/((emfswitch.operation.ExpressionOperation) emfswitch.doSwitch(this.it.getObject())).evaluateExpression(state));
    IntegerValue indexVal = ((IntegerValue)/*CASEA*/((emfswitch.operation.ExpressionOperation) emfswitch.doSwitch(this.it.getIndex())).evaluateExpression(state));
    Value value = arrayVal.getInstance().getValue().get(indexVal.getValue());
	result =  ((ValueOperation)emfswitch.caseValue(value)).copyj(); // /*CASEF*//*CASEF*/value.copyj();
    return result;
  }
}
