package visitor.operation.factorydeclorder.impl;

import factorydeclorder.visitor.factorydeclorder.D;
import visitor.VisitorInterface;
import visitor.operation.factorydeclorder.DOperation;

public class DOperationImpl implements DOperation {
	private final D it;

	private final VisitorInterface vis;

	public DOperationImpl(D it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
