package visitor;

import testoperationbody.visitor.testoperationbody.ChildA;
import testoperationbody.visitor.testoperationbody.ChildB;
import testoperationbody.visitor.testoperationbody.ConceptA;
import testoperationbody.visitor.testoperationbody.Main;
import visitor.operation.testoperationbody.ChildAOperation;
import visitor.operation.testoperationbody.ChildBOperation;
import visitor.operation.testoperationbody.ConceptAOperation;
import visitor.operation.testoperationbody.MainOperation;
import visitor.operation.testoperationbody.impl.ChildAOperationImpl;
import visitor.operation.testoperationbody.impl.ChildBOperationImpl;
import visitor.operation.testoperationbody.impl.ConceptAOperationImpl;
import visitor.operation.testoperationbody.impl.MainOperationImpl;

public class VisitorImplementation implements VisitorInterface {
	public MainOperation visittestoperationbody__Main(Main it) {
		return new MainOperationImpl(it, this);
	}

	public ConceptAOperation visittestoperationbody__ConceptA(ConceptA it) {
		return new ConceptAOperationImpl(it, this);
	}

	public ChildAOperation visittestoperationbody__ChildA(ChildA it) {
		return new ChildAOperationImpl(it, this);
	}

	public ChildBOperation visittestoperationbody__ChildB(ChildB it) {
		return new ChildBOperationImpl(it, this);
	}
}
