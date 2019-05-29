package visitor.operation.fsm.impl;

import fsm.visitor.fsm.State;
import fsm.visitor.fsm.Transition;
import java.lang.String;
import org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService;
import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;
import visitor.VisitorInterface;
import visitor.operation.fsm.StateOperation;
import visitor.operation.fsm.TransitionOperation;

public class StateOperationImpl implements StateOperation {
	private final State it;

	private final VisitorInterface vis;

	public StateOperationImpl(State it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}

	public void step(String inputString) {
		Transition validTransition = ((Transition) (CollectionService.head(CollectionService.select(this.it.getOutgoing(), (t) -> EqualService.equals((inputString), (t.getTrigger()))))));
		if(EqualService.equals((validTransition), (null))) {
			((BufferOperationImpl) this.it.getFsm().getOutputBuffer().accept(vis)).enqueue(inputString);
		}
		else {
			((TransitionOperation)validTransition.accept(vis)).fire();
		}
	}
}
