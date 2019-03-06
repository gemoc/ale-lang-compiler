package emfswitch.operation;

import emfswitch.SwitchImplementation;
import fsm.model.fsm.State;
import fsm.model.fsm.Transition;
import java.lang.String;

public class StateOperation {
	private final State it;

	private final SwitchImplementation emfswitch;

	public StateOperation(State it, SwitchImplementation emfswitch) {
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public void step(String inputString) {
		Transition validTransition = ((Transition) org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService
				.head(org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.select(this.it.getOutgoing(),
						(t) -> java.util.Objects.equals((inputString), (t.getTrigger())))));
		if (java.util.Objects.equals((validTransition), (null))) {
			/* CASEF *//* CASEC */((BufferOperation) emfswitch.doSwitch(this.it.getFsm().getOutputBuffer()))
					.enqueue(inputString);
		} else {
			/* CASEA */((emfswitch.operation.TransitionOperation) emfswitch.doSwitch(validTransition)).fire();
		}
	}
}
