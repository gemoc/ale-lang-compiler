package test.impl.operation.impl;

import autocast.ConceptA;
import autocast.revisitor.AutocastRevisitor;
import test.impl.operation.ConceptAOp;
import test.impl.operation.ConceptBOp;
import test.impl.operation.ConceptCOp;

public class ConceptAOpImpl implements ConceptAOp {
  private AutocastRevisitor<ConceptAOp, ConceptBOp, ConceptCOp> rev;

  private ConceptA obj;

  public ConceptAOpImpl(ConceptA obj, AutocastRevisitor<ConceptAOp, ConceptBOp, ConceptCOp> rev) {
    this.obj = obj;
    this.rev = rev;
  }
}
