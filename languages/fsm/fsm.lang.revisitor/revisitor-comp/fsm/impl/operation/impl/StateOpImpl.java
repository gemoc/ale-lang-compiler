package fsm.impl.operation.impl;

import fsm.impl.operation.BufferOp;
import fsm.impl.operation.FSMOp;
import fsm.impl.operation.StateOp;
import fsm.impl.operation.SystemOp;
import fsm.impl.operation.TransitionOp;
import fsm.model.fsm.State;
import fsm.model.fsm.Transition;
import fsm.model.revisitor.FsmRevisitor;
import java.lang.String;
import org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService;
import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;

public class StateOpImpl implements StateOp {
  private FsmRevisitor<BufferOp, FSMOp, StateOp, SystemOp, TransitionOp> rev;

  private State obj;

  public StateOpImpl(State obj,
      FsmRevisitor<BufferOp, FSMOp, StateOp, SystemOp, TransitionOp> rev) {
    this.obj = obj;
    this.rev = rev;
  }

  public void step(String inputString) {
    Transition validTransition = ((Transition) (CollectionService.head(CollectionService.select(this.obj.getOutgoing(), (t) -> EqualService.equals((inputString), (t.getTrigger()))))));
    if(EqualService.equals((validTransition), (null))) {
      rev.$(this.obj.getFsm().getOutputBuffer()).enqueue(inputString);
    }
    else {
      rev.$((Transition)validTransition).fire();
    }
  }
}
