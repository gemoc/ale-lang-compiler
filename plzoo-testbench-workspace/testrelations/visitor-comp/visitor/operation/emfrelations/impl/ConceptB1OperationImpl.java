package visitor.operation.emfrelations.impl;

import emfrelations.visitor.emfrelations.ConceptB1;
import visitor.VisitorInterface;
import visitor.operation.emfrelations.ConceptB1Operation;

public class ConceptB1OperationImpl implements ConceptB1Operation {
	private final ConceptB1 it;

	private final VisitorInterface vis;

	public ConceptB1OperationImpl(ConceptB1 it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
