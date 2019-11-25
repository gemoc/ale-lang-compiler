package autocastrevisitor.impl.operation.impl;

import autocast.ConceptA;
import autocast.revisitor.AutocastRevisitor;
import autocastrevisitor.impl.operation.ConceptAOp;
import autocastrevisitor.impl.operation.ConceptBOp;
import autocastrevisitor.impl.operation.ConceptCOp;

public class ConceptAOpImpl implements ConceptAOp {
  private AutocastRevisitor<ConceptAOp, ConceptBOp, ConceptCOp> rev;

  private ConceptA obj;

  public ConceptAOpImpl(ConceptA obj, AutocastRevisitor<ConceptAOp, ConceptBOp, ConceptCOp> rev) {
    this.obj = obj;
    this.rev = rev;
  }
}
