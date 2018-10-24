package minifsm.interpreter.minifsm;

import java.lang.String;
import org.eclipse.emf.ecore.EObject;

public interface Transition extends EObject {
  String getEvent();

  void setEvent(String value);

  State getIncoming();

  void setIncoming(State value);

  State getOutgoing();

  void setOutgoing(State value);

  FSM getFsm();

  void setFsm(FSM value);

  boolean isActivated();
}
