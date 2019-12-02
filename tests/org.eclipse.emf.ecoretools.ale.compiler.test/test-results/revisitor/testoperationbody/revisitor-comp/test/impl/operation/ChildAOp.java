package test.impl.operation;

import testoperationbody.EnumA;

public interface ChildAOp extends ParentOp {
	void overriden();

	EnumA onlyA();
}
