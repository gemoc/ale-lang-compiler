package minifsm.revisitor;

public interface MinifsmRevisitor<Minifsm__FSMT, Minifsm__InitialT extends Minifsm__StateT, Minifsm__StateT, Minifsm__TerminalT extends Minifsm__StateT, Minifsm__TransitionT> {
	Minifsm__FSMT minifsm__FSM(final minifsm.FSM it);
	Minifsm__InitialT minifsm__Initial(final minifsm.Initial it);
	Minifsm__StateT minifsm__State(final minifsm.State it);
	Minifsm__TerminalT minifsm__Terminal(final minifsm.Terminal it);
	Minifsm__TransitionT minifsm__Transition(final minifsm.Transition it);

	default Minifsm__FSMT $(final minifsm.FSM it) {
		return minifsm__FSM(it);
	}
	default Minifsm__InitialT $(final minifsm.Initial it) {
		return minifsm__Initial(it);
	}
	default Minifsm__StateT $(final minifsm.State it) {
		if (it.getClass() == minifsm.impl.InitialImpl.class)
			return minifsm__Initial((minifsm.Initial) it);
		if (it.getClass() == minifsm.impl.TerminalImpl.class)
			return minifsm__Terminal((minifsm.Terminal) it);
		return minifsm__State(it);
	}
	default Minifsm__TerminalT $(final minifsm.Terminal it) {
		return minifsm__Terminal(it);
	}
	default Minifsm__TransitionT $(final minifsm.Transition it) {
		return minifsm__Transition(it);
	}
}
