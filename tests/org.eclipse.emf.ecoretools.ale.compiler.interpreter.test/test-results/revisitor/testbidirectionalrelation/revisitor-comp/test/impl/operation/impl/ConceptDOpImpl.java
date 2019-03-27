package test.impl.operation.impl;

import test.impl.operation.ConceptAOp;
import test.impl.operation.ConceptBOp;
import test.impl.operation.ConceptCOp;
import test.impl.operation.ConceptDOp;
import test.impl.operation.ConceptEOp;
import test.impl.operation.ConceptFOp;
import test.impl.operation.ConceptGOp;
import testbidirectionalrelation.ConceptD;
import testbidirectionalrelation.revisitor.TestbidirectionalrelationRevisitor;

public class ConceptDOpImpl implements ConceptDOp {
  private TestbidirectionalrelationRevisitor<ConceptAOp, ConceptBOp, ConceptCOp, ConceptDOp, ConceptEOp, ConceptFOp, ConceptGOp> rev;

  private ConceptD obj;

  public ConceptDOpImpl(ConceptD obj,
      TestbidirectionalrelationRevisitor<ConceptAOp, ConceptBOp, ConceptCOp, ConceptDOp, ConceptEOp, ConceptFOp, ConceptGOp> rev) {
    this.obj = obj;
    this.rev = rev;
  }
}
