package visitor.operation.autocast.impl;

import autocast.visitor.autocast.ConceptA;
import visitor.VisitorInterface;
import visitor.operation.autocast.ConceptAOperation;

public class ConceptAOperationImpl implements ConceptAOperation {
	private final ConceptA it;

	private final VisitorInterface vis;

	public ConceptAOperationImpl(ConceptA it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
