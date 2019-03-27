package visitor.operation.emfrelations.impl;

import emfrelations.visitor.emfrelations.ConceptB10;
import visitor.VisitorInterface;
import visitor.operation.emfrelations.ConceptB10Operation;

public class ConceptB10OperationImpl implements ConceptB10Operation {
	private final ConceptB10 it;

	private final VisitorInterface vis;

	public ConceptB10OperationImpl(ConceptB10 it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
