package test.impl.operation.impl;

import emapvselistentry.NewEClass1;
import emapvselistentry.revisitor.EmapvselistentryRevisitor;
import test.impl.operation.NewEClass1Op;

public class NewEClass1OpImpl implements NewEClass1Op {
  private EmapvselistentryRevisitor<NewEClass1Op> rev;

  private NewEClass1 obj;

  public NewEClass1OpImpl(NewEClass1 obj, EmapvselistentryRevisitor<NewEClass1Op> rev) {
    this.obj = obj;
    this.rev = rev;
  }
}
