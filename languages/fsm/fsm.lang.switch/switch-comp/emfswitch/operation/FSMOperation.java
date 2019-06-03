package emfswitch.operation;

import emfswitch.SwitchImplementation;
import fsm.model.fsm.FSM;
import java.lang.String;
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;

public class FSMOperation {
	private final FSM it;

	private final SwitchImplementation emfswitch;

	public FSMOperation(FSM it, SwitchImplementation emfswitch) {
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public void initialize() {
		this.it.setCurrentState(this.it.getInitialState());
		this.it.setUnderProcessTrigger("");
		this.it.setConsummedString("");
	}

	public void run() {
		this.it.setUnderProcessTrigger(((BufferOperation) emfswitch.doSwitch(this.it.getInputBuffer())).dequeue());
		LogService.log(((("run SM") + (this.it.getName())) + (" step on ")) + (this.it.getUnderProcessTrigger()));
		((StateOperation) emfswitch.doSwitch(this.it.getCurrentState())).step((String) this.it.getUnderProcessTrigger());
		this.it.setUnderProcessTrigger("");
	}
}
