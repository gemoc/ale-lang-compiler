package fsm.interpreter.fsm;

import java.lang.String;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public interface FSM extends EObject {
	String getName();

	void setName(String value);

	String getUnderProcessTrigger();

	void setUnderProcessTrigger(String value);

	String getConsummedString();

	void setConsummedString(String value);

	EList<State> getOwnedStates();

	EList<Transition> getOwnedTransitions();

	Buffer getInputBuffer();

	void setInputBuffer(Buffer value);

	Buffer getOutputBuffer();

	void setOutputBuffer(Buffer value);

	State getInitialState();

	void setInitialState(State value);

	State getCurrentState();

	void setCurrentState(State value);

	void initialize();

	void run();
}
