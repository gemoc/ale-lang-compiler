package test.impl;

import test.impl.operation.ConceptA;
import test.impl.operation.ConceptB;
import test.impl.operation.impl.ConceptAImpl;
import test.impl.operation.impl.ConceptBImpl;
import test1.revisitor.Test1Revisitor;

public interface TestImplementation extends Test1Revisitor<ConceptA, ConceptB> {
	default ConceptA test1__ConceptA(test1.ConceptA it) {
		return new ConceptAImpl(it, this);
	}

	default ConceptB test1__ConceptB(test1.ConceptB it) {
		return new ConceptBImpl(it, this);
	}
}
