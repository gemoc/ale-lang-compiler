package test.impl;

import test.impl.operation.ConceptAOp;
import test.impl.operation.ConceptBOp;
import test.impl.operation.impl.ConceptAOpImpl;
import test.impl.operation.impl.ConceptBOpImpl;
import test1.ConceptA;
import test1.ConceptB;
import test1.revisitor.Test1Revisitor;

public interface TestImplementation extends Test1Revisitor<ConceptAOp, ConceptBOp> {
	default ConceptAOp test1__ConceptA(ConceptA it) {
		return new ConceptAOpImpl(it, this);
	}

	default ConceptBOp test1__ConceptB(ConceptB it) {
		return new ConceptBOpImpl(it, this);
	}
}
