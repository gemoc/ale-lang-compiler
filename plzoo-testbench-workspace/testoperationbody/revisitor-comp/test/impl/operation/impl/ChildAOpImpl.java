package test.impl.operation.impl;

import test.impl.operation.ChildAOp;
import test.impl.operation.ChildBOp;
import test.impl.operation.ConceptAOp;
import test.impl.operation.MainOp;
import test.impl.operation.ParentOp;
import testoperationbody.ChildA;
import testoperationbody.EnumA;
import testoperationbody.revisitor.TestoperationbodyRevisitor;

public class ChildAOpImpl extends ParentOpImpl implements ChildAOp {
  private TestoperationbodyRevisitor<ChildAOp, ChildBOp, ConceptAOp, MainOp, ParentOp> rev;

  private ChildA obj;

  public ChildAOpImpl(ChildA obj,
      TestoperationbodyRevisitor<ChildAOp, ChildBOp, ConceptAOp, MainOp, ParentOp> rev) {
    super(obj, rev);
    this.obj = obj;
    this.rev = rev;
  }

  public void overriden() {
  }

  public EnumA onlyA() {
    EnumA result;
    result = this.obj.getValue();
    return result;
  }
}
