package test.impl;

import autocast.ConceptA;
import autocast.ConceptB;
import autocast.ConceptC;
import autocast.revisitor.AutocastRevisitor;
import test.impl.operation.ConceptAOp;
import test.impl.operation.ConceptBOp;
import test.impl.operation.ConceptCOp;
import test.impl.operation.impl.ConceptAOpImpl;
import test.impl.operation.impl.ConceptBOpImpl;
import test.impl.operation.impl.ConceptCOpImpl;

public interface TestImplementation extends AutocastRevisitor<ConceptAOp, ConceptBOp, ConceptCOp> {
	default ConceptAOp autocast__ConceptA(ConceptA it) {
		return new ConceptAOpImpl(it, this);
	}

	default ConceptBOp autocast__ConceptB(ConceptB it) {
		return new ConceptBOpImpl(it, this);
	}

	default ConceptCOp autocast__ConceptC(ConceptC it) {
		return new ConceptCOpImpl(it, this);
	}
}
