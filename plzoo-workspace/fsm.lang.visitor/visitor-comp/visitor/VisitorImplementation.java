package visitor;

import fsm.visitor.fsm.Buffer;
import fsm.visitor.fsm.FSM;
import fsm.visitor.fsm.State;
import fsm.visitor.fsm.System;
import fsm.visitor.fsm.Transition;
import visitor.operation.fsm.BufferOperation;
import visitor.operation.fsm.FSMOperation;
import visitor.operation.fsm.StateOperation;
import visitor.operation.fsm.SystemOperation;
import visitor.operation.fsm.TransitionOperation;
import visitor.operation.fsm.impl.BufferOperationImpl;
import visitor.operation.fsm.impl.FSMOperationImpl;
import visitor.operation.fsm.impl.StateOperationImpl;
import visitor.operation.fsm.impl.SystemOperationImpl;
import visitor.operation.fsm.impl.TransitionOperationImpl;

public class VisitorImplementation implements VisitorInterface {
	public FSMOperation visitfsm__FSM(FSM it) {
		return new FSMOperationImpl(it, this);
	}

	public StateOperation visitfsm__State(State it) {
		return new StateOperationImpl(it, this);
	}

	public BufferOperation visitfsm__Buffer(Buffer it) {
		return new BufferOperationImpl(it, this);
	}

	public TransitionOperation visitfsm__Transition(Transition it) {
		return new TransitionOperationImpl(it, this);
	}

	public SystemOperation visitfsm__System(System it) {
		return new SystemOperationImpl(it, this);
	}
}
