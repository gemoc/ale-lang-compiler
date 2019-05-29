package visitor;

import fsm.visitor.fsm.Buffer;
import fsm.visitor.fsm.FSM;
import fsm.visitor.fsm.State;
import fsm.visitor.fsm.System;
import fsm.visitor.fsm.Transition;
import java.lang.Object;

public interface VisitorInterface {
	Object visitfsm__FSM(FSM it);

	Object visitfsm__State(State it);

	Object visitfsm__Buffer(Buffer it);

	Object visitfsm__Transition(Transition it);

	Object visitfsm__System(System it);
}
