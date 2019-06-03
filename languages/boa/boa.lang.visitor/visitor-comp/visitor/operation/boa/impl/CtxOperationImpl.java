package visitor.operation.boa.impl;

import boa.visitor.boa.Ctx;
import visitor.VisitorInterface;
import visitor.operation.boa.CtxOperation;

public class CtxOperationImpl implements CtxOperation {
	private final Ctx it;

	private final VisitorInterface vis;

	public CtxOperationImpl(Ctx it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
