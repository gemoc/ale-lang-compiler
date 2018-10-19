package boa_exec.impl.operation;

import boa_dynamic.Ctx;
import boa_dynamic.EvalRes;

public interface BoolOpOr extends BoolOp {
  EvalRes eval(Ctx ctx);
}
