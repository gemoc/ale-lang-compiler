package boa_exec.impl.operation;

import boa.Ctx;
import boa.EvalRes;

public interface ArithOpRemainder extends ArithOp {
  EvalRes eval(Ctx ctx);
}
