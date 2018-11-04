package boa_exec.impl.operation;

import boa.Ctx;
import boa.EvalRes;

public interface ArithOpDivide extends ArithOp {
  EvalRes eval(Ctx ctx);
}
