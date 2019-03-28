package visitor.operation.testoperationbody;

import testoperationbody.EnumA;

public interface ChildAOperation extends ParentOperation {
	void overriden();

	EnumA onlyA();
}
