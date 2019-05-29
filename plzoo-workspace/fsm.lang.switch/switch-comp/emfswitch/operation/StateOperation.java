package emfswitch.operation;

import emfswitch.SwitchImplementation;
import fsm.model.fsm.State;
import fsm.model.fsm.Transition;
import java.lang.String;
import org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService;
import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;

public class StateOperation {
	private final State it;

	private final SwitchImplementation emfswitch;

	public StateOperation(State it, SwitchImplementation emfswitch) {
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public void step(String inputString) {
		Transition validTransition = ((Transition) (CollectionService.head(CollectionService.select(this.it.getOutgoing(), (t) -> EqualService.equals((inputString), (t.getTrigger()))))));
		if(EqualService.equals((validTransition), (null))) {
			((BufferOperation) emfswitch.doSwitch(it.getFsm().getOutputBuffer())).enqueue(inputString);
		}
		else {
			((TransitionOperation) emfswitch.doSwitch(validTransition)).fire();
		}
	}
}
