package test.impl.operation.impl;

import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;
import test.impl.operation.ConceptAOp;
import test.impl.operation.ConceptBOp;
import test.impl.operation.ConceptCOp;
import test1.ConceptC;
import test1.revisitor.Test1Revisitor;

public class ConceptCOpImpl implements ConceptCOp {
  private Test1Revisitor<ConceptAOp, ConceptBOp, ConceptCOp> rev;

  private ConceptC obj;

  public ConceptCOpImpl(ConceptC obj, Test1Revisitor<ConceptAOp, ConceptBOp, ConceptCOp> rev) {
    this.obj = obj;
    this.rev = rev;
  }

  public void call() {
    LogService.log(this.obj.getNbr());
  }
}
