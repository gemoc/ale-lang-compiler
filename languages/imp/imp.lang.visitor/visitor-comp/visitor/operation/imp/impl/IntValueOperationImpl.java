package visitor.operation.imp.impl;

import imp.visitor.imp.IntValue;
import visitor.VisitorInterface;
import visitor.operation.imp.IntValueOperation;

public class IntValueOperationImpl extends ValueOperationImpl implements IntValueOperation {
	private final IntValue it;

	private final VisitorInterface vis;

	public IntValueOperationImpl(IntValue it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}
}
