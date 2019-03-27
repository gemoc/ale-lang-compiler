package visitor.operation.emfrelations.impl;

import emfrelations.visitor.emfrelations.ConceptB3;
import visitor.VisitorInterface;
import visitor.operation.emfrelations.ConceptB3Operation;

public class ConceptB3OperationImpl implements ConceptB3Operation {
	private final ConceptB3 it;

	private final VisitorInterface vis;

	public ConceptB3OperationImpl(ConceptB3 it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
