package test.impl.operation.impl;

import test.impl.operation.ConceptAOp;
import test.impl.operation.ConceptBOp;
import test.impl.operation.ConceptCOp;
import test.impl.operation.ConceptDOp;
import test.impl.operation.ConceptEOp;
import test.impl.operation.ConceptFOp;
import test.impl.operation.ConceptGOp;
import testbidirectionalrelation.ConceptC;
import testbidirectionalrelation.revisitor.TestbidirectionalrelationRevisitor;

public class ConceptCOpImpl implements ConceptCOp {
  private TestbidirectionalrelationRevisitor<ConceptAOp, ConceptBOp, ConceptCOp, ConceptDOp, ConceptEOp, ConceptFOp, ConceptGOp> rev;

  private ConceptC obj;

  public ConceptCOpImpl(ConceptC obj,
      TestbidirectionalrelationRevisitor<ConceptAOp, ConceptBOp, ConceptCOp, ConceptDOp, ConceptEOp, ConceptFOp, ConceptGOp> rev) {
    this.obj = obj;
    this.rev = rev;
  }
}
