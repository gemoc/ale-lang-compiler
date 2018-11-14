package boa_exec_revisitor.impl.operation;

import boa.Ctx;
import boa.EvalRes;

public interface ArithOpDivide extends ArithOp {
  EvalRes eval(Ctx ctx);
}
