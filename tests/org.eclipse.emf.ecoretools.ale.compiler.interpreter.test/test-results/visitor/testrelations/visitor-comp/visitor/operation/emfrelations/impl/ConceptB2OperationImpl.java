package visitor.operation.emfrelations.impl;

import emfrelations.visitor.emfrelations.ConceptB2;
import visitor.VisitorInterface;
import visitor.operation.emfrelations.ConceptB2Operation;

public class ConceptB2OperationImpl implements ConceptB2Operation {
	private final ConceptB2 it;

	private final VisitorInterface vis;

	public ConceptB2OperationImpl(ConceptB2 it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
