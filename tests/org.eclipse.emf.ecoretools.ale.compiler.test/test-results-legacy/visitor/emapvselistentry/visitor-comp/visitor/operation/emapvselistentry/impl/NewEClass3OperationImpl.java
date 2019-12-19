package visitor.operation.emapvselistentry.impl;

import emapvselistentry.visitor.emapvselistentry.NewEClass3;
import visitor.VisitorInterface;
import visitor.operation.emapvselistentry.NewEClass3Operation;

public class NewEClass3OperationImpl implements NewEClass3Operation {
	private final NewEClass3 it;

	private final VisitorInterface vis;

	public NewEClass3OperationImpl(NewEClass3 it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
