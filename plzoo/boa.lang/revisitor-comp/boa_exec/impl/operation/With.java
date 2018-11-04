package boa_exec.impl.operation;

import boa.Ctx;
import boa.EvalRes;

public interface With extends Expr {
  EvalRes eval(Ctx ctx);
}
