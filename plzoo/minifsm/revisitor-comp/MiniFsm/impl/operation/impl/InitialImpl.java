package MiniFsm.impl.operation.impl;

import MiniFsm.impl.operation.FSM;
import MiniFsm.impl.operation.Initial;
import MiniFsm.impl.operation.State;
import MiniFsm.impl.operation.Terminal;
import MiniFsm.impl.operation.Transition;
import minifsm.revisitor.MinifsmRevisitor;

public class InitialImpl extends StateImpl implements Initial {
  private MinifsmRevisitor<FSM, Initial, State, Terminal, Transition> rev;

  private minifsm.Initial obj;

  public InitialImpl(minifsm.Initial obj,
      MinifsmRevisitor<FSM, Initial, State, Terminal, Transition> rev) {
    super(obj, rev);
    this.obj = obj;
    this.rev = rev;
  }
}
