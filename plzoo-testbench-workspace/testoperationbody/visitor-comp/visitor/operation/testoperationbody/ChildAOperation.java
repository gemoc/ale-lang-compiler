package visitor.operation.testoperationbody;

import testoperationbody.visitor.testoperationbody.EnumA;

public interface ChildAOperation extends ParentOperation {
	void overriden();

	EnumA onlyA();
}
