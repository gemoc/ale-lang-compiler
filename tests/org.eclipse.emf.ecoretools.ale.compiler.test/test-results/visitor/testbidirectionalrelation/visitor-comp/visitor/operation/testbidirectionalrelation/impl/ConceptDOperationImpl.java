package visitor.operation.testbidirectionalrelation.impl;

import testbidirectionalrelation.visitor.testbidirectionalrelation.ConceptD;
import visitor.VisitorInterface;
import visitor.operation.testbidirectionalrelation.ConceptDOperation;

public class ConceptDOperationImpl implements ConceptDOperation {
	private final ConceptD it;

	private final VisitorInterface vis;

	public ConceptDOperationImpl(ConceptD it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
