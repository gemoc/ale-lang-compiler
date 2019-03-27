package visitor.operation.emfrelations.impl;

import emfrelations.visitor.emfrelations.ConceptA4;
import visitor.VisitorInterface;
import visitor.operation.emfrelations.ConceptA4Operation;

public class ConceptA4OperationImpl implements ConceptA4Operation {
	private final ConceptA4 it;

	private final VisitorInterface vis;

	public ConceptA4OperationImpl(ConceptA4 it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
