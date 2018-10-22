package MiniFsm.impl.operation.impl;

import MiniFsm.impl.operation.FSM;
import MiniFsm.impl.operation.Initial;
import MiniFsm.impl.operation.State;
import MiniFsm.impl.operation.Terminal;
import MiniFsm.impl.operation.Transition;
import minifsm.revisitor.MinifsmRevisitor;

public class TransitionImpl implements Transition {
  private MinifsmRevisitor<FSM, Initial, State, Terminal, Transition> rev;

  private minifsm.Transition obj;

  public TransitionImpl(minifsm.Transition obj,
      MinifsmRevisitor<FSM, Initial, State, Terminal, Transition> rev) {
    this.obj = obj;
    this.rev = rev;
  }

  public boolean isActivated() {
    boolean result;
    result = ((java.util.Objects.equals((this.obj.getEvent()), (this.obj.getFsm().getCurrentEvent()))) && (java.util.Objects.equals((this.obj.getIncoming()), (this.obj.getFsm().getCurrentState()))));
    return result;
  }
}
