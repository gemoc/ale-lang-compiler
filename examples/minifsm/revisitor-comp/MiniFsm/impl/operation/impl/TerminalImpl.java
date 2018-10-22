package MiniFsm.impl.operation.impl;

import MiniFsm.impl.operation.FSM;
import MiniFsm.impl.operation.Initial;
import MiniFsm.impl.operation.State;
import MiniFsm.impl.operation.Terminal;
import MiniFsm.impl.operation.Transition;
import minifsm.revisitor.MinifsmRevisitor;

public class TerminalImpl extends StateImpl implements Terminal {
  private MinifsmRevisitor<FSM, Initial, State, Terminal, Transition> rev;

  private minifsm.Terminal obj;

  public TerminalImpl(minifsm.Terminal obj,
      MinifsmRevisitor<FSM, Initial, State, Terminal, Transition> rev) {
    super(obj, rev);
    this.obj = obj;
    this.rev = rev;
  }
}
