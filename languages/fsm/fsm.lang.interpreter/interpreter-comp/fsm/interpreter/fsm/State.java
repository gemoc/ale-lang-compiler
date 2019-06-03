package fsm.interpreter.fsm;

import java.lang.String;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public interface State extends EObject {
	String getName();

	void setName(String value);

	EList<Transition> getIncoming();

	EList<Transition> getOutgoing();

	FSM getFsm();

	void setFsm(FSM value);

	void step(String inputString);
}
