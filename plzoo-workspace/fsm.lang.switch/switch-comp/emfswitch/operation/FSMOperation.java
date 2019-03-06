package emfswitch.operation;

import emfswitch.SwitchImplementation;
import fsm.model.fsm.FSM;

public class FSMOperation {
  private final FSM it;

  private final SwitchImplementation emfswitch;

  public FSMOperation(FSM it, SwitchImplementation emfswitch) {
    this.it = it;
    this.emfswitch = emfswitch;
  }

  public void initialize() {
    this.it.setCurrentState(this.it.getInitialState());
    this.it.setUnderProcessTrigger("");
    this.it.setConsummedString("");
  }

  public void run() {
    this.it.setUnderProcessTrigger(/*CASEA*/((emfswitch.operation.BufferOperation) emfswitch.doSwitch(this.it.getInputBuffer())).dequeue());
    org.eclipse.emf.ecoretools.ale.compiler.lib.LogService.log(((("run SM") + (this.it.getName())) + (" step on ")) + (this.it.getUnderProcessTrigger()));
    /*CASEA*/((emfswitch.operation.StateOperation) emfswitch.doSwitch(this.it.getCurrentState())).step(this.it.getUnderProcessTrigger());
    this.it.setUnderProcessTrigger("");
  }
}
