package emfswitch;

import emfswitch.operation.BufferOperation;
import emfswitch.operation.FSMOperation;
import emfswitch.operation.StateOperation;
import emfswitch.operation.SystemOperation;
import emfswitch.operation.TransitionOperation;
import fsm.model.fsm.Buffer;
import fsm.model.fsm.FSM;
import fsm.model.fsm.State;
import fsm.model.fsm.System;
import fsm.model.fsm.Transition;
import fsm.model.fsm.util.FsmSwitch;
import java.lang.Object;
import java.lang.Override;

public class SwitchImplementation extends FsmSwitch<Object> {
	@Override
	public Object caseFSM(FSM it) {
		return new FSMOperation(it, this);
	}

	@Override
	public Object caseState(State it) {
		return new StateOperation(it, this);
	}

	@Override
	public Object caseBuffer(Buffer it) {
		return new BufferOperation(it, this);
	}

	@Override
	public Object caseTransition(Transition it) {
		return new TransitionOperation(it, this);
	}

	@Override
	public Object caseSystem(System it) {
		return new SystemOperation(it, this);
	}
}
