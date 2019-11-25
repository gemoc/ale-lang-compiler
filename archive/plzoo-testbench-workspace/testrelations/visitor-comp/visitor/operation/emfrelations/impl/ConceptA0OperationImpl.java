package visitor.operation.emfrelations.impl;

import emfrelations.visitor.emfrelations.ConceptA0;
import visitor.VisitorInterface;
import visitor.operation.emfrelations.ConceptA0Operation;

public class ConceptA0OperationImpl implements ConceptA0Operation {
	private final ConceptA0 it;

	private final VisitorInterface vis;

	public ConceptA0OperationImpl(ConceptA0 it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
