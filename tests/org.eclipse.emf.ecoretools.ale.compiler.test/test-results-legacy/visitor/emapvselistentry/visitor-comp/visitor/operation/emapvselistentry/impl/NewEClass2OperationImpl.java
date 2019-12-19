package visitor.operation.emapvselistentry.impl;

import emapvselistentry.visitor.emapvselistentry.NewEClass2;
import visitor.VisitorInterface;
import visitor.operation.emapvselistentry.NewEClass2Operation;

public class NewEClass2OperationImpl implements NewEClass2Operation {
	private final NewEClass2 it;

	private final VisitorInterface vis;

	public NewEClass2OperationImpl(NewEClass2 it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
