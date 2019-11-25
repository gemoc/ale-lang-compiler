package test.impl.operation.impl;

import test.impl.operation.ChildAOp;
import test.impl.operation.ChildBOp;
import test.impl.operation.ConceptAOp;
import test.impl.operation.MainOp;
import test.impl.operation.ParentOp;
import testoperationbody.ConceptA;
import testoperationbody.revisitor.TestoperationbodyRevisitor;

public class ConceptAOpImpl implements ConceptAOp {
  private TestoperationbodyRevisitor<ChildAOp, ChildBOp, ConceptAOp, MainOp, ParentOp> rev;

  private ConceptA obj;

  public ConceptAOpImpl(ConceptA obj,
      TestoperationbodyRevisitor<ChildAOp, ChildBOp, ConceptAOp, MainOp, ParentOp> rev) {
    this.obj = obj;
    this.rev = rev;
  }

  public boolean op() {
    boolean result;
    result = false;
    return result;
  }
}
