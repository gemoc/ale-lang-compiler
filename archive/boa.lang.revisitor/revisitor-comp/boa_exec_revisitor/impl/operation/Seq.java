package boa_exec_revisitor.impl.operation;

import boa.Ctx;
import boa.EvalRes;

public interface Seq extends Expr {
  EvalRes eval(Ctx ctx);
}
