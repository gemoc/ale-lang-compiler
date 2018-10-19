package MiniFsm.impl.operation.impl;

import MiniFsm.impl.operation.FSM;
import MiniFsm.impl.operation.Initial;
import MiniFsm.impl.operation.State;
import MiniFsm.impl.operation.Terminal;
import MiniFsm.impl.operation.Transition;
import minifsm.revisitor.MinifsmRevisitor;

public class StateImpl implements State {
  private MinifsmRevisitor<FSM, Initial, State, Terminal, Transition> rev;

  private minifsm.State obj;

  public StateImpl(minifsm.State obj,
      MinifsmRevisitor<FSM, Initial, State, Terminal, Transition> rev) {
    this.obj = obj;
    this.rev = rev;
  }

  public void execute() {
    org.eclipse.emf.ecoretools.ale.compiler.lib.LogService.log((" Execute ") + (this.obj.getName()));
  }
}
