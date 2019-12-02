package test.impl.operation.impl;

import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;
import test.impl.operation.ConceptAOp;
import test1unique.ConceptA;
import test1unique.revisitor.Test1uniqueRevisitor;

public class ConceptAOpImpl implements ConceptAOp {
  private Test1uniqueRevisitor<ConceptAOp> rev;

  private ConceptA obj;

  public ConceptAOpImpl(ConceptA obj, Test1uniqueRevisitor<ConceptAOp> rev) {
    this.obj = obj;
    this.rev = rev;
  }

  public void exec() {
    LogService.log("ok");
  }
}
