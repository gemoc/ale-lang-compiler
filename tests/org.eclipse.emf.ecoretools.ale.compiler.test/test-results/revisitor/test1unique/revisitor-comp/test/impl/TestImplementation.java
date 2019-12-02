package test.impl;

import test.impl.operation.ConceptAOp;
import test.impl.operation.impl.ConceptAOpImpl;
import test1unique.ConceptA;
import test1unique.revisitor.Test1uniqueRevisitor;

public interface TestImplementation extends Test1uniqueRevisitor<ConceptAOp> {
	default ConceptAOp test1unique__ConceptA(ConceptA it) {
		return new ConceptAOpImpl(it, this);
	}
}
