package visitor.operation.boa.impl;

import boa.visitor.boa.CmpOp;
import visitor.VisitorInterface;
import visitor.operation.boa.CmpOpOperation;

public abstract class CmpOpOperationImpl extends ExprOperationImpl implements CmpOpOperation {
	private final CmpOp it;

	private final VisitorInterface vis;

	public CmpOpOperationImpl(CmpOp it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}
}
