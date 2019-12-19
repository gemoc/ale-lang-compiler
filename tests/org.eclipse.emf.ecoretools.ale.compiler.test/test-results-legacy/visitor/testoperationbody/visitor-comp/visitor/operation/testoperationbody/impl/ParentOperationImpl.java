package visitor.operation.testoperationbody.impl;

import testoperationbody.visitor.testoperationbody.Parent;
import visitor.VisitorInterface;
import visitor.operation.testoperationbody.ParentOperation;

public abstract class ParentOperationImpl implements ParentOperation {
	private final Parent it;

	private final VisitorInterface vis;

	public ParentOperationImpl(Parent it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}

	public void notOverriden() {
	}

	public void overriden() {
	}
}
