package test.impl;

import test.impl.operation.ConceptAOp;
import test.impl.operation.ConceptBOp;
import test.impl.operation.ConceptCOp;
import test.impl.operation.impl.ConceptAOpImpl;
import test.impl.operation.impl.ConceptBOpImpl;
import test.impl.operation.impl.ConceptCOpImpl;
import x.y.z.functioncall.ConceptA;
import x.y.z.functioncall.ConceptB;
import x.y.z.functioncall.ConceptC;
import x.y.z.revisitor.FunctioncallRevisitor;

public interface TestImplementation extends FunctioncallRevisitor<ConceptAOp, ConceptBOp, ConceptCOp> {
	default ConceptAOp functioncall__ConceptA(ConceptA it) {
		return new ConceptAOpImpl(it, this);
	}

	default ConceptBOp functioncall__ConceptB(ConceptB it) {
		return new ConceptBOpImpl(it, this);
	}

	default ConceptCOp functioncall__ConceptC(ConceptC it) {
		return new ConceptCOpImpl(it, this);
	}
}
