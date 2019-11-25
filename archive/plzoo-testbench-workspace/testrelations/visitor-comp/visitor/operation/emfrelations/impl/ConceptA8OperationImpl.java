package visitor.operation.emfrelations.impl;

import emfrelations.visitor.emfrelations.ConceptA8;
import visitor.VisitorInterface;
import visitor.operation.emfrelations.ConceptA8Operation;

public class ConceptA8OperationImpl implements ConceptA8Operation {
	private final ConceptA8 it;

	private final VisitorInterface vis;

	public ConceptA8OperationImpl(ConceptA8 it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
