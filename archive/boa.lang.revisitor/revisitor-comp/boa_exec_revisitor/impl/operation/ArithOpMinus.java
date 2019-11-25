package boa_exec_revisitor.impl.operation;

import boa.Ctx;
import boa.EvalRes;

public interface ArithOpMinus extends ArithOp {
  EvalRes eval(Ctx ctx);
}
