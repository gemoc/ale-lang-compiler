package test.impl.operation.impl;

import factorydeclorder.A;
import factorydeclorder.revisitor.FactorydeclorderRevisitor;
import test.impl.operation.AOp;
import test.impl.operation.BOp;
import test.impl.operation.COp;
import test.impl.operation.DOp;

public class AOpImpl extends DOpImpl implements AOp {
  private FactorydeclorderRevisitor<AOp, AOp, AOp, BOp, COp, COp, COp, COp, DOp> rev;

  private A obj;

  public AOpImpl(A obj, FactorydeclorderRevisitor<AOp, AOp, AOp, BOp, COp, COp, COp, COp, DOp> rev) {
    super(obj, rev);
    this.obj = obj;
    this.rev = rev;
  }
}
