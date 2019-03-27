package visitor;

import autocast.visitor.autocast.ConceptA;
import autocast.visitor.autocast.ConceptB;
import autocast.visitor.autocast.ConceptC;
import visitor.operation.autocast.ConceptAOperation;
import visitor.operation.autocast.ConceptBOperation;
import visitor.operation.autocast.ConceptCOperation;
import visitor.operation.autocast.impl.ConceptAOperationImpl;
import visitor.operation.autocast.impl.ConceptBOperationImpl;
import visitor.operation.autocast.impl.ConceptCOperationImpl;

public class VisitorImplementation implements VisitorInterface {
	public ConceptAOperation visitautocast__ConceptA(ConceptA it) {
		return new ConceptAOperationImpl(it, this);
	}

	public ConceptBOperation visitautocast__ConceptB(ConceptB it) {
		return new ConceptBOperationImpl(it, this);
	}

	public ConceptCOperation visitautocast__ConceptC(ConceptC it) {
		return new ConceptCOperationImpl(it, this);
	}
}
