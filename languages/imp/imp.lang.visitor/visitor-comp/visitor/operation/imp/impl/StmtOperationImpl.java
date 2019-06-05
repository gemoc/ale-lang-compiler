package visitor.operation.imp.impl;

import imp.visitor.imp.Stmt;
import imp.visitor.imp.Store;
import visitor.VisitorInterface;
import visitor.operation.imp.StmtOperation;

public abstract class StmtOperationImpl implements StmtOperation {
	private final Stmt it;

	private final VisitorInterface vis;

	public StmtOperationImpl(Stmt it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}

	public Store execute(Store s) {
		Store result;
		result = ((Store) (s));
		return result;
	}
}
