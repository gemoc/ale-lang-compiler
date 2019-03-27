package test.impl;

import test.impl.operation.ConceptAOp;
import test.impl.operation.impl.ConceptAOpImpl;
import test1.ConceptA;
import test1.revisitor.Test1Revisitor;

public interface TestImplementation extends Test1Revisitor<ConceptAOp> {
	default ConceptAOp test1__ConceptA(ConceptA it) {
		return new ConceptAOpImpl(it, this);
	}
}
