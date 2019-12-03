package test.impl;

import test.impl.operation.EAccOp;
import test.impl.operation.impl.EAccOpImpl;
import testaccessors.EAcc;
import testaccessors.revisitor.TestaccessorsRevisitor;

public interface TestImplementation extends TestaccessorsRevisitor<EAccOp> {
	default EAccOp testaccessors__EAcc(EAcc it) {
		return new EAccOpImpl(it, this);
	}
}
