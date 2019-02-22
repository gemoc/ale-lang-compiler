package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.BooleanValue;
import miniJava.Equality;
import miniJava.IntegerValue;
import miniJava.ObjectRefValue;
import miniJava.State;
import miniJava.StringValue;
import miniJava.Value;

public class EqualityOperation extends ExpressionOperation {
  private final Equality it;

  private final SwitchImplementation emfswitch;

  public EqualityOperation(Equality it, SwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }

  public Value evaluateExpression(State state) {
    Value result;
    Value left = ((Value)/*CASEA*/((emfswitch.operation.ExpressionOperation) emfswitch.doSwitch(this.it.getLeft())).evaluateExpression(state));
    Value right = ((Value)/*CASEA*/((emfswitch.operation.ExpressionOperation) emfswitch.doSwitch(this.it.getRight())).evaluateExpression(state));
    boolean tmp = ((boolean)false);
    if(left instanceof miniJava.IntegerValue) {
      if(right instanceof miniJava.IntegerValue) {
        IntegerValue ileft = ((IntegerValue)left);
        IntegerValue iright = ((IntegerValue)right);
        tmp = java.util.Objects.equals((ileft.getValue()), (iright.getValue()));
      }
    }
    else {
      if(left instanceof miniJava.StringValue) {
        if(right instanceof miniJava.StringValue) {
          StringValue ileft = ((StringValue)left);
          StringValue iright = ((StringValue)right);
          tmp = java.util.Objects.equals((ileft.getValue()), (iright.getValue()));
        }
      }
      else {
        if(left instanceof miniJava.BooleanValue) {
          if(right instanceof miniJava.BooleanValue) {
            BooleanValue ileft = ((BooleanValue)left);
            BooleanValue iright = ((BooleanValue)right);
            tmp = java.util.Objects.equals((/*CASEF*/ileft.isValue()), (/*CASEF*/iright.isValue()));
          }
        }
        else {
          if(left instanceof miniJava.NullValue) {
            if(right instanceof miniJava.NullValue) {
              tmp = true;
            }
          }
          else {
            if(left instanceof miniJava.ObjectRefValue) {
              if(right instanceof miniJava.ObjectRefValue) {
                ObjectRefValue ileft = ((ObjectRefValue)left);
                ObjectRefValue iright = ((ObjectRefValue)right);
                tmp = java.util.Objects.equals((ileft.getInstance()), (iright.getInstance()));
              }
            }
          }
        }
      }
    }
    BooleanValue tmpo = ((BooleanValue)miniJava.MiniJavaFactory.eINSTANCE.createBooleanValue());
    tmpo.setValue(tmp);
    result = tmpo;
    return result;
  }
}
