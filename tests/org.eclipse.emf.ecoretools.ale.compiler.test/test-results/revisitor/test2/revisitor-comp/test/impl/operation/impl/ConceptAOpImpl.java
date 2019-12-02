package test.impl.operation.impl;

import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;
import test.impl.operation.ConceptAOp;
import test.impl.operation.ConceptBOp;
import test1.ConceptA;
import test1.revisitor.Test1Revisitor;

public class ConceptAOpImpl implements ConceptAOp {
  private Test1Revisitor<ConceptAOp, ConceptBOp> rev;

  private ConceptA obj;

  public ConceptAOpImpl(ConceptA obj, Test1Revisitor<ConceptAOp, ConceptBOp> rev) {
    this.obj = obj;
    this.rev = rev;
  }

  public void exec() {
    LogService.log("ok");
  }
}
