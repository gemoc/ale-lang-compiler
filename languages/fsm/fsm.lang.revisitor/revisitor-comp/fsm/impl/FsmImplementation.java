package fsm.impl;

import fsm.impl.operation.BufferOp;
import fsm.impl.operation.FSMOp;
import fsm.impl.operation.StateOp;
import fsm.impl.operation.SystemOp;
import fsm.impl.operation.TransitionOp;
import fsm.impl.operation.impl.BufferOpImpl;
import fsm.impl.operation.impl.FSMOpImpl;
import fsm.impl.operation.impl.StateOpImpl;
import fsm.impl.operation.impl.SystemOpImpl;
import fsm.impl.operation.impl.TransitionOpImpl;
import fsm.model.fsm.Buffer;
import fsm.model.fsm.FSM;
import fsm.model.fsm.State;
import fsm.model.fsm.System;
import fsm.model.fsm.Transition;
import fsm.model.revisitor.FsmRevisitor;

public interface FsmImplementation extends FsmRevisitor<BufferOp, FSMOp, StateOp, SystemOp, TransitionOp> {
	default FSMOp fsm__FSM(FSM it) {
		return new FSMOpImpl(it, this);
	}

	default StateOp fsm__State(State it) {
		return new StateOpImpl(it, this);
	}

	default BufferOp fsm__Buffer(Buffer it) {
		return new BufferOpImpl(it, this);
	}

	default TransitionOp fsm__Transition(Transition it) {
		return new TransitionOpImpl(it, this);
	}

	default SystemOp fsm__System(System it) {
		return new SystemOpImpl(it, this);
	}
}
