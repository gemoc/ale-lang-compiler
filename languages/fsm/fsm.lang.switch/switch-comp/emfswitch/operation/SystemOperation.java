package emfswitch.operation;

import emfswitch.SwitchImplementation;
import fsm.model.fsm.Buffer;
import fsm.model.fsm.FSM;
import fsm.model.fsm.System;
import java.lang.Boolean;
import java.lang.Integer;

public class SystemOperation {
	private final System it;

	private final SwitchImplementation emfswitch;

	public SystemOperation(System it, SwitchImplementation emfswitch) {
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public void intialize() {
		for (FSM fsm: this.it.getOwnedFsms()) {
			((FSMOperation) emfswitch.doSwitch(fsm)).initialize();
		}
		for (Buffer b: this.it.getOwnedBuffers()) {
			((BufferOperation) emfswitch.doSwitch(b)).initialize();
		}
	}

	public void main(int limit) {
		((SystemOperation) emfswitch.doSwitch(this.it)).intialize();
		boolean anFSMRan = ((boolean) (true));
		int cptr = ((int) (0));
		while (((anFSMRan) && ((cptr) < (limit)))) {
			anFSMRan = ((Boolean) (false));
			for (FSM fsm: this.it.getOwnedFsms()) {
				if(!(((BufferOperation) emfswitch.doSwitch(fsm.getInputBuffer())).bisEmpty())) {
					((FSMOperation) emfswitch.doSwitch(fsm)).run();
					anFSMRan = ((Boolean) (true));
				}
				cptr = ((Integer) ((cptr) + (1)));
			}
		}
	}
}
