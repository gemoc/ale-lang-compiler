package visitor.operation.fsm.impl;

import fsm.visitor.fsm.Buffer;
import fsm.visitor.fsm.FSM;
import fsm.visitor.fsm.System;
import visitor.VisitorInterface;
import visitor.operation.fsm.BufferOperation;
import visitor.operation.fsm.FSMOperation;
import visitor.operation.fsm.SystemOperation;

public class SystemOperationImpl implements SystemOperation {
	private final System it;

	private final VisitorInterface vis;

	public SystemOperationImpl(System it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}

	public void intialize() {
		for(FSM fsm: this.it.getOwnedFsms()) {
			((FSMOperation)fsm.accept(vis)).initialize();
		}
		for(Buffer b: this.it.getOwnedBuffers()) {
			((BufferOperation)b.accept(vis)).initialize();
		}
	}

	public void main() {
		((SystemOperation)this.it.accept(vis)).intialize();
		boolean anFSMRan = ((boolean) (true));
		int cptr = ((int) (0));
		while (((anFSMRan) && ((cptr) < (50000000)))) {
			anFSMRan = false;
			for(FSM fsm: this.it.getOwnedFsms()) {
				if(!(((BufferOperation)fsm.getInputBuffer().accept(vis)).bisEmpty())) {
					((FSMOperation)fsm.accept(vis)).run();
					anFSMRan = true;
				}
				cptr = (cptr) + (1);
			}
		}
	}
}
