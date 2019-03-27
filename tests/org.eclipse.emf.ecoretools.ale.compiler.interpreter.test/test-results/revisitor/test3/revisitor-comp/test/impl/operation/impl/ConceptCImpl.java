package test.impl.operation.impl;

import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;
import test.impl.operation.ConceptA;
import test.impl.operation.ConceptB;
import test.impl.operation.ConceptC;
import test1.revisitor.Test1Revisitor;

public class ConceptCImpl implements ConceptC {
  private Test1Revisitor<ConceptA, ConceptB, ConceptC> rev;

  private test1.ConceptC obj;

  public ConceptCImpl(test1.ConceptC obj, Test1Revisitor<ConceptA, ConceptB, ConceptC> rev) {
    this.obj = obj;
    this.rev = rev;
  }

  public void call() {
    LogService.log(this.obj.getNbr());
  }
}
