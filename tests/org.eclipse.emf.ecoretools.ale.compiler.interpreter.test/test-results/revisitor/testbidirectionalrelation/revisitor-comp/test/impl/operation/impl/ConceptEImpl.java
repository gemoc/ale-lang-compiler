package test.impl.operation.impl;

import test.impl.operation.ConceptA;
import test.impl.operation.ConceptB;
import test.impl.operation.ConceptC;
import test.impl.operation.ConceptD;
import test.impl.operation.ConceptE;
import test.impl.operation.ConceptF;
import test.impl.operation.ConceptG;
import testbidirectionalrelation.revisitor.TestbidirectionalrelationRevisitor;

public class ConceptEImpl implements ConceptE {
  private TestbidirectionalrelationRevisitor<ConceptA, ConceptB, ConceptC, ConceptD, ConceptE, ConceptF, ConceptG> rev;

  private testbidirectionalrelation.ConceptE obj;

  public ConceptEImpl(testbidirectionalrelation.ConceptE obj,
      TestbidirectionalrelationRevisitor<ConceptA, ConceptB, ConceptC, ConceptD, ConceptE, ConceptF, ConceptG> rev) {
    this.obj = obj;
    this.rev = rev;
  }
}
