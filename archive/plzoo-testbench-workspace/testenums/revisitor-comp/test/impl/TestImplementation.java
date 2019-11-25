package test.impl;

import test.impl.operation.RootOp;
import test.impl.operation.impl.RootOpImpl;
import testenums.Root;
import testenums.revisitor.TestenumsRevisitor;

public interface TestImplementation extends TestenumsRevisitor<RootOp> {
	default RootOp testenums__Root(Root it) {
		return new RootOpImpl(it, this);
	}
}
