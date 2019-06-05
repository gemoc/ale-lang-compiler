package visitor.operation.imp.impl;

import imp.visitor.imp.Store;
import visitor.VisitorInterface;
import visitor.operation.imp.StoreOperation;

public class StoreOperationImpl implements StoreOperation {
	private final Store it;

	private final VisitorInterface vis;

	public StoreOperationImpl(Store it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
