package visitor.operation.factorydeclorder.impl;

import factorydeclorder.visitor.factorydeclorder.B;
import visitor.VisitorInterface;
import visitor.operation.factorydeclorder.BOperation;

public class BOperationImpl implements BOperation {
	private final B it;

	private final VisitorInterface vis;

	public BOperationImpl(B it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
