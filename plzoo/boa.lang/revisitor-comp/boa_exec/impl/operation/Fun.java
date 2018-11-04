package boa_exec.impl.operation;

import boa.Ctx;
import boa.EvalRes;

public interface Fun extends Expr {
  EvalRes eval(Ctx ctx);
}
