package visitor;

import testbidirectionalrelation.visitor.testbidirectionalrelation.ConceptA;
import testbidirectionalrelation.visitor.testbidirectionalrelation.ConceptB;
import testbidirectionalrelation.visitor.testbidirectionalrelation.ConceptC;
import testbidirectionalrelation.visitor.testbidirectionalrelation.ConceptD;
import testbidirectionalrelation.visitor.testbidirectionalrelation.ConceptE;
import testbidirectionalrelation.visitor.testbidirectionalrelation.ConceptF;
import testbidirectionalrelation.visitor.testbidirectionalrelation.ConceptG;
import visitor.operation.testbidirectionalrelation.ConceptAOperation;
import visitor.operation.testbidirectionalrelation.ConceptBOperation;
import visitor.operation.testbidirectionalrelation.ConceptCOperation;
import visitor.operation.testbidirectionalrelation.ConceptDOperation;
import visitor.operation.testbidirectionalrelation.ConceptEOperation;
import visitor.operation.testbidirectionalrelation.ConceptFOperation;
import visitor.operation.testbidirectionalrelation.ConceptGOperation;
import visitor.operation.testbidirectionalrelation.impl.ConceptAOperationImpl;
import visitor.operation.testbidirectionalrelation.impl.ConceptBOperationImpl;
import visitor.operation.testbidirectionalrelation.impl.ConceptCOperationImpl;
import visitor.operation.testbidirectionalrelation.impl.ConceptDOperationImpl;
import visitor.operation.testbidirectionalrelation.impl.ConceptEOperationImpl;
import visitor.operation.testbidirectionalrelation.impl.ConceptFOperationImpl;
import visitor.operation.testbidirectionalrelation.impl.ConceptGOperationImpl;

public class VisitorImplementation implements VisitorInterface {
	public ConceptAOperation visittestbidirectionalrelation__ConceptA(ConceptA it) {
		return new ConceptAOperationImpl(it, this);
	}

	public ConceptBOperation visittestbidirectionalrelation__ConceptB(ConceptB it) {
		return new ConceptBOperationImpl(it, this);
	}

	public ConceptCOperation visittestbidirectionalrelation__ConceptC(ConceptC it) {
		return new ConceptCOperationImpl(it, this);
	}

	public ConceptDOperation visittestbidirectionalrelation__ConceptD(ConceptD it) {
		return new ConceptDOperationImpl(it, this);
	}

	public ConceptEOperation visittestbidirectionalrelation__ConceptE(ConceptE it) {
		return new ConceptEOperationImpl(it, this);
	}

	public ConceptFOperation visittestbidirectionalrelation__ConceptF(ConceptF it) {
		return new ConceptFOperationImpl(it, this);
	}

	public ConceptGOperation visittestbidirectionalrelation__ConceptG(ConceptG it) {
		return new ConceptGOperationImpl(it, this);
	}
}
