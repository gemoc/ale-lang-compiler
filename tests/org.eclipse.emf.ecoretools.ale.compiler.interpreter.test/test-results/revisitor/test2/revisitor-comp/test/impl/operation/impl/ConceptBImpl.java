package test.impl.operation.impl;

import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;
import test.impl.operation.ConceptA;
import test.impl.operation.ConceptB;
import test1.revisitor.Test1Revisitor;

public class ConceptBImpl extends ConceptAImpl implements ConceptB {
  private Test1Revisitor<ConceptA, ConceptB> rev;

  private test1.ConceptB obj;

  public ConceptBImpl(test1.ConceptB obj, Test1Revisitor<ConceptA, ConceptB> rev) {
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
