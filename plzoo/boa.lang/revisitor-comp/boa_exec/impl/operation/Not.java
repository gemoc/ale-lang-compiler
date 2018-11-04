package boa_exec.impl.operation;

import boa.Ctx;
import boa.EvalRes;

public interface Not extends Expr {
  EvalRes eval(Ctx ctx);
}
