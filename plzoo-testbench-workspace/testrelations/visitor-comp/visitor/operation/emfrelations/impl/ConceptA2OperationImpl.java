package visitor.operation.emfrelations.impl;

import emfrelations.visitor.emfrelations.ConceptA2;
import visitor.VisitorInterface;
import visitor.operation.emfrelations.ConceptA2Operation;

public class ConceptA2OperationImpl implements ConceptA2Operation {
	private final ConceptA2 it;

	private final VisitorInterface vis;

	public ConceptA2OperationImpl(ConceptA2 it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
