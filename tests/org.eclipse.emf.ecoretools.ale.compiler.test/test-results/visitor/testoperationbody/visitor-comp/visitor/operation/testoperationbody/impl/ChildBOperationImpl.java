package visitor.operation.testoperationbody.impl;

import testoperationbody.visitor.testoperationbody.ChildB;
import visitor.VisitorInterface;
import visitor.operation.testoperationbody.ChildBOperation;

public class ChildBOperationImpl extends ParentOperationImpl implements ChildBOperation {
	private final ChildB it;

	private final VisitorInterface vis;

	public ChildBOperationImpl(ChildB it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}

	public void overriden() {
	}
}
