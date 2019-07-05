package fsm.model.revisitor;

public interface FsmRevisitor<Fsm__BufferT, Fsm__FSMT, Fsm__StateT, Fsm__SystemT, Fsm__TransitionT> {
	Fsm__BufferT fsm__Buffer(final fsm.model.fsm.Buffer it);
	Fsm__FSMT fsm__FSM(final fsm.model.fsm.FSM it);
	Fsm__StateT fsm__State(final fsm.model.fsm.State it);
	Fsm__SystemT fsm__System(final fsm.model.fsm.System it);
	Fsm__TransitionT fsm__Transition(final fsm.model.fsm.Transition it);

	default Fsm__BufferT $(final fsm.model.fsm.Buffer it) {
		return fsm__Buffer(it);
	}
	default Fsm__FSMT $(final fsm.model.fsm.FSM it) {
		return fsm__FSM(it);
	}
	default Fsm__StateT $(final fsm.model.fsm.State it) {
		return fsm__State(it);
	}
	default Fsm__SystemT $(final fsm.model.fsm.System it) {
		return fsm__System(it);
	}
	default Fsm__TransitionT $(final fsm.model.fsm.Transition it) {
		return fsm__Transition(it);
	}
}
