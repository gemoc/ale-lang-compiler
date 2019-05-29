package test.impl.operation.impl;

import factorydeclorder.B;
import factorydeclorder.revisitor.FactorydeclorderRevisitor;
import test.impl.operation.AOp;
import test.impl.operation.BOp;
import test.impl.operation.COp;
import test.impl.operation.DOp;

public class BOpImpl implements BOp {
  private FactorydeclorderRevisitor<AOp, AOp, AOp, BOp, COp, COp, COp, COp, DOp> rev;

  private B obj;

  public BOpImpl(B obj, FactorydeclorderRevisitor<AOp, AOp, AOp, BOp, COp, COp, COp, COp, DOp> rev) {
    this.obj = obj;
    this.rev = rev;
  }
}
