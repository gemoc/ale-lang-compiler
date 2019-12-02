package visitor;

import functioncall.visitor.functioncall.ConceptA;
import functioncall.visitor.functioncall.ConceptB;
import functioncall.visitor.functioncall.ConceptC;
import visitor.operation.functioncall.ConceptAOperation;
import visitor.operation.functioncall.ConceptBOperation;
import visitor.operation.functioncall.ConceptCOperation;
import visitor.operation.functioncall.impl.ConceptAOperationImpl;
import visitor.operation.functioncall.impl.ConceptBOperationImpl;
import visitor.operation.functioncall.impl.ConceptCOperationImpl;

public class VisitorImplementation implements VisitorInterface {
	public ConceptAOperation visitfunctioncall__ConceptA(ConceptA it) {
		return new ConceptAOperationImpl(it, this);
	}

	public ConceptBOperation visitfunctioncall__ConceptB(ConceptB it) {
		return new ConceptBOperationImpl(it, this);
	}

	public ConceptCOperation visitfunctioncall__ConceptC(ConceptC it) {
		return new ConceptCOperationImpl(it, this);
	}
}
