package visitor.operation.testbidirectionalrelation.impl;

import testbidirectionalrelation.visitor.testbidirectionalrelation.ConceptF;
import visitor.VisitorInterface;
import visitor.operation.testbidirectionalrelation.ConceptFOperation;

public class ConceptFOperationImpl implements ConceptFOperation {
	private final ConceptF it;

	private final VisitorInterface vis;

	public ConceptFOperationImpl(ConceptF it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
