package visitor.operation.emfrelations.impl;

import emfrelations.visitor.emfrelations.ConceptA3;
import visitor.VisitorInterface;
import visitor.operation.emfrelations.ConceptA3Operation;

public class ConceptA3OperationImpl implements ConceptA3Operation {
	private final ConceptA3 it;

	private final VisitorInterface vis;

	public ConceptA3OperationImpl(ConceptA3 it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
