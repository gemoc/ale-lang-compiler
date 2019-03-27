package visitor.operation.emfrelations.impl;

import emfrelations.visitor.emfrelations.ConceptB4;
import visitor.VisitorInterface;
import visitor.operation.emfrelations.ConceptB4Operation;

public class ConceptB4OperationImpl implements ConceptB4Operation {
	private final ConceptB4 it;

	private final VisitorInterface vis;

	public ConceptB4OperationImpl(ConceptB4 it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
