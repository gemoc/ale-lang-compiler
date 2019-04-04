package visitor.operation.testbidirectionalrelation.impl;

import testbidirectionalrelation.visitor.testbidirectionalrelation.ConceptC;
import visitor.VisitorInterface;
import visitor.operation.testbidirectionalrelation.ConceptCOperation;

public class ConceptCOperationImpl implements ConceptCOperation {
	private final ConceptC it;

	private final VisitorInterface vis;

	public ConceptCOperationImpl(ConceptC it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
