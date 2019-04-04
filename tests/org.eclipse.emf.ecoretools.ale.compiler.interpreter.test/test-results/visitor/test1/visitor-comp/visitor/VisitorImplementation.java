package visitor;

import test1.visitor.test1.ConceptA;
import visitor.operation.test1.ConceptAOperation;
import visitor.operation.test1.impl.ConceptAOperationImpl;

public class VisitorImplementation implements VisitorInterface {
	public ConceptAOperation visittest1__ConceptA(ConceptA it) {
		return new ConceptAOperationImpl(it, this);
	}
}
