package boa_exec_revisitor.impl.operation;

import boa.Ctx;
import boa.EvalRes;

public interface ArithOpPlus extends ArithOp {
  EvalRes eval(Ctx ctx);
}
