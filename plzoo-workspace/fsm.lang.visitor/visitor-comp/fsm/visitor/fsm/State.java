package fsm.visitor.fsm;

import java.lang.String;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface State extends EObject, AcceptInterface {
	String getName();

	void setName(String value);

	EList<Transition> getIncoming();

	EList<Transition> getOutgoing();

	FSM getFsm();

	void setFsm(FSM value);
}
