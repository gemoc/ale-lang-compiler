package visitor.operation.autocast.impl;

import autocast.visitor.autocast.ConceptB;
import visitor.VisitorInterface;
import visitor.operation.autocast.ConceptBOperation;

public class ConceptBOperationImpl extends ConceptAOperationImpl implements ConceptBOperation {
	private final ConceptB it;

	private final VisitorInterface vis;

	public ConceptBOperationImpl(ConceptB it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}

	public void callB() {
	}
}
