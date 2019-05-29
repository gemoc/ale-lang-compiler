package fsm.visitor.fsm;

import java.lang.String;
import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface Buffer extends EObject, AcceptInterface {
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
}
