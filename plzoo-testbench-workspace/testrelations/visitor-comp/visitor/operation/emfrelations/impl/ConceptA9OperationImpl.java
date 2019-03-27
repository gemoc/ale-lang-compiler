package visitor.operation.emfrelations.impl;

import emfrelations.visitor.emfrelations.ConceptA9;
import visitor.VisitorInterface;
import visitor.operation.emfrelations.ConceptA9Operation;

public class ConceptA9OperationImpl implements ConceptA9Operation {
	private final ConceptA9 it;

	private final VisitorInterface vis;

	public ConceptA9OperationImpl(ConceptA9 it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
