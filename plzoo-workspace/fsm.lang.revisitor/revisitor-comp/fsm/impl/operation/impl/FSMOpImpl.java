package fsm.impl.operation.impl;

import fsm.impl.operation.BufferOp;
import fsm.impl.operation.FSMOp;
import fsm.impl.operation.StateOp;
import fsm.impl.operation.SystemOp;
import fsm.impl.operation.TransitionOp;
import fsm.model.fsm.Buffer;
import fsm.model.fsm.FSM;
import fsm.model.fsm.State;
import fsm.model.revisitor.FsmRevisitor;
import java.lang.String;
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;

public class FSMOpImpl implements FSMOp {
  private FsmRevisitor<BufferOp, FSMOp, StateOp, SystemOp, TransitionOp> rev;

  private FSM obj;

  public FSMOpImpl(FSM obj, FsmRevisitor<BufferOp, FSMOp, StateOp, SystemOp, TransitionOp> rev) {
    this.obj = obj;
    this.rev = rev;
  }

  public void initialize() {
    this.obj.setCurrentState(this.obj.getInitialState());
    this.obj.setUnderProcessTrigger("");
    this.obj.setConsummedString("");
  }

  public void run() {
    this.obj.setUnderProcessTrigger(rev.$((Buffer)this.obj.getInputBuffer()).dequeue());
    LogService.log(((("run SM") + (this.obj.getName())) + (" step on ")) + (this.obj.getUnderProcessTrigger()));
    rev.$((State)this.obj.getCurrentState()).step(((String) (this.obj.getUnderProcessTrigger())));
    this.obj.setUnderProcessTrigger("");
  }
}
