package visitor.operation.emapvselistentry.impl;

import emapvselistentry.visitor.emapvselistentry.NewEClass4;
import visitor.VisitorInterface;
import visitor.operation.emapvselistentry.NewEClass4Operation;

public class NewEClass4OperationImpl implements NewEClass4Operation {
	private final NewEClass4 it;

	private final VisitorInterface vis;

	public NewEClass4OperationImpl(NewEClass4 it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}
}
