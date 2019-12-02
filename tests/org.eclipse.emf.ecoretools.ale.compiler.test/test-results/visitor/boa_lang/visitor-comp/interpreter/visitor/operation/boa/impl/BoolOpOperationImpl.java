package interpreter.visitor.operation.boa.impl;

import interpreter.boa.visitor.boa.BoolOp;
import interpreter.visitor.VisitorInterface;
import interpreter.visitor.operation.boa.BoolOpOperation;

public abstract class BoolOpOperationImpl extends ExprOperationImpl implements BoolOpOperation {
	private final BoolOp it;

	private final VisitorInterface vis;

	public BoolOpOperationImpl(BoolOp it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}
}
