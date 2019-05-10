package interpreter.visitor.operation.boa.impl;

import interpreter.boa.visitor.boa.Ctx;
import interpreter.visitor.VisitorInterface;
import interpreter.visitor.operation.boa.CtxOperation;

public class CtxOperationImpl implements CtxOperation {
	private final Ctx it;

	private final VisitorInterface vis;

	public CtxOperationImpl(Ctx it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
