package boa_exec.impl.operation;

import boa.Ctx;
import boa.EvalRes;

public interface This extends Expr {
  EvalRes eval(Ctx ctx);
}
