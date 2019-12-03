package test.impl.operation.impl;

import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;
import test.impl.operation.EAccOp;
import testaccessors.EAcc;
import testaccessors.revisitor.TestaccessorsRevisitor;

public class EAccOpImpl implements EAccOp {
  private TestaccessorsRevisitor<EAccOp> rev;

  private EAcc obj;

  public EAccOpImpl(EAcc obj, TestaccessorsRevisitor<EAccOp> rev) {
    this.obj = obj;
    this.rev = rev;
  }

  public void logacc() {
    LogService.log(this.obj.isB());
    LogService.log(this.obj.getI());
    LogService.log(this.obj.getBs());
    LogService.log(this.obj.getIs());
  }
}
