package visitor.operation.testbidirectionalrelation.impl;

import testbidirectionalrelation.visitor.testbidirectionalrelation.ConceptB;
import visitor.VisitorInterface;
import visitor.operation.testbidirectionalrelation.ConceptBOperation;

public class ConceptBOperationImpl implements ConceptBOperation {
	private final ConceptB it;

	private final VisitorInterface vis;

	public ConceptBOperationImpl(ConceptB it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
