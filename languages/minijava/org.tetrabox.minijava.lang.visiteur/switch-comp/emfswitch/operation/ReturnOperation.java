package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.Return;
import miniJava.State;
import miniJava.Value;

public class ReturnOperation extends StatementOperation {
  private final Return it;

  private final SwitchImplementation emfswitch;

  public ReturnOperation(Return it, SwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }

  public void evaluateStatement(State state) {
    Value value = ((Value)/*CASEA*/((emfswitch.operation.ExpressionOperation) emfswitch.doSwitch(this.it.getExpression())).evaluateExpression(state));
    /*CASEA*/((emfswitch.operation.StateOperation) emfswitch.doSwitch(state)).findCurrentFrame().setReturnValue(value);
  }
}
