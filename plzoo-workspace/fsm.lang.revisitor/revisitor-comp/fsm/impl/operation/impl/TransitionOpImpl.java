package fsm.impl.operation.impl;

import fsm.impl.operation.BufferOp;
import fsm.impl.operation.FSMOp;
import fsm.impl.operation.StateOp;
import fsm.impl.operation.SystemOp;
import fsm.impl.operation.TransitionOp;
import fsm.model.fsm.Buffer;
import fsm.model.fsm.FSM;
import fsm.model.fsm.Transition;
import fsm.model.revisitor.FsmRevisitor;
import java.lang.String;
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;

public class TransitionOpImpl implements TransitionOp {
  private FsmRevisitor<BufferOp, FSMOp, StateOp, SystemOp, TransitionOp> rev;

  private Transition obj;

  public TransitionOpImpl(Transition obj,
      FsmRevisitor<BufferOp, FSMOp, StateOp, SystemOp, TransitionOp> rev) {
    this.obj = obj;
    this.rev = rev;
  }

  public void fire() {
    LogService.log(((("Firing ") + (this.obj.getName())) + (" and entering ")) + (this.obj.getTgt().getName()));
    FSM fsm = ((FSM) (this.obj.getSrc().getFsm()));
    fsm.setCurrentState(this.obj.getTgt());
    rev.$((Buffer)fsm.getOutputBuffer()).enqueue(((String) (this.obj.getAction())));
    fsm.setConsummedString((fsm.getConsummedString()) + (fsm.getUnderProcessTrigger()));
  }
}
