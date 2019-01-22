package fsm.interpreter.fsm;

import java.lang.String;
import org.eclipse.emf.ecore.EObject;

public interface Buffer extends EObject {
  String getInitialValue();

  void setInitialValue(String value);

  String getName();

  void setName(String value);

  String getCurrentValues();

  void setCurrentValues(String value);

  FSM getOutgoingFSM();

  void setOutgoingFSM(FSM value);

  FSM getIncomingFSM();

  void setIncomingFSM(FSM value);

  void initialize();

  boolean bisEmpty();

  void enqueue(String v);

  String dequeue();
}
