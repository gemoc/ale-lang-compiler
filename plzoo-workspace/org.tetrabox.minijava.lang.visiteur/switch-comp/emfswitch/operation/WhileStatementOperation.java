package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.BooleanValue;
import miniJava.State;
import miniJava.WhileStatement;

public class WhileStatementOperation extends StatementOperation {
  private final WhileStatement it;

  private final SwitchImplementation emfswitch;

  public WhileStatementOperation(WhileStatement it, SwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }

  public void evaluateStatement(State state) {
    BooleanValue continueWhile = ((BooleanValue)/*CASEA*/((emfswitch.operation.ExpressionOperation) emfswitch.doSwitch(this.it.getCondition())).evaluateExpression(state));
    while (/*CASEF*/continueWhile.isValue()) {
      /*CASEA*/((emfswitch.operation.BlockOperation) emfswitch.doSwitch(this.it.getBlock())).evaluateStatement(state);
      BooleanValue continueWhile2 = ((BooleanValue)/*CASEA*/((emfswitch.operation.ExpressionOperation) emfswitch.doSwitch(this.it.getCondition())).evaluateExpression(state));
      continueWhile = continueWhile2;
    }
  }
}
