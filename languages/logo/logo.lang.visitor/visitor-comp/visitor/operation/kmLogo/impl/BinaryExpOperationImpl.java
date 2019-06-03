package visitor.operation.kmLogo.impl;

import kmLogo.visitor.kmLogo.BinaryExp;
import visitor.VisitorInterface;
import visitor.operation.kmLogo.BinaryExpOperation;

public abstract class BinaryExpOperationImpl extends ExpressionOperationImpl implements BinaryExpOperation {
	private final BinaryExp it;

	private final VisitorInterface vis;

	public BinaryExpOperationImpl(BinaryExp it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}
}
