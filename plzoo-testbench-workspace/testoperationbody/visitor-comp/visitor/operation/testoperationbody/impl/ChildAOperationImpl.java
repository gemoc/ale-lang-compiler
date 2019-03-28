package visitor.operation.testoperationbody.impl;

import testoperationbody.EnumA;
import testoperationbody.visitor.testoperationbody.ChildA;
import visitor.VisitorInterface;
import visitor.operation.testoperationbody.ChildAOperation;

public class ChildAOperationImpl extends ParentOperationImpl implements ChildAOperation {
	private final ChildA it;

	private final VisitorInterface vis;

	public ChildAOperationImpl(ChildA it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}

	public void overriden() {
	}

	public EnumA onlyA() {
		EnumA result;
		result = this.it.getValue();
		return result;
	}
}
