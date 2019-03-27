package test.impl;

import test.impl.operation.ConceptA;
import test.impl.operation.ConceptB;
import test.impl.operation.ConceptC;
import test.impl.operation.ConceptD;
import test.impl.operation.ConceptE;
import test.impl.operation.ConceptF;
import test.impl.operation.ConceptG;
import test.impl.operation.impl.ConceptAImpl;
import test.impl.operation.impl.ConceptBImpl;
import test.impl.operation.impl.ConceptCImpl;
import test.impl.operation.impl.ConceptDImpl;
import test.impl.operation.impl.ConceptEImpl;
import test.impl.operation.impl.ConceptFImpl;
import test.impl.operation.impl.ConceptGImpl;
import testbidirectionalrelation.revisitor.TestbidirectionalrelationRevisitor;

public interface TestImplementation extends TestbidirectionalrelationRevisitor<ConceptA, ConceptB, ConceptC, ConceptD, ConceptE, ConceptF, ConceptG> {
	default ConceptA testbidirectionalrelation__ConceptA(testbidirectionalrelation.ConceptA it) {
		return new ConceptAImpl(it, this);
	}

	default ConceptB testbidirectionalrelation__ConceptB(testbidirectionalrelation.ConceptB it) {
		return new ConceptBImpl(it, this);
	}

	default ConceptC testbidirectionalrelation__ConceptC(testbidirectionalrelation.ConceptC it) {
		return new ConceptCImpl(it, this);
	}

	default ConceptD testbidirectionalrelation__ConceptD(testbidirectionalrelation.ConceptD it) {
		return new ConceptDImpl(it, this);
	}

	default ConceptE testbidirectionalrelation__ConceptE(testbidirectionalrelation.ConceptE it) {
		return new ConceptEImpl(it, this);
	}

	default ConceptF testbidirectionalrelation__ConceptF(testbidirectionalrelation.ConceptF it) {
		return new ConceptFImpl(it, this);
	}

	default ConceptG testbidirectionalrelation__ConceptG(testbidirectionalrelation.ConceptG it) {
		return new ConceptGImpl(it, this);
	}
}
