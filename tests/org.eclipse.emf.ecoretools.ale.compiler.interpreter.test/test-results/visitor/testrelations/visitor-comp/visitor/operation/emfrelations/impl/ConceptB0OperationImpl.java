package visitor.operation.emfrelations.impl;

import emfrelations.visitor.emfrelations.ConceptB0;
import visitor.VisitorInterface;
import visitor.operation.emfrelations.ConceptB0Operation;

public class ConceptB0OperationImpl implements ConceptB0Operation {
	private final ConceptB0 it;

	private final VisitorInterface vis;

	public ConceptB0OperationImpl(ConceptB0 it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
