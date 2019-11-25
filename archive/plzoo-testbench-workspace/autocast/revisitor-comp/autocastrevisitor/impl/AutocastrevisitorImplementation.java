package autocastrevisitor.impl;

import autocast.ConceptA;
import autocast.ConceptB;
import autocast.ConceptC;
import autocast.revisitor.AutocastRevisitor;
import autocastrevisitor.impl.operation.ConceptAOp;
import autocastrevisitor.impl.operation.ConceptBOp;
import autocastrevisitor.impl.operation.ConceptCOp;
import autocastrevisitor.impl.operation.impl.ConceptAOpImpl;
import autocastrevisitor.impl.operation.impl.ConceptBOpImpl;
import autocastrevisitor.impl.operation.impl.ConceptCOpImpl;

public interface AutocastrevisitorImplementation extends AutocastRevisitor<ConceptAOp, ConceptBOp, ConceptCOp> {
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
