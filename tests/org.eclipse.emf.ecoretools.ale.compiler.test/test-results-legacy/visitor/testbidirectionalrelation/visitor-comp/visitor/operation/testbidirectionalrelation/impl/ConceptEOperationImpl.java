package visitor.operation.testbidirectionalrelation.impl;

import testbidirectionalrelation.visitor.testbidirectionalrelation.ConceptE;
import visitor.VisitorInterface;
import visitor.operation.testbidirectionalrelation.ConceptEOperation;

public class ConceptEOperationImpl implements ConceptEOperation {
	private final ConceptE it;

	private final VisitorInterface vis;

	public ConceptEOperationImpl(ConceptE it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
