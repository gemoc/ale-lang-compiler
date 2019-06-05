package visitor.operation.imp.impl;

import imp.visitor.imp.Skip;
import imp.visitor.imp.Store;
import visitor.VisitorInterface;
import visitor.operation.imp.SkipOperation;

public class SkipOperationImpl extends StmtOperationImpl implements SkipOperation {
	private final Skip it;

	private final VisitorInterface vis;

	public SkipOperationImpl(Skip it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}

	public Store execute(Store s) {
		Store result;
		result = ((Store) (s));
		return result;
	}
}
