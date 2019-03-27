package visitor.operation.emfrelations.impl;

import emfrelations.visitor.emfrelations.ConceptB9;
import visitor.VisitorInterface;
import visitor.operation.emfrelations.ConceptB9Operation;

public class ConceptB9OperationImpl implements ConceptB9Operation {
	private final ConceptB9 it;

	private final VisitorInterface vis;

	public ConceptB9OperationImpl(ConceptB9 it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
