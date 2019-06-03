package visitor.operation.boa.impl;

import boa.visitor.boa.BoolOp;
import visitor.VisitorInterface;
import visitor.operation.boa.BoolOpOperation;

public abstract class BoolOpOperationImpl extends ExprOperationImpl implements BoolOpOperation {
	private final BoolOp it;

	private final VisitorInterface vis;

	public BoolOpOperationImpl(BoolOp it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}
}
