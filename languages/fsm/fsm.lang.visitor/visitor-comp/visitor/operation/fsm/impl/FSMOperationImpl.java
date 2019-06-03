package visitor.operation.fsm.impl;

import fsm.visitor.fsm.FSM;
import java.lang.String;
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;
import visitor.VisitorInterface;
import visitor.operation.fsm.FSMOperation;
import visitor.operation.fsm.StateOperation;

public class FSMOperationImpl implements FSMOperation {
	private final FSM it;

	private final VisitorInterface vis;

	public FSMOperationImpl(FSM it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}

	public void initialize() {
		this.it.setCurrentState(this.it.getInitialState());
		this.it.setUnderProcessTrigger("");
		this.it.setConsummedString("");
	}

	public void run() {
		this.it.setUnderProcessTrigger(((visitor.operation.fsm.BufferOperation)this.it.getInputBuffer().accept(vis)).dequeue());
		LogService.log(((("run SM") + (this.it.getName())) + (" step on ")) + (this.it.getUnderProcessTrigger()));
		((StateOperation)this.it.getCurrentState().accept(vis)).step((String)this.it.getUnderProcessTrigger());
		this.it.setUnderProcessTrigger("");
	}
}
