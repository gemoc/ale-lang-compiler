package MiniFsm.impl;

import MiniFsm.impl.operation.FSM;
import MiniFsm.impl.operation.Initial;
import MiniFsm.impl.operation.State;
import MiniFsm.impl.operation.Terminal;
import MiniFsm.impl.operation.Transition;
import MiniFsm.impl.operation.impl.FSMImpl;
import MiniFsm.impl.operation.impl.InitialImpl;
import MiniFsm.impl.operation.impl.StateImpl;
import MiniFsm.impl.operation.impl.TerminalImpl;
import MiniFsm.impl.operation.impl.TransitionImpl;
import minifsm.revisitor.MinifsmRevisitor;

public interface MiniFsmImplementation extends MinifsmRevisitor<FSM, Initial, State, Terminal, Transition> {
  default FSM minifsm__FSM(minifsm.FSM it) {
    return new FSMImpl(it, this);
  }

  default State minifsm__State(minifsm.State it) {
    return new StateImpl(it, this);
  }

  default Transition minifsm__Transition(minifsm.Transition it) {
    return new TransitionImpl(it, this);
  }

  default Initial minifsm__Initial(minifsm.Initial it) {
    return new InitialImpl(it, this);
  }

  default Terminal minifsm__Terminal(minifsm.Terminal it) {
    return new TerminalImpl(it, this);
  }
}
