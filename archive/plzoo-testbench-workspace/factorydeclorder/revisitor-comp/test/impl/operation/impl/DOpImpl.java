package test.impl.operation.impl;

import factorydeclorder.D;
import factorydeclorder.revisitor.FactorydeclorderRevisitor;
import test.impl.operation.AOp;
import test.impl.operation.BOp;
import test.impl.operation.COp;
import test.impl.operation.DOp;

public class DOpImpl implements DOp {
  private FactorydeclorderRevisitor<AOp, AOp, AOp, BOp, COp, COp, COp, COp, DOp> rev;

  private D obj;

  public DOpImpl(D obj, FactorydeclorderRevisitor<AOp, AOp, AOp, BOp, COp, COp, COp, COp, DOp> rev) {
    this.obj = obj;
    this.rev = rev;
  }
}
