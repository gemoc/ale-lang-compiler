package visitor.operation.emfrelations.impl;

import emfrelations.visitor.emfrelations.ConceptA10;
import visitor.VisitorInterface;
import visitor.operation.emfrelations.ConceptA10Operation;

public class ConceptA10OperationImpl implements ConceptA10Operation {
	private final ConceptA10 it;

	private final VisitorInterface vis;

	public ConceptA10OperationImpl(ConceptA10 it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
