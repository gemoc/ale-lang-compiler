package visitor.operation.imp.impl;

import imp.visitor.imp.BoolValue;
import visitor.VisitorInterface;
import visitor.operation.imp.BoolValueOperation;

public class BoolValueOperationImpl extends ValueOperationImpl implements BoolValueOperation {
	private final BoolValue it;

	private final VisitorInterface vis;

	public BoolValueOperationImpl(BoolValue it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}
}
