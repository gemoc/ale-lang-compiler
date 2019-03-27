package test.impl;

import test.impl.operation.ConceptAOp;
import test.impl.operation.ConceptBOp;
import test.impl.operation.ConceptCOp;
import test.impl.operation.ConceptDOp;
import test.impl.operation.ConceptEOp;
import test.impl.operation.ConceptFOp;
import test.impl.operation.ConceptGOp;
import test.impl.operation.impl.ConceptAOpImpl;
import test.impl.operation.impl.ConceptBOpImpl;
import test.impl.operation.impl.ConceptCOpImpl;
import test.impl.operation.impl.ConceptDOpImpl;
import test.impl.operation.impl.ConceptEOpImpl;
import test.impl.operation.impl.ConceptFOpImpl;
import test.impl.operation.impl.ConceptGOpImpl;
import testbidirectionalrelation.ConceptA;
import testbidirectionalrelation.ConceptB;
import testbidirectionalrelation.ConceptC;
import testbidirectionalrelation.ConceptD;
import testbidirectionalrelation.ConceptE;
import testbidirectionalrelation.ConceptF;
import testbidirectionalrelation.ConceptG;
import testbidirectionalrelation.revisitor.TestbidirectionalrelationRevisitor;

public interface TestImplementation extends TestbidirectionalrelationRevisitor<ConceptAOp, ConceptBOp, ConceptCOp, ConceptDOp, ConceptEOp, ConceptFOp, ConceptGOp> {
	default ConceptAOp testbidirectionalrelation__ConceptA(ConceptA it) {
		return new ConceptAOpImpl(it, this);
	}

	default ConceptBOp testbidirectionalrelation__ConceptB(ConceptB it) {
		return new ConceptBOpImpl(it, this);
	}

	default ConceptCOp testbidirectionalrelation__ConceptC(ConceptC it) {
		return new ConceptCOpImpl(it, this);
	}

	default ConceptDOp testbidirectionalrelation__ConceptD(ConceptD it) {
		return new ConceptDOpImpl(it, this);
	}

	default ConceptEOp testbidirectionalrelation__ConceptE(ConceptE it) {
		return new ConceptEOpImpl(it, this);
	}

	default ConceptFOp testbidirectionalrelation__ConceptF(ConceptF it) {
		return new ConceptFOpImpl(it, this);
	}

	default ConceptGOp testbidirectionalrelation__ConceptG(ConceptG it) {
		return new ConceptGOpImpl(it, this);
	}
}
