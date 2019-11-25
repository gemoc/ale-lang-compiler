package test.impl.operation.impl;

import test.impl.operation.RootOp;
import testenums.Root;
import testenums.revisitor.TestenumsRevisitor;

public class RootOpImpl implements RootOp {
  private TestenumsRevisitor<RootOp> rev;

  private Root obj;

  public RootOpImpl(Root obj, TestenumsRevisitor<RootOp> rev) {
    this.obj = obj;
    this.rev = rev;
  }
}
