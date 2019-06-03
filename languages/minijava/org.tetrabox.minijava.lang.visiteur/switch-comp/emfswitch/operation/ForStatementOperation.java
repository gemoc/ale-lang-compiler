package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.BooleanValue;
import miniJava.ForStatement;
import miniJava.State;

public class ForStatementOperation extends StatementOperation {
  private final ForStatement it;

  private final SwitchImplementation emfswitch;

  public ForStatementOperation(ForStatement it, SwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }

  public void evaluateStatement(State state) {
    /*CASEA*/((emfswitch.operation.StateOperation) emfswitch.doSwitch(state)).pushNewContext();
    /*CASEA*/((emfswitch.operation.AssignmentOperation) emfswitch.doSwitch(this.it.getDeclaration())).evaluateStatement(state);
    BooleanValue continueFor = ((BooleanValue)/*CASEA*/((emfswitch.operation.ExpressionOperation) emfswitch.doSwitch(this.it.getCondition())).evaluateExpression(state));
    while (/*CASEF*/continueFor.isValue()) {
      /*CASEA*/((emfswitch.operation.BlockOperation) emfswitch.doSwitch(this.it.getBlock())).evaluateStatement(state);
      /*CASEA*/((emfswitch.operation.AssignmentOperation) emfswitch.doSwitch(this.it.getProgression())).evaluateStatement(state);
      BooleanValue continueFor2 = ((BooleanValue)/*CASEA*/((emfswitch.operation.ExpressionOperation) emfswitch.doSwitch(this.it.getCondition())).evaluateExpression(state));
      continueFor = continueFor2;
    }
    /*CASEA*/((emfswitch.operation.StateOperation) emfswitch.doSwitch(state)).popCurrentContext();
  }
}
