package fsm.visitor.fsm;

import java.lang.String;
import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface Transition extends EObject, AcceptInterface {
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
}
