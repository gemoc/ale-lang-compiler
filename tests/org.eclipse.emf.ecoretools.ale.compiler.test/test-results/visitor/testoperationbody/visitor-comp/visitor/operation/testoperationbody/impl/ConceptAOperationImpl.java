package visitor.operation.testoperationbody.impl;

import testoperationbody.visitor.testoperationbody.ConceptA;
import visitor.VisitorInterface;
import visitor.operation.testoperationbody.ConceptAOperation;

public class ConceptAOperationImpl implements ConceptAOperation {
	private final ConceptA it;

	private final VisitorInterface vis;

	public ConceptAOperationImpl(ConceptA it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}

	public boolean op() {
		boolean result;
		result = false;
		return result;
	}
}
