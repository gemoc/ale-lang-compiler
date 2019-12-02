package test.impl.operation.impl;

import autocast.ConceptB;
import autocast.revisitor.AutocastRevisitor;
import test.impl.operation.ConceptAOp;
import test.impl.operation.ConceptBOp;
import test.impl.operation.ConceptCOp;

public class ConceptBOpImpl extends ConceptAOpImpl implements ConceptBOp {
  private AutocastRevisitor<ConceptAOp, ConceptBOp, ConceptCOp> rev;

  private ConceptB obj;

  public ConceptBOpImpl(ConceptB obj, AutocastRevisitor<ConceptAOp, ConceptBOp, ConceptCOp> rev) {
    super(obj, rev);
    this.obj = obj;
    this.rev = rev;
  }

  public void callB() {
  }
}
