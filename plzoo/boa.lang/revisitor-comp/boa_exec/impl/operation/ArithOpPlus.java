package boa_exec.impl.operation;

import boa_dynamic.Ctx;
import boa_dynamic.EvalRes;

public interface ArithOpPlus extends ArithOp {
  EvalRes eval(Ctx ctx);
}
