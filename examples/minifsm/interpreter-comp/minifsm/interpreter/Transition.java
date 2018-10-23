package minifsm.interpreter;

import java.lang.String;
import org.eclipse.emf.ecore.EObject;

public interface Transition extends EObject {
  String getEvent();

  void setEvent(String event);

  State getIncoming();

  void setIncoming(State incoming);

  State getOutgoing();

  void setOutgoing(State outgoing);

  FSM getFsm();

  void setFsm(FSM fsm);

  boolean isActivated();
}
