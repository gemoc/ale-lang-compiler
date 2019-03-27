package test.impl.operation.impl;

import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;
import test.impl.operation.ConceptAOp;
import test.impl.operation.ConceptBOp;
import test1.ConceptB;
import test1.revisitor.Test1Revisitor;

public class ConceptBOpImpl extends ConceptAOpImpl implements ConceptBOp {
  private Test1Revisitor<ConceptAOp, ConceptBOp> rev;

  private ConceptB obj;

  public ConceptBOpImpl(ConceptB obj, Test1Revisitor<ConceptAOp, ConceptBOp> rev) {
    super(obj, rev);
    this.obj = obj;
    this.rev = rev;
  }

  public void exec() {
    LogService.log("okb");
  }

  public int execB() {
    int result;
    result = 1;
    return result;
  }
}
