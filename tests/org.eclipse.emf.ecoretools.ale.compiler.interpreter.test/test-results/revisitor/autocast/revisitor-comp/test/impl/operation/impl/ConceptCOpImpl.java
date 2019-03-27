package test.impl.operation.impl;

import autocast.ConceptA;
import autocast.ConceptB;
import autocast.ConceptC;
import autocast.revisitor.AutocastRevisitor;
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;
import test.impl.operation.ConceptAOp;
import test.impl.operation.ConceptBOp;
import test.impl.operation.ConceptCOp;

public class ConceptCOpImpl implements ConceptCOp {
  private AutocastRevisitor<ConceptAOp, ConceptBOp, ConceptCOp> rev;

  private ConceptC obj;

  public ConceptCOpImpl(ConceptC obj, AutocastRevisitor<ConceptAOp, ConceptBOp, ConceptCOp> rev) {
    this.obj = obj;
    this.rev = rev;
  }

  public void execB(ConceptB b) {
    LogService.log(b.getName());
  }

  public void exec1() {
    for(ConceptA a: this.obj.getAx()) {
      if(a instanceof autocast.ConceptB) {
        rev.$((ConceptC)this.obj).execB(((ConceptB)a));
      }
    }
  }

  public void exec2() {
    for(ConceptA a: this.obj.getAx()) {
      if(a instanceof autocast.ConceptB) {
        ConceptB b = ((ConceptB)a);
        LogService.log(b.getName());
      }
    }
  }

  public void exec3() {
    for(ConceptA a: this.obj.getAx()) {
      if(a instanceof autocast.ConceptB) {
        rev.$((ConceptB)a).callB();
      }
    }
  }
}
