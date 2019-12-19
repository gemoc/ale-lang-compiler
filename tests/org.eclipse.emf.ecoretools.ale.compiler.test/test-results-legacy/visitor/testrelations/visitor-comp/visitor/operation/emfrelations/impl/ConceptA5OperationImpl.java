package visitor.operation.emfrelations.impl;

import emfrelations.visitor.emfrelations.ConceptA5;
import visitor.VisitorInterface;
import visitor.operation.emfrelations.ConceptA5Operation;

public class ConceptA5OperationImpl implements ConceptA5Operation {
	private final ConceptA5 it;

	private final VisitorInterface vis;

	public ConceptA5OperationImpl(ConceptA5 it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
