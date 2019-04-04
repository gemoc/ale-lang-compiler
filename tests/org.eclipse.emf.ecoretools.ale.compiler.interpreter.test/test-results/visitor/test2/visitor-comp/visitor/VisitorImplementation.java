package visitor;

import test1.visitor.test1.ConceptA;
import test1.visitor.test1.ConceptB;
import visitor.operation.test1.ConceptAOperation;
import visitor.operation.test1.ConceptBOperation;
import visitor.operation.test1.impl.ConceptAOperationImpl;
import visitor.operation.test1.impl.ConceptBOperationImpl;

public class VisitorImplementation implements VisitorInterface {
	public ConceptAOperation visittest1__ConceptA(ConceptA it) {
		return new ConceptAOperationImpl(it, this);
	}

	public ConceptBOperation visittest1__ConceptB(ConceptB it) {
		return new ConceptBOperationImpl(it, this);
	}
}
