package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.BooleanValue;
import miniJava.IfStatement;
import miniJava.State;

public class IfStatementOperation extends StatementOperation {
  private final IfStatement it;

  private final SwitchImplementation emfswitch;

  public IfStatementOperation(IfStatement it, SwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }

  public void evaluateStatement(State state) {
    BooleanValue booleanValue = ((BooleanValue)/*CASEA*/((emfswitch.operation.ExpressionOperation) emfswitch.doSwitch(this.it.getExpression())).evaluateExpression(state));
    if(/*CASEF*/booleanValue.isValue()) {
      /*CASEA*/((emfswitch.operation.BlockOperation) emfswitch.doSwitch(this.it.getThenBlock())).evaluateStatement(state);
    }
    else {
      if((this.it.getElseBlock()) != (null)) {
        /*CASEA*/((emfswitch.operation.BlockOperation) emfswitch.doSwitch(this.it.getElseBlock())).evaluateStatement(state);
      }
    }
  }
}
