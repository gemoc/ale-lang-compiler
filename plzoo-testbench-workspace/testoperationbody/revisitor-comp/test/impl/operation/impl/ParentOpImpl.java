package test.impl.operation.impl;

import test.impl.operation.ChildAOp;
import test.impl.operation.ChildBOp;
import test.impl.operation.ConceptAOp;
import test.impl.operation.MainOp;
import test.impl.operation.ParentOp;
import testoperationbody.Parent;
import testoperationbody.revisitor.TestoperationbodyRevisitor;

public class ParentOpImpl implements ParentOp {
  private TestoperationbodyRevisitor<ChildAOp, ChildBOp, ConceptAOp, MainOp, ParentOp> rev;

  private Parent obj;

  public ParentOpImpl(Parent obj,
      TestoperationbodyRevisitor<ChildAOp, ChildBOp, ConceptAOp, MainOp, ParentOp> rev) {
    this.obj = obj;
    this.rev = rev;
  }

  public void notOverriden() {
  }

  public void overriden() {
  }
}
