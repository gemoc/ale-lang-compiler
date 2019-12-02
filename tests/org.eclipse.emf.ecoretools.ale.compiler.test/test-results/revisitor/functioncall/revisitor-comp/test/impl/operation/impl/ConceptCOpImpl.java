package test.impl.operation.impl;

import test.impl.operation.ConceptAOp;
import test.impl.operation.ConceptBOp;
import test.impl.operation.ConceptCOp;
import x.y.z.functioncall.ConceptA;
import x.y.z.functioncall.ConceptB;
import x.y.z.functioncall.ConceptC;
import x.y.z.revisitor.FunctioncallRevisitor;

public class ConceptCOpImpl implements ConceptCOp {
  private FunctioncallRevisitor<ConceptAOp, ConceptBOp, ConceptCOp> rev;

  private ConceptC obj;

  public ConceptCOpImpl(ConceptC obj,
      FunctioncallRevisitor<ConceptAOp, ConceptBOp, ConceptCOp> rev) {
    this.obj = obj;
    this.rev = rev;
  }

  public void exec1() {
    rev.$((ConceptA)this.obj.getConcepta1()).fct1();
    ConceptA tmpA = ((ConceptA)rev.$((ConceptA)this.obj.getConcepta1()).fct2());
    rev.$((ConceptA)this.obj.getConcepta2()).fct1();
    ConceptA tmpB = ((ConceptA)rev.$((ConceptA)this.obj.getConcepta2()).fct2());
    rev.$((ConceptB)this.obj.getConceptb()).fct1();
    ConceptB tmpC = ((ConceptB)rev.$((ConceptB)this.obj.getConceptb()).fct2());
  }
}
