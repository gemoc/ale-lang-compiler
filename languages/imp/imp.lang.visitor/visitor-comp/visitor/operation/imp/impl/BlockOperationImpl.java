package visitor.operation.imp.impl;

import imp.visitor.imp.Block;
import imp.visitor.imp.Stmt;
import imp.visitor.imp.Store;
import visitor.VisitorInterface;
import visitor.operation.imp.BlockOperation;
import visitor.operation.imp.StmtOperation;

public class BlockOperationImpl extends StmtOperationImpl implements BlockOperation {
	private final Block it;

	private final VisitorInterface vis;

	public BlockOperationImpl(Block it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}

	public Store execute(Store s) {
		Store result;
		result = ((Store) (s));
		for(Stmt e: this.it.getStmts()) {
			result = ((Store) (((StmtOperation)e.accept(vis)).execute((Store) (result))));
		}
		return result;
	}
}
