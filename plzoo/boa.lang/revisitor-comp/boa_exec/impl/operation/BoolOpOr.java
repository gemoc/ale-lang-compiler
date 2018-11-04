package boa_exec.impl.operation;

import boa.Ctx;
import boa.EvalRes;

public interface BoolOpOr extends BoolOp {
  EvalRes eval(Ctx ctx);
}
