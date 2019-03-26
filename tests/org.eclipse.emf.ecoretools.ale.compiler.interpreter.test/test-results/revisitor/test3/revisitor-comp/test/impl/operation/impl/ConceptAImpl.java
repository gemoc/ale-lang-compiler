package test.impl.operation.impl;

import test.impl.operation.ConceptA;
import test.impl.operation.ConceptB;
import test.impl.operation.ConceptC;
import test1.revisitor.Test1Revisitor;

public class ConceptAImpl implements ConceptA {
  private Test1Revisitor<ConceptA, ConceptB, ConceptC> rev;

  private test1.ConceptA obj;

  public ConceptAImpl(test1.ConceptA obj, Test1Revisitor<ConceptA, ConceptB, ConceptC> rev) {
    this.obj = obj;
    this.rev = rev;
  }

  public void exec() {
    org.eclipse.emf.ecoretools.ale.compiler.lib.LogService.log("ok");
    for(test1.ConceptC c: this.obj.getCs()) {
      rev.$(c).call();
    }
  }
}
