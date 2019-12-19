package visitor.operation.testbidirectionalrelation.impl;

import testbidirectionalrelation.visitor.testbidirectionalrelation.ConceptG;
import visitor.VisitorInterface;
import visitor.operation.testbidirectionalrelation.ConceptGOperation;

public class ConceptGOperationImpl implements ConceptGOperation {
	private final ConceptG it;

	private final VisitorInterface vis;

	public ConceptGOperationImpl(ConceptG it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
