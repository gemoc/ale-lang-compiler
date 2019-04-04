package visitor.operation.emfrelations.impl;

import emfrelations.visitor.emfrelations.ConceptB8;
import visitor.VisitorInterface;
import visitor.operation.emfrelations.ConceptB8Operation;

public class ConceptB8OperationImpl implements ConceptB8Operation {
	private final ConceptB8 it;

	private final VisitorInterface vis;

	public ConceptB8OperationImpl(ConceptB8 it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
