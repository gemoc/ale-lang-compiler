package visitor.operation.testenums.impl;

import testenums.visitor.testenums.Root;
import visitor.VisitorInterface;
import visitor.operation.testenums.RootOperation;

public class RootOperationImpl implements RootOperation {
	private final Root it;

	private final VisitorInterface vis;

	public RootOperationImpl(Root it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
