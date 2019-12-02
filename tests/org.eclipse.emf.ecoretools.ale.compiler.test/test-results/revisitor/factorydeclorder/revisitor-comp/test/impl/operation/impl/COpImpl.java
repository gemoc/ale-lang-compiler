package test.impl.operation.impl;

import factorydeclorder.C;
import factorydeclorder.revisitor.FactorydeclorderRevisitor;
import test.impl.operation.AOp;
import test.impl.operation.BOp;
import test.impl.operation.COp;
import test.impl.operation.DOp;

public class COpImpl extends BOpImpl implements COp {
  private FactorydeclorderRevisitor<AOp, AOp, AOp, BOp, COp, COp, COp, COp, DOp> rev;

  private C obj;

  public COpImpl(C obj, FactorydeclorderRevisitor<AOp, AOp, AOp, BOp, COp, COp, COp, COp, DOp> rev) {
    super(obj, rev);
    this.obj = obj;
    this.rev = rev;
  }
}
