package fsm.interpreter.fsm;

import java.lang.String;
import org.eclipse.emf.ecore.EObject;

public interface Transition extends EObject {
	String getName();

	void setName(String value);

	String getTrigger();

	void setTrigger(String value);

	String getAction();

	void setAction(String value);

	State getTgt();

	void setTgt(State value);

	State getSrc();

	void setSrc(State value);

	FSM getFsm();

	void setFsm(FSM value);

	void fire();
}
