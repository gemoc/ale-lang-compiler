package test.impl.operation.impl;

import test.impl.operation.ChildAOp;
import test.impl.operation.ChildBOp;
import test.impl.operation.ConceptAOp;
import test.impl.operation.MainOp;
import test.impl.operation.ParentOp;
import testoperationbody.ChildB;
import testoperationbody.revisitor.TestoperationbodyRevisitor;

public class ChildBOpImpl extends ParentOpImpl implements ChildBOp {
  private TestoperationbodyRevisitor<ChildAOp, ChildBOp, ConceptAOp, MainOp, ParentOp> rev;

  private ChildB obj;

  public ChildBOpImpl(ChildB obj,
      TestoperationbodyRevisitor<ChildAOp, ChildBOp, ConceptAOp, MainOp, ParentOp> rev) {
    super(obj, rev);
    this.obj = obj;
    this.rev = rev;
  }

  public void overriden() {
  }
}
