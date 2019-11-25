package boa_exec_revisitor.impl.operation;

import boa.Ctx;
import boa.EvalRes;

public interface ArithOpTimes extends ArithOp {
  EvalRes eval(Ctx ctx);
}
