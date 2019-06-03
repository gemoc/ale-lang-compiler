package visitor.operation.boa.impl;

import boa.visitor.boa.ArithOp;
import visitor.VisitorInterface;
import visitor.operation.boa.ArithOpOperation;

public abstract class ArithOpOperationImpl extends ExprOperationImpl implements ArithOpOperation {
	private final ArithOp it;

	private final VisitorInterface vis;

	public ArithOpOperationImpl(ArithOp it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}
}
