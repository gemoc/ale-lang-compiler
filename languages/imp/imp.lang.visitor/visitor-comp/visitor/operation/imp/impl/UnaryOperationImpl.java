package visitor.operation.imp.impl;

import imp.visitor.imp.Unary;
import visitor.VisitorInterface;
import visitor.operation.imp.UnaryOperation;

public class UnaryOperationImpl extends ExprOperationImpl implements UnaryOperation {
	private final Unary it;

	private final VisitorInterface vis;

	public UnaryOperationImpl(Unary it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}
}
