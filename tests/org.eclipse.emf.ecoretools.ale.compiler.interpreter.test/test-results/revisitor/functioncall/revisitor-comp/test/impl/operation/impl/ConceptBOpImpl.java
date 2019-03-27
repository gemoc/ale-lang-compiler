package test.impl.operation.impl;

import test.impl.operation.ConceptAOp;
import test.impl.operation.ConceptBOp;
import test.impl.operation.ConceptCOp;
import x.y.z.functioncall.ConceptB;
import x.y.z.functioncall.FunctioncallFactory;
import x.y.z.revisitor.FunctioncallRevisitor;

public class ConceptBOpImpl extends ConceptAOpImpl implements ConceptBOp {
  private FunctioncallRevisitor<ConceptAOp, ConceptBOp, ConceptCOp> rev;

  private ConceptB obj;

  public ConceptBOpImpl(ConceptB obj,
      FunctioncallRevisitor<ConceptAOp, ConceptBOp, ConceptCOp> rev) {
    super(obj, rev);
    this.obj = obj;
    this.rev = rev;
  }

  public ConceptB fct2() {
    ConceptB result;
    result = FunctioncallFactory.eINSTANCE.createConceptB();
    return result;
  }
}
