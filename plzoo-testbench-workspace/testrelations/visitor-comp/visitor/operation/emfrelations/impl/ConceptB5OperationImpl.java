package visitor.operation.emfrelations.impl;

import emfrelations.visitor.emfrelations.ConceptB5;
import visitor.VisitorInterface;
import visitor.operation.emfrelations.ConceptB5Operation;

public class ConceptB5OperationImpl implements ConceptB5Operation {
	private final ConceptB5 it;

	private final VisitorInterface vis;

	public ConceptB5OperationImpl(ConceptB5 it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
