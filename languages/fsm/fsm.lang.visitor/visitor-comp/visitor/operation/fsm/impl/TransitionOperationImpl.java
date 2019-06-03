package visitor.operation.fsm.impl;

import fsm.visitor.fsm.FSM;
import fsm.visitor.fsm.Transition;
import java.lang.String;
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;
import visitor.VisitorInterface;
import visitor.operation.fsm.BufferOperation;
import visitor.operation.fsm.TransitionOperation;

public class TransitionOperationImpl implements TransitionOperation {
	private final Transition it;

	private final VisitorInterface vis;

	public TransitionOperationImpl(Transition it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}

	public void fire() {
		LogService.log(((("Firing ") + (this.it.getName())) + (" and entering ")) + (this.it.getTgt().getName()));
		FSM fsm = ((FSM) (this.it.getSrc().getFsm()));
		fsm.setCurrentState(this.it.getTgt());
		((BufferOperation)fsm.getOutputBuffer().accept(vis)).enqueue((String) (this.it.getAction()));
		fsm.setConsummedString((fsm.getConsummedString()) + (fsm.getUnderProcessTrigger()));
	}
}
