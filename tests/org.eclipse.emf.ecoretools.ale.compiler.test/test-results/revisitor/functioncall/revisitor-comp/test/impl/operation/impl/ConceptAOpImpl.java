package test.impl.operation.impl;

import test.impl.operation.ConceptAOp;
import test.impl.operation.ConceptBOp;
import test.impl.operation.ConceptCOp;
import x.y.z.functioncall.ConceptA;
import x.y.z.functioncall.FunctioncallFactory;
import x.y.z.revisitor.FunctioncallRevisitor;

public class ConceptAOpImpl implements ConceptAOp {
  private FunctioncallRevisitor<ConceptAOp, ConceptBOp, ConceptCOp> rev;

  private ConceptA obj;

  public ConceptAOpImpl(ConceptA obj,
      FunctioncallRevisitor<ConceptAOp, ConceptBOp, ConceptCOp> rev) {
    this.obj = obj;
    this.rev = rev;
  }

  public void fct1() {
  }

  public ConceptA fct2() {
    ConceptA result;
    result = ((ConceptA) (FunctioncallFactory.eINSTANCE.createConceptA()));
    return result;
  }
}
