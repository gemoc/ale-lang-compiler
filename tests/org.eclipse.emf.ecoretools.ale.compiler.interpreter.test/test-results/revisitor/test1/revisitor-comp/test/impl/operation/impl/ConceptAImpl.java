package test.impl.operation.impl;

import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;
import test.impl.operation.ConceptA;
import test1.revisitor.Test1Revisitor;

public class ConceptAImpl implements ConceptA {
  private Test1Revisitor<ConceptA> rev;

  private test1.ConceptA obj;

  public ConceptAImpl(test1.ConceptA obj, Test1Revisitor<ConceptA> rev) {
    this.obj = obj;
    this.rev = rev;
  }

  public void exec() {
    LogService.log("ok");
    int a = ((int)1);
    this.obj.setB(42);
  }
}
