package visitor.visitor.operation.petrinet.impl;

import org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService;
import visitor.petrinet.visitor.petrinet.Arc;
import visitor.petrinet.visitor.petrinet.Transition;
import visitor.visitor.VisitorInterface;
import visitor.visitor.operation.petrinet.ArcOperation;
import visitor.visitor.operation.petrinet.TransitionOperation;

public class TransitionOperationImpl extends NodeOperationImpl implements TransitionOperation {
	private final Transition it;

	private final VisitorInterface vis;

	public TransitionOperationImpl(Transition it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}

	public boolean canFire() {
		boolean result;
		result = !(CollectionService.isEmpty(CollectionService.select(this.it.getIncomming(), (it) -> ((ArcOperation)it.accept(vis)).canFire())));
		return result;
	}

	public boolean hasToken() {
		boolean result;
		result = false;
		return result;
	}

	public void fire() {
		for(Arc it: this.it.getIncomming()) {
			((ArcOperation)it.accept(vis)).removeToken();
		}
		for(Arc it: this.it.getOutgoing()) {
			((ArcOperation)it.accept(vis)).addToken();
		}
	}

	public void removeToken() {
	}

	public void addToken() {
	}
}
