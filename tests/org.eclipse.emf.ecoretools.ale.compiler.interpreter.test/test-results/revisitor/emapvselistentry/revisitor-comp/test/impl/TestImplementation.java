package test.impl;

import emapvselistentry.NewEClass1;
import emapvselistentry.revisitor.EmapvselistentryRevisitor;
import test.impl.operation.NewEClass1Op;
import test.impl.operation.impl.NewEClass1OpImpl;

public interface TestImplementation extends EmapvselistentryRevisitor<NewEClass1Op> {
	default NewEClass1Op emapvselistentry__NewEClass1(NewEClass1 it) {
		return new NewEClass1OpImpl(it, this);
	}
}
