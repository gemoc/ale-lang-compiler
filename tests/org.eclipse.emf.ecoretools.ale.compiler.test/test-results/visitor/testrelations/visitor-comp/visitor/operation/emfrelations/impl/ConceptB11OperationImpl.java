package visitor.operation.emfrelations.impl;

import emfrelations.visitor.emfrelations.ConceptB11;
import visitor.VisitorInterface;
import visitor.operation.emfrelations.ConceptB11Operation;

public class ConceptB11OperationImpl implements ConceptB11Operation {
	private final ConceptB11 it;

	private final VisitorInterface vis;

	public ConceptB11OperationImpl(ConceptB11 it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
