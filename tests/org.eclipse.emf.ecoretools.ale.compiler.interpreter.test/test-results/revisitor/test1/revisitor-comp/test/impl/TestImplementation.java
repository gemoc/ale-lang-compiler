package test.impl;

import test.impl.operation.ConceptA;
import test.impl.operation.impl.ConceptAImpl;
import test1.revisitor.Test1Revisitor;

public interface TestImplementation extends Test1Revisitor<ConceptA> {
	default ConceptA test1__ConceptA(test1.ConceptA it) {
		return new ConceptAImpl(it, this);
	}
}
