package visitor.operation.emapvselistentry.impl;

import emapvselistentry.visitor.emapvselistentry.NewEClass1;
import visitor.VisitorInterface;
import visitor.operation.emapvselistentry.NewEClass1Operation;

public class NewEClass1OperationImpl implements NewEClass1Operation {
	private final NewEClass1 it;

	private final VisitorInterface vis;

	public NewEClass1OperationImpl(NewEClass1 it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
