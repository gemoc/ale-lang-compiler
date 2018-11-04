package boa_exec.impl.operation;

import boa.Ctx;
import boa.EvalRes;

public interface BoolOpAnd extends BoolOp {
  EvalRes eval(Ctx ctx);
}
