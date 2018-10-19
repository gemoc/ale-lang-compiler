package MiniFsm.impl.operation.impl;

import MiniFsm.impl.operation.FSM;
import MiniFsm.impl.operation.Initial;
import MiniFsm.impl.operation.State;
import MiniFsm.impl.operation.Terminal;
import MiniFsm.impl.operation.Transition;
import java.lang.String;
import minifsm.revisitor.MinifsmRevisitor;
import org.eclipse.emf.common.util.EList;

public class FSMImpl implements FSM {
  private MinifsmRevisitor<FSM, Initial, State, Terminal, Transition> rev;

  private minifsm.FSM obj;

  public FSMImpl(minifsm.FSM obj, MinifsmRevisitor<FSM, Initial, State, Terminal, Transition> rev) {
    this.obj = obj;
    this.rev = rev;
  }

  public void handle(String event) {
    org.eclipse.emf.ecoretools.ale.compiler.lib.LogService.log(("Handle ") + (event));
    this.obj.setCurrentEvent(event);
    this.obj.setCurrentState(org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.head(org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.select(this.obj.getTransitions(), (t) -> rev.$(t).isActivated())).getOutgoing());
  }

  public void entryPoint() {
    EList<String> events = ((EList<String>)org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.createEList("event1", "event2"));
    org.eclipse.emf.ecoretools.ale.compiler.lib.LogService.log("Start");
    this.obj.setCurrentState(org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.head(org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.select(this.obj.getStates(), it -> it instanceof minifsm.Initial)));
    rev.$(this.obj.getCurrentState()).execute();
    for(String event: events) {
      rev.$(this.obj).handle(event);
      rev.$(this.obj.getCurrentState()).execute();
    }
    org.eclipse.emf.ecoretools.ale.compiler.lib.LogService.log("End");
  }
}
