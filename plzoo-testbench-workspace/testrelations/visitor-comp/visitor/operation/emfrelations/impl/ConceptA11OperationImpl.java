package visitor.operation.emfrelations.impl;

import emfrelations.visitor.emfrelations.ConceptA11;
import visitor.VisitorInterface;
import visitor.operation.emfrelations.ConceptA11Operation;

public class ConceptA11OperationImpl implements ConceptA11Operation {
	private final ConceptA11 it;

	private final VisitorInterface vis;

	public ConceptA11OperationImpl(ConceptA11 it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
