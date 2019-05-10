package interpreter.visitor.operation.boa.impl;

import interpreter.boa.visitor.boa.ArithOp;
import interpreter.visitor.VisitorInterface;
import interpreter.visitor.operation.boa.ArithOpOperation;

public abstract class ArithOpOperationImpl extends ExprOperationImpl implements ArithOpOperation {
	private final ArithOp it;

	private final VisitorInterface vis;

	public ArithOpOperationImpl(ArithOp it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}
}
