package emfswitch.operation;

import emfswitch.SwitchImplementation;
import fsm.model.fsm.FSM;
import fsm.model.fsm.Transition;
import java.lang.String;
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;

public class TransitionOperation {
	private final Transition it;

	private final SwitchImplementation emfswitch;

	public TransitionOperation(Transition it, SwitchImplementation emfswitch) {
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public void fire() {
		LogService.log(((("Firing ") + (this.it.getName())) + (" and entering ")) + (this.it.getTgt().getName()));
		FSM fsm = ((FSM) (this.it.getSrc().getFsm()));
		fsm.setCurrentState(this.it.getTgt());
		((BufferOperation) emfswitch.doSwitch(fsm.getOutputBuffer())).enqueue((String) this.it.getAction());
		fsm.setConsummedString((fsm.getConsummedString()) + (fsm.getUnderProcessTrigger()));
	}
}
