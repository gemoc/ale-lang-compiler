package visitor.operation.emapvselistentry.impl;

import emapvselistentry.visitor.emapvselistentry.NewEClass5;
import visitor.VisitorInterface;
import visitor.operation.emapvselistentry.NewEClass5Operation;

public class NewEClass5OperationImpl implements NewEClass5Operation {
	private final NewEClass5 it;

	private final VisitorInterface vis;

	public NewEClass5OperationImpl(NewEClass5 it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
