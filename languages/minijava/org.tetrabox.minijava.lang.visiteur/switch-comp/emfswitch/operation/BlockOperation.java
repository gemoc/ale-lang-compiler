package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.Block;
import miniJava.Frame;
import miniJava.State;

public class BlockOperation extends StatementOperation {
  private final Block it;

  private final SwitchImplementation emfswitch;

  public BlockOperation(Block it, SwitchImplementation emfswitch) {
    super(it, emfswitch);
    this.it = it;
    this.emfswitch = emfswitch;
  }

  public void evaluateStatementKeepContext(State state) {
    /*CASEA*/((emfswitch.operation.StateOperation) emfswitch.doSwitch(state)).pushNewContext();
    Frame currentFrame = ((Frame)/*CASEA*/((emfswitch.operation.StateOperation) emfswitch.doSwitch(state)).findCurrentFrame());
    int lgt = ((int)org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.size(this.it.getStatements()));
    int i = ((int)0);
    while ((((i) < (lgt)) && (java.util.Objects.equals((currentFrame.getReturnValue()), (null))))) {
      /*CASEA*/((emfswitch.operation.StatementOperation) emfswitch.doSwitch(org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.get(this.it.getStatements(), i))).evaluateStatement(state);
      i = (i) + (1);
    }
  }

  public void evaluateStatement(State state) {
    /*CASEA*/((emfswitch.operation.BlockOperation) emfswitch.doSwitch(this.it)).evaluateStatementKeepContext(state);
    /*CASEA*/((emfswitch.operation.StateOperation) emfswitch.doSwitch(state)).popCurrentContext();
  }
}
