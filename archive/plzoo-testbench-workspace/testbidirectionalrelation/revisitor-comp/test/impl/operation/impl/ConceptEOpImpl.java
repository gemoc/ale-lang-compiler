package test.impl.operation.impl;

import test.impl.operation.ConceptAOp;
import test.impl.operation.ConceptBOp;
import test.impl.operation.ConceptCOp;
import test.impl.operation.ConceptDOp;
import test.impl.operation.ConceptEOp;
import test.impl.operation.ConceptFOp;
import test.impl.operation.ConceptGOp;
import testbidirectionalrelation.ConceptE;
import testbidirectionalrelation.revisitor.TestbidirectionalrelationRevisitor;

public class ConceptEOpImpl implements ConceptEOp {
  private TestbidirectionalrelationRevisitor<ConceptAOp, ConceptBOp, ConceptCOp, ConceptDOp, ConceptEOp, ConceptFOp, ConceptGOp> rev;

  private ConceptE obj;

  public ConceptEOpImpl(ConceptE obj,
      TestbidirectionalrelationRevisitor<ConceptAOp, ConceptBOp, ConceptCOp, ConceptDOp, ConceptEOp, ConceptFOp, ConceptGOp> rev) {
    this.obj = obj;
    this.rev = rev;
  }
}
