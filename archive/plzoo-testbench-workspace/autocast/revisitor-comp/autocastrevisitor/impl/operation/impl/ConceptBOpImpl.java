package autocastrevisitor.impl.operation.impl;

import autocast.ConceptB;
import autocast.revisitor.AutocastRevisitor;
import autocastrevisitor.impl.operation.ConceptAOp;
import autocastrevisitor.impl.operation.ConceptBOp;
import autocastrevisitor.impl.operation.ConceptCOp;

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
