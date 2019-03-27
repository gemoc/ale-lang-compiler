package test.impl.operation.impl;

import java.util.Map.Entry;

import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;

import test.impl.operation.ConceptAOp;
import test1.ConceptA;
import test1.revisitor.Test1Revisitor;

public class ConceptAOpImpl implements ConceptAOp {
  private Test1Revisitor<ConceptAOp> rev;

  private ConceptA obj;

  public ConceptAOpImpl(ConceptA obj, Test1Revisitor<ConceptAOp> rev) {
    this.obj = obj;
    this.rev = rev;
  }

  public void exec() {
    for(Entry<String, Integer> c: this.obj.getCs().entrySet()) {
      LogService.log(c.getKey());
      LogService.log(c.getValue());
    }
  }
}
