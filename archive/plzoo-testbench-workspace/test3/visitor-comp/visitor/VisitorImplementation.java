package visitor;

import test1.visitor.test1.ConceptA;
import test1.visitor.test1.ConceptB;
import test1.visitor.test1.ConceptC;
import visitor.operation.test1.ConceptAOperation;
import visitor.operation.test1.ConceptBOperation;
import visitor.operation.test1.ConceptCOperation;
import visitor.operation.test1.impl.ConceptAOperationImpl;
import visitor.operation.test1.impl.ConceptBOperationImpl;
import visitor.operation.test1.impl.ConceptCOperationImpl;

public class VisitorImplementation implements VisitorInterface {
	public ConceptAOperation visittest1__ConceptA(ConceptA it) {
		return new ConceptAOperationImpl(it, this);
	}

	public ConceptBOperation visittest1__ConceptB(ConceptB it) {
		return new ConceptBOperationImpl(it, this);
	}

	public ConceptCOperation visittest1__ConceptC(ConceptC it) {
		return new ConceptCOperationImpl(it, this);
	}
}
