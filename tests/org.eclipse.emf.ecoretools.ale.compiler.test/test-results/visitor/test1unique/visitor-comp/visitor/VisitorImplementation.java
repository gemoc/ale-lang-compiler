package visitor;

import test1unique.visitor.test1unique.ConceptA;
import visitor.operation.test1unique.ConceptAOperation;
import visitor.operation.test1unique.impl.ConceptAOperationImpl;

public class VisitorImplementation implements VisitorInterface {
	public ConceptAOperation visittest1unique__ConceptA(ConceptA it) {
		return new ConceptAOperationImpl(it, this);
	}
}
